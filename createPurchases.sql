create table purchases(
OrderID varchar(10) NOT NULL primary key,
EmployeeID int(3) NOT NULL,
MSRP double not null,
Tax double not null,
Ship_Date varchar(25) not null,
Received_Date varchar(25) not null,
InvoiceID varchar(25) not null,
DroneID varchar(25) NOT NULL,
SupplierID varchar(35) NOT NULL
);
