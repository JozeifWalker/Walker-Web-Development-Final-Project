package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Purchases;

public class ReadPurchases {

	private Connection connection;
	private ResultSet results;
	
	public ReadPurchases(String dbName, String uname, String pwd) {
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?autoReconnect=true&useSSL=false";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doRead(){
		String query = "select* from purchases";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getHTMLTable(){
		String table ="";
		table += "<table border=1>";
		
		try {
			while(this.results.next()){
				Purchases p = new Purchases();
				
				p.setInvoiceID(this.results.getString("InvoiceID"));
				p.setEmployeeID(this.results.getInt("EmployeeID"));
				p.setMSRP(this.results.getDouble("MSRP"));
				p.setTax(this.results.getDouble("Tax"));
				p.setShip_Date(this.results.getString("Ship_Date"));
				p.setReceived_Date(this.results.getString("Received_Date"));
				p.setDroneID(this.results.getString("DroneID"));
				p.setInvoiceID(this.results.getString("InvoiceID"));
				p.setSupplierID(this.results.getString("SupplierID"));
				table += "<tr>";
				table += "<th>";
				table += "OrderID";
				table += "</th>";
				table += "<th>";
				table += "EmployeeID";
				table += "</th>";
				table += "<th>";
				table += "MSRP";
				table += "</th>";
				table += "<th>";
				table += "Tax";
				table += "</th>";
				table += "<th>";
				table += "ShipDate";
				table += "</th>";
				table += "<th>";
				table += "ReceivedDate";
				table += "</th>";
				table += "<th>";
				table += "InvoiceID";
				table += "</th>";
				table += "<th>";
				table += "DroneID";
				table += "</th>";
				table += "<th>";
				table += "SupplierID";
				table += "</th>";
				table += "</tr>";
				table +="<tr>";
				table +="<td>";
				table += p.getOrderID();
				table +="</td>";
				table +="<td>";
				table += p.getEmployeeID();
				table +="</td>";;
				table +="<td>";
                table += p.getMSRP();
                table +="</td>";
				table +="<td>";
                table += p.getTax();
                table +="</td>";
				table +="<td>";
                table += p.getShip_Date();
                table +="</td>";
				table +="<td>";
                table += p.getReceived_Date();
                table +="</td>";
				table +="<td>";
                table += p.getInvoiceID();
                table +="</td>";
				table +="<td>";
                table += p.getDroneID();
                table +="</td>";
				table +="<td>";
                table += p.getSupplierID();
                table +="</td>";
				table +="<td>";
				table += "<a href=updatePurchases?DroneID=" + p.getInvoiceID() + " >update</a>";
				table +="</td>";
				table +="</tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
}

	
