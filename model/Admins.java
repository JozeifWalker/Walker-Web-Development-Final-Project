package model;

public class Admins {
	 String username;
	 String password;
	

public Admins(String username,String password) {
	this.username = username;
	this.password = password;
}

public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
