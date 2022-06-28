# 1757. Recyclable and Low Fat Products
SELECT 
    product_id
FROM
    Products
WHERE
    low_fats LIKE "Y" AND recyclable LIKE "Y";
    