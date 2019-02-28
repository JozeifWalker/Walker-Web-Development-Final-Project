package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Inventory;

public class UpdateInventoryQuery {
	
	private Connection connection;
	
	public UpdateInventoryQuery(String dbName, String uname, String pwd){
		
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
	
	public void doUpdate(Inventory drone){
		String query = "update droneinventory set  Make=?, Model=?, Year=?, Last_Service_Date=?, Service_Location_City=?, Service_Location_State=?, Vin=? where DroneID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
	
			ps.setString(1, drone.getMake());
			ps.setString(2, drone.getModel());
			ps.setInt(3, drone.getYear());
			ps.setString(4, drone.getLast_Service_Date());
			ps.setString(5, drone.getService_Location_City());
			ps.setString(6, drone.getService_Location_State());
			ps.setString(7, drone.getVin());
			ps.setInt(8, drone.getDroneID());
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
