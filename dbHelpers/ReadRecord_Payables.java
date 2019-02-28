package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Payables;

public class ReadRecord_Payables {
	
	private Connection connection;
	private ResultSet results;
	private String  InvoiceID;
	private Payables pay = new Payables();
	
  public ReadRecord_Payables(String dbName, String uname, String pwd,String InvoiceID) {
	  String url = "jdbc:mysql://localhost:3306/" + dbName;
	  this.InvoiceID = InvoiceID;
	  
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
	  String query = "select * from payables where InvoiceID = ?";
	  
	  try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, this.InvoiceID);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			pay.setInvoiceID(this.results.getString(1));
			pay.setAmountCharged(this.results.getDouble("Amount_charged"));
			pay.setDueDate(this.results.getString("due_date"));
			pay.setDatePaid(this.results.getString("date_paid"));
			pay.setStatus(this.results.getString("status"));
			
	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public Payables getPay() {
	return this.pay;
} 
}
  
	  
	  
	  
