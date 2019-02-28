package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Inventory;

public class AddInventory {
	
	public Connection connection;
	
	public AddInventory(String dbName, String uname, String pwd) {
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd); 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addDrone(Inventory drone) {
String query = "insert into droneinventory (DroneId, Make, Model, Year, Last_Service_Date, Service_Location_City,Service_Location_State, Vin) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, drone.getDroneID());
			ps.setString(2, drone.getMake());
			ps.setString(3, drone.getModel());
			ps.setInt(4, drone.getYear());
			ps.setString(5, drone.getLast_Service_Date());
			ps.setString(6, drone.getService_Location_City());
			ps.setString(7, drone.getService_Location_State());
			ps.setString(8, drone.getVin());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


		
}
		

	


