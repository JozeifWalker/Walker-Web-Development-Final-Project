package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Inventory;
public class ReadRecord_Inventory{

private Connection connection;
private ResultSet results;

private Inventory drone = new Inventory();
private int droneID;


public ReadRecord_Inventory(String dbName, String uname, String pwd, int droneID){
	
	String url = "jdbc:mysql://localhost:3306/" + dbName;
	this.droneID = droneID;
	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection(url, uname, pwd);
		
	} catch (InstantiationException | IllegalAccessException
			| ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void doRead(){
	String query = "select * from droneinventory where DroneID = ?";
	
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, this.droneID);
		
		this.results = ps.executeQuery();
		
		this.results.next();
		
		drone.setDroneID(this.results.getInt(1));
		drone.setMake(this.results.getString("Make"));
		drone.setModel(this.results.getString("Model"));
		drone.setYear(this.results.getInt("Year"));
		drone.setLast_Service_Date(this.results.getString("Last_Service_Date"));
		drone.setService_Location_City(this.results.getString("Service_Location_City"));
		drone.setService_Location_State(this.results.getString("Service_Location_State"));
		drone.setVin(this.results.getString("Vin"));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public Inventory getDrone(){
	return this.drone;
}



}
