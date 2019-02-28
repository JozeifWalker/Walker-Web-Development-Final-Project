package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Purchases;

public class ReadRecord_Purchase {
	private Connection connection;
	private ResultSet results;
	private String orderID;
	private Purchases pur = new Purchases();
	
	public ReadRecord_Purchase(String dbName, String uname, String pwd,String orderID) {
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.orderID = orderID;
		
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
		String query = "select * from purchases where OrderID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, this.orderID);
			
			this.results =ps.executeQuery();
			
			this.results.next();
			pur.setOrderID(this.results.getString("OrderID"));
			pur.setEmployeeID(this.results.getInt("EmployeeID"));
			pur.setMSRP(this.results.getDouble("MSRP"));
			pur.setTax(this.results.getDouble("Tax"));
			pur.setShip_Date(this.results.getString("Ship_Date"));
			pur.setReceived_Date(this.results.getString("Received_Date"));
			pur.setInvoiceID(this.results.getString("InvoiceID"));
			pur.setDroneID(this.results.getString("DroneID"));
			pur.setSupplierID(this.results.getString("SupplierID"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Purchases getPurchase() {
		
		return this.pur;
	}
	}
