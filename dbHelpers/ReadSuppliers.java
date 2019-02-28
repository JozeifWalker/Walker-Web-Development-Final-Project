package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Suppliers;

public class ReadSuppliers {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadSuppliers(String dbName,  String uname, String pwd ) {
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?autoReconnect=true&useSSL=false";
		
		// set up the driver
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
		String query = "select* from dronesuppliers";
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
				Suppliers supplier = new Suppliers();
				supplier.setSupplierID(this.results.getString("SupplierID"));
				supplier.setDroneID(this.results.getInt("DroneID"));
				supplier.setEmail(this.results.getString("Email"));
				supplier.setPhone(this.results.getString("Phone"));
				supplier.setVendorFirstName(this.results.getString("VendorFirstName"));
				supplier.setVendorLastName(this.results.getString("VendorLastName"));
				supplier.setService_Number(this.results.getString("Service_Number"));
				table += "<tr>";
				table += "<th>";
				table += "SupplierID";
				table += "</th>";
				table += "<th>";
				table += "DroneID";
				table += "</th>";
				table += "<th>";
				table += "Email";
				table += "</th>";
				table += "<th>";
				table += "Phone";
				table += "</th>";
				table += "<th>";
				table += "VendorFirstName";
				table += "</th>";
				table += "<th>";
				table += "VendorLastName";
				table += "</th>";
				table += "<th>";
				table += "ServiceNumber";
				table += "</th>";
				table += "</tr>";
				table +="<tr>";
				table +="<td>";
				table += supplier.getSupplierID();
				table +="</td>";
				table += "<td>";
				table += supplier.getDroneID();
				table +="</td>";
				table += "<td>";
				table += supplier.getEmail();
				table +="</td>";
				table += "<td>";
				table += supplier.getPhone();
				table +="</td>";
				table += "<td>";
				table += supplier.getVendorFirstName();
				table +="</td>";
				table += "<td>";
				table += supplier.getVendorLastName();
				table +="</td>";
				table += "<td>";
				table += supplier.getService_Number();
				table +="</td>";
				table += "<td>";
				table += "<a href=updateSupplier?SupplierID=" + supplier.getSupplierID()+ " >update</a> <a href=deleteSupplier?SupplierID=" + supplier.getSupplierID() + " >delete</a>";
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
	


