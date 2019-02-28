package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Purchases;

public class UpdatePurchaseQuery {
	private Connection connection;
	
	public UpdatePurchaseQuery(String dbName, String uname, String pwd) {
		
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
	public void doUpdate(Purchases p) {
		String query = " update purchases set EmployeeID=?, MSRP=?, Tax=?, Ship_Date=?, Received_Date=?, InvoiceID=?, DroneID=?, SupplierID = ? where OrderID=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1,p.getEmployeeID());
			ps.setDouble(2, p.getMSRP());
			ps.setDouble(3, p.getTax());
			ps.setString(4, p.getShip_Date());
			ps.setString(5, p.getReceived_Date());
			ps.setString(6, p.getInvoiceID());
			ps.setString(7,p.getDroneID() );
			ps.setString(8,p.getSupplierID());
			ps.setString(9, p.getOrderID());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


	
		
	


