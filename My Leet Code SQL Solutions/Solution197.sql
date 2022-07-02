#197. Rising Temperature
SELECT weather.id AS 'Id'
FROM weather 
JOIN weather AS w
ON DATEDIFF(weather.recordDate, w.recordDate) = 1
AND weather.Temperature > w.Temperature;