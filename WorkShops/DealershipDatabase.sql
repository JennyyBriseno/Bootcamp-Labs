CREATE DATABASE dealership;
USE dealership;

#DEALERSHIPS TABLES
CREATE TABLE dealerships(
DealershipID INT auto_increment,
Name VARCHAR(50) NOT NULL,
Address VARCHAR(50) NOT NULL,
Phone VARCHAR(12),

PRIMARY KEY (DealershipID)
);

INSERT INTO dealerships (Name, Address, Phone)
VALUES('TruBlue Autos','2443 Strawberry Ln','469-445-8009');

#VEHICLES TABLES
CREATE TABLE vehicles(
VIN INT NOT NULL,
Year INT,
VehicleMake VARCHAR(20),
VehicleModel VARCHAR(30),
VehicleType VARCHAR(20),
Color VARCHAR(30),
Odometer INT, 
Price DECIMAL(10,3) NOT NULL,
Sold BIT NOT NULL,

PRIMARY KEY (VIN)
);

INSERT INTO vehicles (VIN, Year, VehicleMake, VehicleModel, VehicleType, Color, Odometer, Price, Sold)
VALUES(10112, 1993, 'Ford', 'Explorer', 'SUV', 'Red', 525123, 995.0, 1),
(37846, 2001, 'Ford', 'Ranger', 'Truck', 'Yellow', 172544, 1995.0, 0),
(44901, 2012, 'Honda', 'Civic', 'SUV', 'Gray', 103221, 6995.0, 1),
(50876, 2008, 'Toyota', 'Camry', 'Sedan', 'Silver', 135421, 8995.0, 0),
(65432, 2015, 'Chevrolet', 'Silverado', 'Truck', 'Black', 78000, 21995.0, 1),
(78901, 2019, 'Nissan', 'Altima', 'Sedan', 'White', 32000, 17995.0, 1),
(85479, 2005, 'Jeep', 'Wrangler', 'SUV', 'Green', 93000,12995.0, 1),
(92345, 2018, 'Subaru','Outback', 'SUV', 'Blue', 40000, 24995.0, 0);

#INVENTORY TABLE 
CREATE TABLE inventory(
VIN INT NOT NULL,
DealershipID INT auto_increment NOT NULL,

FOREIGN KEY (VIN) REFERENCES vehicles (VIN),
FOREIGN KEY (DealershipID) REFERENCES dealerships(DealershipID)
);

INSERT INTO inventory(DealershipID, VIN)
VALUES(1, 10112),(1, 37846),(1, 44901),(1, 50876),(1, 65432),(1, 78901),(1, 85479),
(1, 92345);

#SALES CONTRACT
CREATE TABLE salescontracts(
SalesContractDate DATE NOT NULL,
SalesContractID INT auto_increment,
SalesTaxAmount DECIMAL(10,3),
RecordingFee INT NOT NULL,
ProcessingFee INT NOT NULL,
CustomerName VARCHAR(50) NOT NULL,
CustomerEmail VARCHAR(50),
VehicleVin  INT NOT NULL,

PRIMARY KEY (SalesContractID),
FOREIGN KEY (VehicleVin) REFERENCES vehicles (VIN)
);

INSERT INTO salescontracts(VehicleVin, CustomerName, CustomerEmail, SalesContractDate, SalesTaxAmount, RecordingFee, ProcessingFee)
VALUES(10112, 'Dana Wyatt','DanaWyatt55@gmail.com','2024-01-05' ,49.75, 100, 295),
(44901, 'Robert Luna','RobertLuna443@gmail.com', '2023-12-01', 92.12, 100, 295),
(65432,'Karla Dominguez','KDominguez228@gmail.com', '2024-01-01', 545.34, 100, 495),
(78901, 'Jody Wilcox','WilcoxOfficialJody.gmail.com', '2023-08-23', 368.88, 100, 495);

CREATE TABLE leasecontracts(
LeaseContractID INT auto_increment,
LeaseContractDate DATE NOT NULL,
CustomerName VARCHAR(50) NOT NULL,
CustomerEmail VARCHAR(50),
VehicleVin INT NOT NULL,
ExpectedEndingValue DECIMAL(10,3) NOT NULL,
LeaseFee DECIMAL(10,3) NOT NULL,
MonthlyPayment DECIMAL(10,3),

PRIMARY KEY (LeaseContractID),
FOREIGN KEY(VehicleVin) REFERENCES vehicles(VIN)
);

INSERT INTO leasecontracts(VehicleVin, CustomerName, CustomerEmail, LeaseContractDate, ExpectedEndingValue, LeaseFee, MonthlyPayment)
VALUES(85479, 'Monse Luna', 'MonseLuna554@gmail.com', '2021-06-17', 6497.5,909.65, 250.88);

#TESTING
/*
SELECT *
FROM dealerships;

SELECT *
FROM inventory
JOIN vehicles ON inventory.VIN = vehicles.VIN
WHERE DealershipID = 1;

SELECT *
FROM vehicles
WHERE VIN = 65432;

SELECT dealerships.DealershipID, dealerships.Name, dealerships.Address, dealerships.Phone
FROM dealerships
JOIN inventory ON dealerships.DealershipID = inventory.DealershipID
WHERE inventory.VIN = 92345;

SELECT dealerships.DealershipID, dealerships.Name, dealerships.Address, dealerships.Phone
FROM dealerships
JOIN inventory ON dealerships.DealershipID = inventory.DealershipID
JOIN vehicles ON inventory.VIN = vehicles.VIN
WHERE vehicles.Color = 'Gray' AND vehicles.VehicleMake = 'Honda' AND vehicles.VehicleModel = 'Civic';

SELECT *
FROM salescontracts
JOIN inventory ON salescontracts.VehicleVIn = inventory.VIN 
WHERE inventory.DealershipID = 1 AND salescontracts.SalesContractDate BETWEEN '2023-12-01' AND '2024-02-01';

SELECT *
FROM leasecontracts
JOIN inventory ON leasecontracts.VehicleVIn = inventory.VIN 
WHERE inventory.DealershipID = 1 AND leasecontracts.LeaseContractDate BETWEEN '2021-01-01' AND '2022-01-01';
*/

