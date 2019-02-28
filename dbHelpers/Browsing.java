package dbHelpers;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import model.Inventory;

	public class Browsing {


			
			private Connection connection;
			private ResultSet results;
			
			public Browsing(String dbName, String uname, String pwd){
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
				String query = "select* from droneinventory";
				
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
						Inventory inventory = new Inventory();
						inventory.setDroneID((this.results.getInt("DroneID")));
					    inventory.setMake(this.results.getString("Make"));
					    inventory.setModel(this.results.getString("Model"));
					    inventory.setYear(this.results.getInt("Year"));
					    inventory.setLast_Service_Date(this.results.getString("Last_Service_Date"));
					    inventory.setService_Location_City(this.results.getString("Service_Location_City"));
					    inventory.setService_Location_State(this.results.getString("Service_Location_State"));
					    inventory.setVin(this.results.getString("Vin"));
					    table += "<tr>";
						table += "<th>";
						table += "DroneID";
						table += "</th>";
						table += "<th>";
						table += "Make";
						table += "</th>";
						table += "<th>";
						table += "Model";
						table += "</th>";
						table += "<th>";
						table += "Year";
						table += "</th>";
						table += "<th>";
						table += "LastService";
						table += "</th>";
						table += "<th>";
						table += "ServiceCity";
						table += "</th>";
						table += "<th>";
						table += "ServiceState";
						table += "</th>";
						table += "<th>";
						table += "Vin";
						table += "</th>";
						table += "</tr>";
						table +="<tr>";
						table +="<td>";
						table += inventory.getDroneID();
						table +="</td>";
						table +="<td>";
						table += inventory.getMake();
						table +="</td>";
						table +="<td>";
						table += inventory.getModel();
						table +="</td>";
						table +="<td>";
						table += inventory.getYear();
						table +="</td>";
						table +="<td>";
						table += inventory.getLast_Service_Date();
						table +="</td>";
						table +="<td>";
						table += inventory.getService_Location_City();
						table +="</td>";
						table +="<td>";
						table += inventory.getService_Location_State();
						table +="</td>";
						table +="<td>";
						table += inventory.getVin();
						table +="</td>";
						table +="<td>";
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
