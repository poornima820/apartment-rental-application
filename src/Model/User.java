package Model;

public class User {
	String userName;
	String pwd;
	Boolean userType;
	
	public User()
	{
		
	}
	
	public User(String username, String password, Boolean userType)
	{
		this.userName = username;
		this.pwd = password;
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String password) {
		this.pwd = password;
	}
	public Boolean getUserType() {
		return userType;
	}
	public void setUserType(Boolean userType) {
		this.userType = userType;
	}
	
	

}


