package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Connector;
import Model.CustomerPage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CreateAccountDao {
	Connection conn=null;
	PreparedStatement preparedStatement=null, preparedStatement2=null;
	ResultSet resultSet=null, resultSet2=null;
	public void createaccount(CustomerPage customerpage)
	{
		try
		{
			int i=0, j=0;
			conn=Connector.getConnection();
			String sql="insert into customerpage(first_name, last_name, ph_num,emailID, username,password) values( ?,?,?, ?, ?, ? )";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, customerpage.getFirst_Name());
			preparedStatement.setString(2, customerpage.getLast_Name());
			preparedStatement.setString(3, customerpage.getPh_Num());
			preparedStatement.setString(4, customerpage.getEmailID());
			preparedStatement.setString(5, customerpage.getUser_Name());
			preparedStatement.setString(6, customerpage.getPass_word());
			preparedStatement.executeUpdate();
			System.out.println(i);
			String sql2="insert into userlogin(username, password, usertype) values(?,?,?)";
			preparedStatement2=conn.prepareStatement(sql2);
			preparedStatement2.setString(1, customerpage.getUser_Name());
			preparedStatement2.setString(2, customerpage.getPass_word());
			preparedStatement2.setString(3, "C");
			preparedStatement2.executeUpdate();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Enroll New Customer");
			alert.setHeaderText("Welcome!!!You have Successfuly Signed Up!!");
			//alert.setContentText(" Lets game!!");
			alert.showAndWait();
			System.out.println(j);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
}         

