package model;

public class Purchases {
private String OrderID;
private int EmployeeID;
private double MSRP;
private double Tax;
private String Ship_Date;
private String Received_Date;
private String InvoiceID;
private String DroneID;
private String SupplierID;

public Purchases() {
	this.OrderID="1";
	this.EmployeeID=001;
	this.MSRP = 0.00;
	this.Tax = 0.00;
	this.Ship_Date="";
	this.Received_Date = "";
	this.InvoiceID="";
	this.DroneID="";
	this.SupplierID="";
	
}
public Purchases(String orderID, int employeeID, float mSRP, double tax, String ship_Date, String received_Date,
		String invoiceID, String droneID, String supplierID) {

	OrderID = orderID;
	EmployeeID = employeeID;
	MSRP = mSRP;
	Tax = tax;
	Ship_Date = ship_Date;
	Received_Date = received_Date;
	InvoiceID = invoiceID;
	DroneID = droneID;
	SupplierID = supplierID;
}
public String getOrderID() {
	return OrderID;
}
public void setOrderID(String orderID) {
	OrderID = orderID;
}
public int getEmployeeID() {
	return EmployeeID;
}
public void setEmployeeID(int employeeID) {
	EmployeeID = employeeID;
}
public double getMSRP() {
	return MSRP;
}
public void setMSRP(double mSRP) {
	MSRP = mSRP;
}
public double getTax() {
	return Tax;
}
public void setTax(double tax) {
	Tax = tax;
}
public String getShip_Date() {
	return Ship_Date;
}
public void setShip_Date(String ship_Date) {
	Ship_Date = ship_Date;
}
public String getReceived_Date() {
	return Received_Date;
}
public void setReceived_Date(String received_Date) {
	Received_Date = received_Date;
}
public String getInvoiceID() {
	return InvoiceID;
}
public void setInvoiceID(String invoiceID) {
	InvoiceID = invoiceID;
}
public String getDroneID() {
	return DroneID;
}
public void setDroneID(String droneID) {
	DroneID = droneID;
}
public String getSupplierID() {
	return SupplierID;
}
public void setSupplierID(String supplierID) {
	SupplierID = supplierID;
}
@Override
public String toString() {
	return "Purchases [OrderID=" + OrderID + ", EmployeeID=" + EmployeeID + ", MSRP=" + MSRP + ", Tax=" + Tax
			+ ", Ship_Date=" + Ship_Date + ", Received_Date=" + Received_Date + ", InvoiceID=" + InvoiceID
			+ ", DroneID=" + DroneID + ", SupplierID=" + SupplierID + "]";
}


}
