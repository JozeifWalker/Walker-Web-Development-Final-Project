package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Suppliers;

public class ReadRecord_Supplier {
	
	private Connection connection;
	private ResultSet results;
	
	private Suppliers supplier = new Suppliers();
	private String supplierID;
	
	public ReadRecord_Supplier(String dbName, String uname, String pwd,String supplierID) {
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.supplierID = supplierID;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void doRead() {
			String query = "select * from dronesuppliers where SupplierID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(query);
                 
				ps.setString(1, this.supplierID);
				
				this.results = ps.executeQuery();
				
				this.results.next();
				supplier.setSupplierID(this.results.getString(1));
				supplier.setDroneID(this.results.getInt("DroneID"));
				supplier.setEmail(this.results.getString("Email"));
				supplier.setPhone(this.results.getString("Phone"));
				supplier.setVendorFirstName(this.results.getString("VendorFirstName"));
				supplier.setVendorLastName(this.results.getString("VendorLastName"));
				supplier.setService_Number(this.results.getString("Service_Number"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public Suppliers getSupplier() {
			return this.supplier;
		}

}
