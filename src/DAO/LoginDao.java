package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Connector;

public class LoginDao {
	Controller.LoginController loginController=new Controller.LoginController();
	Connection conn=null;
	PreparedStatement ps=null;
	public static String username1=null;
	
	public String login(String username, String password)
	{
		String result="FAIL";
		//String result;
		
		try
		{
			System.out.println("Hi from Dao");
			conn=Connector.getConnection();
			String sql="select * from userlogin where username=?";
			System.out.println("after query");
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet resultSet=ps.executeQuery();
			System.out.println("after query");
			if(resultSet==null)
			{
				loginController.login();
				System.out.println("NULL !!!!!");
			}
			else if(resultSet.next())
			{
				System.out.println("hello");
				Model.User user=new Model.User();
				
				//user.setPwd(resultSet.getString("password"));
				
				user.setPwd(resultSet.getString("password"));
				
				if(user.getPwd().equalsIgnoreCase(password))
				{
					result="success";
					System.out.println(result);
					
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return result;
	}
	public String CheckLoginType(String username)
	{	
		String userType=null;
		try
		{
			conn=Connector.getConnection();
			String sql="Select usertype from userlogin where username=?";
			System.out.println("inside check login");
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next())
			userType=resultSet.getString("usertype");
			username1=username;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return userType;
	}
}
