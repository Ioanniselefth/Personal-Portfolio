#183. Customers Who Never Order
SELECT
    Customers.name AS "Customers"
FROM
    Customers
WHERE
    Customers.id NOT IN (SELECT customerid FROM orders);
