package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.Suppliers;

public class UpdateSupplierQuery {
	
	private Connection connection;
	
	public UpdateSupplierQuery(String dbName, String uname, String pwd) {
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
	public void doUpdate(Suppliers supplier){
		String query = "update dronesuppliers set DroneId=?,Email=?,Phone=?,VendorFirstName=?,VendorLastName=?,Service_Number=? where SupplierID=?";
	
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, supplier.getDroneID());
			ps.setString(2, supplier.getEmail());
			ps.setString(3, supplier.getPhone());
			ps.setString(4, supplier.getVendorFirstName());
			ps.setString(5, supplier.getVendorLastName());
			ps.setString(6, supplier.getService_Number());
			ps.setString(7, supplier.getSupplierID());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}



