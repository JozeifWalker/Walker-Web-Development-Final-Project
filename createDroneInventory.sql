CREATE TABLE droneInventory(
DroneID varchar(25) NOT NULL primary key,
Make varchar(25) NOT NULL,
Model varchar(25) NOT NULL,
Year int NOT NULL,
Last_Service_Date varchar(25) not null,
Service_Location_City varchar(35),
Service_Location_State varchar(2),
Vin varchar(25) not null
);