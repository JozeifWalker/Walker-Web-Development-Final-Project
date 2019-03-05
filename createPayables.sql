create table payables(
InvoiceID varchar(25) not null primary key,
Amount_charged double not null,
due_date varchar(20) not null,
date_paid varchar(20) not null,
status varchar(20) not null
)

