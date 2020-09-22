package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static Connection getConnection()
	{
		Connection connect = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?user=root&password=star123");
			System.out.println("I am db");
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return connect;
	}
}
