package model;

public class Inventory {
	private int DroneID;
	private String Make;
	private String Model;
	private int Year;
	private String Last_Service_Date;
	private String Service_Location_City;
	private String Service_Location_State;
	private String Vin;
	

public Inventory() {
	this.DroneID = 1;
	this.Make = "no Make";
	this.Model = "no Model";
	this.Year = 0;
	this.Last_Service_Date = "";
	this.Service_Location_City = "none";
	this.Service_Location_State = "none";
	this.Vin = "none";
}


public Inventory(int DroneID,String Make,String Model,int Year,String
		Last_Service_Date,String Service_Location_City,String Service_Location_State,String Vin) {
	this.DroneID = DroneID;
	this.Make = Make;
	this.Model = Model;
	this.Year = Year;
	this.Last_Service_Date = Last_Service_Date;
	this.Service_Location_City = Service_Location_City;
	this.Service_Location_State = Service_Location_State;
	this.Vin = Vin;
	}




public int getDroneID() {
	return DroneID;
}


public void setDroneID(int droneID) {
	DroneID = droneID;
}


public String getMake() {
	return Make;
}


public void setMake(String make) {
	Make = make;
}


public String getModel() {
	return Model;
}


public void setModel(String model) {
	Model = model;
}


public int getYear() {
	return Year;
}


public void setYear(int year) {
	Year = year;
}



public String getLast_Service_Date() {
	return Last_Service_Date;
}


public void setLast_Service_Date(String last_Service_Date) {
	Last_Service_Date = last_Service_Date;
}


public String getService_Location_City() {
	return Service_Location_City;
}


public void setService_Location_City(String service_Location_City) {
	Service_Location_City = service_Location_City;
}


public String getService_Location_State() {
	return Service_Location_State;
}


public void setService_Location_State(String service_Location_State) {
	Service_Location_State = service_Location_State;
}


public String getVin() {
	return Vin;
}


public void setVin(String vin) {
	Vin = vin;
}


@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}

}
