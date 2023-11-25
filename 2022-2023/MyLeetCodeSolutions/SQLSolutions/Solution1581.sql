#1581. Customer Who Visited but Did Not Make Any Transactions

SELECT
    customer_id,
    COUNT(visit_id) AS count_no_trans
FROM visits
WHERE visit_id NOT IN(SELECT DISTINCT visit_id FROM Transactions)
GROUP BY customer_id;