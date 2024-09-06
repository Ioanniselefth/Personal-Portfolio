import com.amdocs.bl.common.util.CommonConstants;
import com.amdocs.bl.common.util.RouteHelper;
import com.amdocs.bl.common.util.ValidationException;
import com.amdocs.bl.main.data.model.SubscriberIdentifier;
import com.amdocs.bl.productcatalog.custom.data.model.*;
import com.amdocs.bl.productcatalog.data.model.*;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultExchange;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetProposalsBeanAsync {
    public static final String NBA_TEEO = "NBA TEEO";
    public static final String NBO_TEEO = "NBO TEEO";
    public static final String OPT_IN_KEYWORD = "Opt-in Keyword";
    public static final String MARKETING_NAME_EN = "Marketing Name EN";
    public static final String SERVICE_EXTERNAL_ID_FAILURE = "Can not retrieve serviceExternalId";
    public static final String ANY_ACTION = "Any_Action";
    ProductCatalogCommonBean productCatalogCommonBean = new ProductCatalogCommonBean();
    private static final Logger log = LoggerFactory.getLogger(GetProposalsBean.class);
    private Boolean isMock;
    private int numOfServices = 0;

    public void getProposals(Exchange exchange) throws Exception {
        log.info("start: getProposals");
        GetExtProposalsRequest getExtProposalsRequest = exchange.getIn().getBody(GetExtProposalsRequest.class);
        String presentationContext = getExtProposalsRequest.getPresentationContext();

        // Fetch serviceExternalId asynchronously
        CompletableFuture<List<String>> serviceExternalIdFuture = getServiceExternalIdAsync(exchange, getExtProposalsRequest);

        // Get posId asynchronously
        CompletableFuture<String> posIdFuture = getPosIdAsync(exchange);

        List<String> serviceExternalId = serviceExternalIdFuture.get();
        String posId = posIdFuture.get();

        List<GetProposalsRequest> getProposalsRequests = IntStream.range(0, numOfServices)
                .mapToObj(counter -> setRequestBodyToCMP(serviceExternalId.get(counter), posId))
                .collect(Collectors.toList());

        // Fetch proposals asynchronously
        List<CompletableFuture<GetProposalsResponse>> futures = getProposalsRequests.stream()
                .map(request -> callGetAvailableOffersAndGetResponseAsync(exchange, request))
                .collect(Collectors.toList());

        List<GetProposalsResponse> getProposalsResponses = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        // Handle responses
        processProposalsResponses(exchange, getExtProposalsRequest, presentationContext, getProposalsResponses, serviceExternalId);

        log.info("finish: getProposals");
    }

    private void processProposalsResponses(Exchange exchange, GetExtProposalsRequest getExtProposalsRequest, String presentationContext, List<GetProposalsResponse> getProposalsResponses, List<String> serviceExternalId) throws ValidationException {
        List<GetProposalItem> getProposalItemList = new ArrayList<>();
        GetExtProposalsResponse getExtProposalsResponse = new GetExtProposalsResponse();

        for (GetProposalsResponse getProposalsResponse : getProposalsResponses) {
            if (Objects.isNull(getProposalsResponse.getStatus())) {
                throwValidationException(exchange, "Error from CMP");
            }

            if ("0".equals(getProposalsResponse.getOffersCount())) {
                String description = getProposalsResponse.getDescription() + " - " + serviceExternalId;
                getProposalsResponse.setDescription(description);
                exchange.getOut().setBody(getProposalsResponse);
                return;
            } else {
                if ("AccountSummary".equals(presentationContext) || "ViewAllPromotions".equals(presentationContext)) {
                    getProposalItemList.addAll(mapCMPResponseNBO(getProposalsResponse, getExtProposalsRequest));
                } else {
                    getProposalItemList.addAll(mapCMPResponseNBA(getProposalsResponse));
                }
            }
        }

        getExtProposalsResponse.setExternalProposals(getProposalItemList);
        exchange.getOut().setBody(getExtProposalsResponse);
    }

    private CompletableFuture<GetProposalsResponse> callGetAvailableOffersAndGetResponseAsync(Exchange exchange, GetProposalsRequest getProposalsRequest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Exchange newExchange = new DefaultExchange(exchange.getContext());
                String toEndpoint = "cmpservice://getProposals";
                newExchange.getIn().getHeaders().putAll(exchange.getIn().getHeaders());
                newExchange.getIn().setBody(getProposalsRequest);
                RouteHelper.sendRequest(productCatalogCommonBean.getProducerTemplate(newExchange), toEndpoint, newExchange);
                log.debug("Response from CMP : {}", newExchange.getIn().getBody(JSONObject.class));
                return productCatalogCommonBean.deserializeOutput(exchange, newExchange.getIn().getBody(JSONObject.class), GetProposalsResponse.class);
            } catch (Exception e) {
                log.error("Error in callGetAvailableOffersAndGetResponse: {}", e.getMessage());
                throw new RuntimeException("Error in callGetAvailableOffersAndGetResponse", e);
            }
        });
    }

    private CompletableFuture<String> getPosIdAsync(Exchange exchange) {
        return CompletableFuture.supplyAsync(() -> {
            isMock = exchange.getProperty("MockComponentEndpoint", false, Boolean.class);
            String userId = exchange.getIn().getHeader("user-id", String.class);
            log.info("start: getPosId");

            String uri = productCatalogCommonBean.getPropertyFieldFromExchange(exchange, "bil.v2usermgmt.ms");
            if (Objects.isNull(uri)) {
                throwValidationException(exchange, "Can not retrieve usermgmt_ms Uri");
            }

            StringBuilder sb = new StringBuilder();
            sb.append(uri).append("/users/").append(userId);
            Exchange newExchange = new DefaultExchange(exchange.getContext());
            newExchange.getIn().setHeaders(exchange.getIn().getHeaders());

            try {
                productCatalogCommonBean.callMicroService(exchange, newExchange, sb.toString(), null, CommonConstants.HTTPMethod.GET, null, isMock);

                if (Objects.nonNull(newExchange.getException())) {
                    throwValidationException(exchange, "Error Retrieving posId");
                }

                HashMap response = newExchange.getIn().getBody(HashMap.class);
                HashMap userObj = (HashMap) response.get("user");
                HashMap attributesObj = (HashMap) userObj.get("attributes");
                List posIdArray = (List) attributesObj.get("posId");
                String posId = (String) posIdArray.get(0);

                if ("".equals(posId)) {
                    throwValidationException(exchange, "Can not retrieve posId");
                }

                log.info("finish: getPosId");
                return posId;
            } catch (Exception e) {
                log.error("Unable to fetch posId due to {}", e.getMessage());
                throw new RuntimeException(e);
            }
        });
    }

    private GetProposalsRequest setRequestBodyToCMP(String serviceExternalId, String posId) {
        log.info("start: setRequestBodyToCMP");
        GetProposalsRequest getProposalsRequest = new GetProposalsRequest();
        //For phase 1 only MSISND(type = 0) will be used
        getProposalsRequest.setUserIdentityType("0");
        getProposalsRequest.setUserIdentity(serviceExternalId);

        FilteringParameters filteringParameters = new FilteringParameters();
        List<Source> sources = new ArrayList<>();

        Source source1 = new Source();
        source1.setType("cr");
        source1.setMaxOffersCount("70");
        sources.add(source1);

        Source source2 = new Source();
        source2.setType("r");
        source2.setMaxOffersCount("70");
        RecoOffersStrategies recoOffersStrategies = new RecoOffersStrategies();
        String[] category = {NBO_TEEO, NBA TEEO};
        recoOffersStrategies.setCategory(category);
        source2.setRecoOffersStrategies(recoOffersStrategies);
        sources.add(source2);

        filteringParameters.setSource(sources);
        filteringParameters.setUseCaseType("");
        getProposalsRequest.setFilteringParameters(filteringParameters);

        SortingParameters sortingParameters = new SortingParameters();
        String[] parameter = {"offer:campaignPriority"};
        sortingParameters.setParameter(parameter);
        sortingParameters.setOrder("Asc");

        getProposalsRequest.setSortingParameters(sortingParameters);
        String[] poAttributes = {OPT_IN_KEYWORD, MARKETING_NAME_EN, "Text 1", "Text 2"};
        getProposalsRequest.setPoAttribute(poAttributes);
        String[] requestedStatParameters = {"105979", "105939", "75139"};
        getProposalsRequest.setRequestedStatParameters(requestedStatParameters);

        List<RequestContext> requestContexts = new ArrayList<>();
        RequestContext requestContext1 = new RequestContext();
        requestContext1.setContextAttributeType("20433");
        requestContext1.setContextAttributeValue("TEEO");
        RequestContext requestContext2 = new RequestContext();
        requestContext2.setContextAttributeType("20448");
        requestContext2.setContextAttributeValue(posId);
        RequestContext requestContext3 = new RequestContext();
        requestContext3.setContextAttributeType("25482");
        requestContext3.setContextAttributeValue("");
        requestContexts.add(requestContext1);
        requestContexts.add(requestContext2);
        requestContexts.add(requestContext3);
        getProposalsRequest.setRequestContext(requestContexts);

        log.info("finish: setRequestBodyToCMP");
        return getProposalsRequest;
    }

    private CompletableFuture<List<String>> getServiceExternalIdAsync(Exchange exchange, GetExtProposalsRequest getExtProposalsRequest) {
        return CompletableFuture.supplyAsync(() -> {
            isMock = exchange.getProperty("MockComponentEndpoint", false, Boolean.class);
            int accountInternalId = getExtProposalsRequest.getAccountInternalId();
            List<SubscriberIdentifier> services = getExtProposalsRequest.getServices();
            numOfServices = services.size();
            log.info("start: getServiceExternalId");

            String uri = productCatalogCommonBean.getPropertyFieldFromExchange(exchange, "bil.serviceinventory.ms");
            if (Objects.isNull(uri)) {
                throwValidationException(exchange, "Can not retrieve serviceinventory_ms Uri");
            }

            List<CompletableFuture<String>> futures = IntStream.range(0, numOfServices)
                    .mapToObj(counter -> fetchServiceExternalIdAsync(exchange, uri, accountInternalId, services.get(counter), isMock))
                    .collect(Collectors.toList());

            List<String> serviceExternalIds;
            try {
                serviceExternalIds = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                        .thenApply(v -> futures.stream()
                                .map(CompletableFuture::join)
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList()))
                        .get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error fetching service external IDs", e);
            }

            // Check if any serviceExternalId is empty and handle exception if needed
            for (String externalId : serviceExternalIds) {
                if ("".equals(externalId)) {
                    log.error("Retrieved an empty serviceExternalId");
                    throwValidationException(exchange, SERVICE_EXTERNAL_ID_FAILURE);
                }
            }

            log.info("finish: getServiceExternalId");
            return serviceExternalIds;
        });
    }

    private CompletableFuture<String> fetchServiceExternalIdAsync(Exchange exchange, String uri, int accountInternalId, SubscriberIdentifier service, boolean isMock) {
        return CompletableFuture.supplyAsync(() -> {
            int serviceInternalId = service.getServiceInternalId();
            int serviceInternalIdResets = service.getServiceInternalIdResets();

            StringBuilder sb = new StringBuilder();
            sb.append(uri)
                    .append("/customeraccounts/")
                    .append(accountInternalId)
                    .append("/customerfacingservices/")
                    .append(serviceInternalId)
                    .append("%2C")
                    .append(serviceInternalIdResets);

            Exchange newExchange = new DefaultExchange(exchange.getContext());
            newExchange.getIn().setHeaders(exchange.getIn().getHeaders());

            log.info("Thread: {}, Calling microservice for serviceInternalId: {}, serviceInternalIdResets: {}",
                    Thread.currentThread().getName(), serviceInternalId, serviceInternalIdResets);

            try {
                productCatalogCommonBean.callMicroService(exchange, newExchange, sb.toString(), null, CommonConstants.HTTPMethod.GET, null, isMock);

                if (Objects.nonNull(newExchange.getException())) {
                    log.error("Error retrieving serviceExternalId for serviceInternalId: {}, serviceInternalIdResets: {}",
                            serviceInternalId, serviceInternalIdResets);
                    throw new RuntimeException("Error Retrieving serviceExternalId");
                }

                HashMap response = newExchange.getIn().getBody(HashMap.class);
                log.debug("Thread: {}, customerfacingservices response for serviceInternalId: {}, serviceInternalIdResets: {}: {}",
                        Thread.currentThread().getName(), serviceInternalId, serviceInternalIdResets, response);
                String externalId = (String) response.get("serviceExternalId");

                if (Objects.nonNull(externalId)) {
                    log.info("Thread: {}, Retrieved serviceExternalId: {} for serviceInternalId: {}, serviceInternalIdResets: {}",
                            Thread.currentThread().getName(), externalId, serviceInternalId, serviceInternalIdResets);
                    return externalId;
                } else {
                    log.error("Failed to retrieve serviceExternalId for serviceInternalId: {}, serviceInternalIdResets: {}",
                            serviceInternalId, serviceInternalIdResets);
                    throw new RuntimeException(SERVICE_EXTERNAL_ID_FAILURE);
                }
            } catch (Exception e) {
                log.error("Unable to fetch serviceExternalId due to {}", e.getMessage());
                return null;
            }
        });
    }

    private ArrayList<GetProposalItem> mapCMPResponseNBO(GetProposalsResponse getProposalsResponse, GetExtProposalsRequest getExtProposalsRequest) {
        log.info("start: mapCMPResponseNBO");
        ArrayList<GetProposalItem> extProposalsResponse = new ArrayList<>();

        List<Offer> offers = getProposalsResponse.getOffer();

        for (Offer offerItem : offers) {
            if (NBA TEEO.equals(offerItem.getProductOffering().getRecoOffersStrategy().getCategory())) {
                continue;
            }
            GetProposalItem proposalItem = new GetProposalItem();

            String optInKeywordValue = "";
            String marketingNameENValue = "";

            List<POAttribute> poAttributes = offerItem.getProductOffering().getPoAttribute();
            for (POAttribute poAttribute : poAttributes) {
                if (OPT IN KEYWORD.equals(poAttribute.getName())) {
                    optInKeywordValue = poAttribute.getValue();
                } else if (MARKETING NAME EN.equals(poAttribute.getName())) {
                    marketingNameENValue = poAttribute.getValue();
                }
            }

            //TODO remove hardcoded values
            proposalItem.setTargetedObjectIdType(8012);
            proposalItem.setExperienceId("expId_1");
            proposalItem.setSelectionMode("aia");

            List<SubscriberIdentifier> services = getExtProposalsRequest.getServices();

            ///TODO handle TargetedObjectInternalId differently for NSA (set it as account internal id)
            proposalItem.setTargetedObjectInternalId(services.get(0).getServiceInternalId());
            proposalItem.setTargetedObjectInternalIdResets(services.get(0).getServiceInternalIdResets());
            proposalItem.setTargetedObjectType(marketingNameENValue);
            proposalItem.setTargetedObjectId(offerItem.getProductOffering().getRecoOffersStrategy().getId());
            if (!"".equals(optInKeywordValue)) {
                proposalItem.setProductOfferingId(Integer.valueOf(optInKeywordValue));
            }
            if (Objects.nonNull(offerItem.getCampaignPriority())) {
                proposalItem.setRank(Integer.valueOf(offerItem.getCampaignPriority()));
            }
            proposalItem.setType(offerItem.getProductOffering().getCategory());

            CategoryPresentationInfo categoryPresentationInfo = new CategoryPresentationInfo();
            categoryPresentationInfo.setShortDescription(offerItem.getShortDescription());
            proposalItem.setCategoryPresentationInfo(categoryPresentationInfo);

            ProposalPresentationInfo proposalPresentationInfo = new ProposalPresentationInfo();
            proposalPresentationInfo.setShortDescription(marketingNameENValue);
            proposalPresentationInfo.setFullDescription(offerItem.getProductOffering().getName());
            proposalPresentationInfo.setStartDate(offerItem.getCampaignStartTime());
            proposalPresentationInfo.setEndDate(offerItem.getCampaignEndTime());
            proposalItem.setProposalPresentationInfo(proposalPresentationInfo);

            proposalItem.setProposalId(optInKeywordValue);

            extProposalsResponse.add(proposalItem);
        }
        log.info("finish: mapCMPResponseNBO");
        return extProposalsResponse;
    }

    private ArrayList<GetProposalItem> mapCMPResponseNBA(GetProposalsResponse getProposalsResponse) {
        log.info("start: mapCMPResponseNBA");
        ArrayList<GetProposalItem> extProposalsResponse = new ArrayList<>();

        List<Offer> offers = getProposalsResponse.getOffer();

        //if the offer is not an NBA, ignore it
        for (Offer offerItem : offers) {
            if (!(NBA TEEO.equals(offerItem.getProductOffering().getRecoOffersStrategy().getCategory()))) {
                continue;
            }
            GetProposalItem proposalItem = new GetProposalItem();

            String marketingNameENValue = "";
            String optInKeywordValue = "";
            String text1 = "";
            String nbaType = "";

            List<POAttribute> poAttributes = offerItem.getProductOffering().getPoAttribute();
            for (POAttribute poAttribute : poAttributes) {
                if (MARKETING NAME EN.equals(poAttribute.getName())) {
                    marketingNameENValue = poAttribute.getValue();
                } else if (OPT IN KEYWORD.equals(poAttribute.getName())) {
                    optInKeywordValue = poAttribute.getValue();
                } else if ("Text 1".equals(poAttribute.getName())) {
                    text1 = poAttribute.getValue();
                } else if ("Text 2".equals(poAttribute.getName())) {
                    nbaType = poAttribute.getValue();
                }
            }

            if (Objects.nonNull(offerItem.getCampaignPriority())) {
                proposalItem.setRank(Integer.valueOf(offerItem.getCampaignPriority()));
            }

            /*Supported proposalItem types are:
            "Any_Action"-display information, external redirection, registration(in combination with selectionMode="aia")
            "Predefined_Action" for displaying an action(with combination with any valid actionCode - internal redirection)
            Currently only "Any_Action" is supported since no actionCode is provided*/

            ProposalPresentationInfo proposalPresentationInfo = new ProposalPresentationInfo();
            proposalPresentationInfo.setFullDescription(marketingNameENValue);
            proposalPresentationInfo.setShortDescription(offerItem.getProductOffering().getName());

            if ("Registration".equals(nbaType)) {
                proposalItem.setSelectionMode("aia"); //"aia" is showing accept button on the NBA
                proposalItem.setType(ANY_ACTION);
                proposalPresentationInfo.setShortDescription(marketingNameENValue);
                proposalPresentationInfo.setFullDescription(text1);
            } else if ("LocalLink".equals(nbaType)) {
                proposalItem.setSelectionMode("channel"); //"channel" is for internal redirection
                proposalItem.setType("Predefined_Action");
                proposalPresentationInfo.setActionCode(text1);
            } else if ("ExtLink".equals(nbaType)) {
                proposalItem.setType(ANY_ACTION);
                proposalPresentationInfo.setUrl(text1);
            } else if ("Info".equals(nbaType)) {
                proposalItem.setType(ANY_ACTION);
                proposalPresentationInfo.setShortDescription(marketingNameENValue);
                proposalPresentationInfo.setFullDescription(text1);
            }

            proposalPresentationInfo.setStartDate(offerItem.getCampaignStartTime());
            proposalPresentationInfo.setEndDate(offerItem.getCampaignEndTime());
            proposalItem.setProposalPresentationInfo(proposalPresentationInfo);

            proposalItem.setProposalId(optInKeywordValue);

            extProposalsResponse.add(proposalItem);
        }

        log.info("finish: mapCMPResponseNBA");
        return extProposalsResponse;
    }

    private void throwValidationException(Exchange exchange, String message) throws ValidationException {
        exchange.setProperty("ResponseCode", "3220242");
        exchange.setProperty(ProductCatalogCommonBean.ERROR_MSG_SUBST_CONST, message);
        exchange.setProperty("HttpResponseCode", ProductCatalogCommonBean.HTTP_ERROR_RESPONSE_CODE);
        throw new ValidationException();
    }
}
