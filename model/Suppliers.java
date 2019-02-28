package model;

public class Suppliers {
	private String SupplierID;
	private int DroneID;
	private String Email;
	private String Phone;
	private String VendorFirstName;
	private String VendorLastName;
	private String Service_Number;
	
	public Suppliers() {
		this.SupplierID = "none";
		this.DroneID = 1;
		this.Email = "none";
		this.Phone = "none";
		this.VendorFirstName = "none";
		this.VendorLastName= "none";
		this.VendorLastName="none";
		this.Service_Number = "none";
		
		
	}

	public Suppliers(String supplierID, int droneID, String email, String phone, String vendorFirstName,
			String vendorLastName, String service_Number) {
		SupplierID = supplierID;
		DroneID = droneID;
		Email = email;
		Phone = phone;
		VendorFirstName = vendorFirstName;
		VendorLastName = vendorLastName;
		Service_Number = service_Number;
	}

	public String getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}

	public int getDroneID() {
		return DroneID;
	}

	public void setDroneID(int droneID) {
		DroneID = droneID;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getVendorFirstName() {
		return VendorFirstName;
	}

	public void setVendorFirstName(String vendorFirstName) {
		VendorFirstName = vendorFirstName;
	}

	public String getVendorLastName() {
		return VendorLastName;
	}

	public void setVendorLastName(String vendorLastName) {
		VendorLastName = vendorLastName;
	}

	public String getService_Number() {
		return Service_Number;
	}

	public void setService_Number(String service_Number) {
		Service_Number = service_Number;
	}

	@Override
	public String toString() {
		return "Suppliers [SupplierID=" + SupplierID + ", DroneID=" + DroneID + ", Email=" + Email + ", Phone=" + Phone
				+ ", VendorFirstName=" + VendorFirstName + ", VendorLastName=" + VendorLastName + ", Service_Number="
				+ Service_Number + "]";
	}

	
}
