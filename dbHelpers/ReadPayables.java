package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Payables;

public class ReadPayables {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadPayables(String dbName, String uname, String pwd) {
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
		String query = "select* from payables";
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
				Payables pay = new Payables();
				pay.setInvoiceID(this.results.getString("InvoiceID"));
				pay.setAmountCharged(this.results.getDouble("Amount_Charged"));
				pay.setDueDate(this.results.getString("due_date"));
				pay.setDatePaid(this.results.getString("date_paid"));
				pay.setStatus(this.results.getString("status"));
				
				table += "<tr>";
				table += "<th>";
				table += "InvoiceID";
				table += "</th>";
				table += "<th>";
				table += "Amount_Charged";
				table += "</th>";
				table += "<th>";
				table += "Due_Date";
				table += "</th>";
				table += "<th>";
				table += "Date_Paid";
				table += "</th>";
				table += "<th>";
				table += "Status";
				table += "</th>";
				table += "</tr>";
				table += "<tr>";
				table += "<th>";
				table += pay.getInvoiceID();
				table += "</th>";
				table += "<th>";
				table += pay.getAmountCharged();
				table += "</th>";
				table += "<th>";
				table += pay.getDueDate();
				table += "</th>";
				table += "<th>";
				table += pay.getDatePaid();
				table += "</th>";
				table += "<th>";
				table+= pay.getStatus();
				table += "</th>";
				table +="<th>";
				table += "<a href=updateAccounts?DroneID=" + pay.getInvoiceID() + " >update</a>";
				table += "</tr>";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	table += "</table>";
	return table;
	}
}




		
		

