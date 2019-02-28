package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Suppliers;

public class AddSupplier {
public Connection connection;
	
	public AddSupplier(String dbName, String uname, String pwd) {
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
	public void addSupplier(Suppliers supplier) {
		String query = "insert into dronesuppliers(SupplierID,DroneID,Email,Phone,VendorFirstName,VendorLastName,Service_Number) values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, supplier.getSupplierID());
			ps.setInt(2, supplier.getDroneID());
			ps.setString(3, supplier.getEmail());
			ps.setString(4, supplier.getPhone());
			ps.setString(5, supplier.getVendorFirstName());
			ps.setString(6, supplier.getVendorLastName());
			ps.setString(7, supplier.getService_Number());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
			
	}
	

