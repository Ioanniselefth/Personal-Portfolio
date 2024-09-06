public class AmoundExceptionRunner {
    public static void main(String[] args) {
        Amounts amount1 = new Amounts("USD", 10);
        //Amount amount2 = new Amount("USD", 20);
        Amounts amount2 = new Amounts("EUR", 20);
        try {
            amount1.add(amount2);
            System.out.println(amount1);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class CurrenciesDoNotMatchException extends Exception {
    public CurrenciesDoNotMatchException(String msg) {
        super(msg);
    }
}
    
class Amounts {
    private String currency;
    private int amount;
    
    public Amounts(String currency, int amount) {
        super();
        this.currency = currency;
        this.amount = amount;
    }
    
    public void add(Amounts that) throws Exception {
        if(!this.currency.equals(that.currency)) {
            throw new CurrenciesDoNotMatchException("Currencies Don't Match : " + this.currency + " & "+that.currency);
        }
        this.amount += that.amount;
    }
        
    
    public Sring toString() {
        return amount + " " + currency;
    }
}