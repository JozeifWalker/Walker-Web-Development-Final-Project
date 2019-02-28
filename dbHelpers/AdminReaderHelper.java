package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admins;


public class AdminReaderHelper {

	public PreparedStatement authenticateUserStatement;
	
	public AdminReaderHelper() throws SQLException {
			try {			
				//Set up connection	
				Class.forName("com.mysql.jdbc.Driver");  // .newInstance();	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/drone_inventory", "root", "1234");

				//Create the preparedstatement(s)
				authenticateUserStatement = conn.prepareStatement("select * from admin_users where Username=? and Password=?");
				//System.out.println("authenticated select from user");
							
			} catch (Exception e) {
				System.out.println(e.getClass().getName() + " : " + e.getMessage());
			}
			 }
	public Admins authentication(String username,String password) {
		Admins admin = null;
try {						
			
			System.out.println("username="+username);
			System.out.println("password="+password);
			//Add parameters to the ?'s in the preparedstatement and execute
			authenticateUserStatement.setString(1, username);
			
			authenticateUserStatement.setString(2, password);
			ResultSet rs = authenticateUserStatement.executeQuery();
			
			//if we've returned a row, turn that row into a new user object
			if (rs.next()) {
				admin = new Admins(rs.getString("Username"), rs.getString("Password"));
			}
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return admin;
	}

}

