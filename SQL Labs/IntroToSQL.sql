#Single line comments
/*
< > <= >= = <> !=
*/
SELECT * 
FROM northwind.products
WHERE UnitsInStock < 30;

SELECT *
FROM products
WHERE CategoryID <> 1;

#Compound Where clauses AND/OR
#I want products that are dairy products or beverages
SELECT *
FROM products
WHERE CategoryID = 1 OR CategoryID = 4;

#if you have a list of options
#I want all products that are beverages, dairy products, or produce
SELECT *
FROM products
WHERE CategoryID IN(1,4,7);

#I want orders shipped to france
#single quotes for strings
SELECT *
FROM orders
WHERE ShipCountry = 'France';

#I want orders shipped after 1996-09-01
SELECT *
FROM orders
WHERE ShippedDate > '1996-09-01';

#I want orders shipped between sep and oct of 1996
SELECT * 
FROM orders
WHERE ShippedDate BETWEEN '1996-09-01' AND '1996-10-01';

#I want orders where the shippingName starts with 'R'
SELECT *
FROM orders
WHERE ShipName 
LIKE 'R%';

#I want orders where the shipName contains the word super
SELECT *
FROM orders 
WHERE ShipName
LIKE '%super%';

#ORDERING STUFF
SELECT *
FROM orders
WHERE Freight > 20
ORDER BY ShipCountry;

#if you dont like the order put 'DESC' after 
SELECT * 
FROM orders
ORDER BY ShipCountry DESC;

#'=' wont work for null values(IS OR IS NOT)
SELECT * 
FROM customers
WHERE Region IS null;

#weed out duplicates put 'distict' in the column you want
SELECT DISTINCT(Country)
FROM customers
ORDER BY Country;