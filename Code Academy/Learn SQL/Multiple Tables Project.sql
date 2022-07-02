#Lyft Trip Data
#1 find the columns
SELECT * FROM trips;
SELECT * FROM riders;
SELECT * FROM cars;

#2 primary keys
#primary key of trips->
#primary key of riders->
#primary key of cars->

#3 cross join between riders and cars
SELECT *
FROM riders, cars;

#4 combine trips and riders using LEFT JOIN
SELECT *
FROM trips
LEFT JOIN riders
  ON trips.rider_id  = riders.id;

#5 combine trips and cars using INNER JOIN
SELECT *
FROM trips 
INNER JOIN cars
  ON trips.rider_id = cars.id;

#6 stack riders table on top of the new table named riders2
SELECT *
FROM riders
UNION
SELECT *
FROM riders2;

#7 average cost for a trip
SELECT AVG(cost)
FROM trips;

#8 find the riders who have used lyft less than 500 times
SELECT *
FROM riders
WHERE total_trips <= 500;

#9 calculate the number of cards that are active
SELECT COUNT(*)
FROM cars
WHERE status LIKE "active";

#10 find the two cars that have the highest trips_completed
SELECT *
FROM cars
ORDER BY trips_completed DESC
LIMIT 2;