package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Connector;

import Model.Apartment;
import Model.Bookings;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ApartmentDao {
	Connection conn=null;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	

	public String addApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		String result = "FAIL";
		try
		{
			conn=Connector.getConnection();
			String sql="insert into apartment_details (apt_id,rentamount, apt_type ) value (?,?,?)";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, apartment.getAptID());
			preparedStatement.setString(3, apartment.getAptType());
			preparedStatement.setDouble(2, apartment.getAptRent());
			//preparedStatement.setString(4, apartment.getAptAddress());
			preparedStatement.executeUpdate();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Add Apartment");
			alert.setHeaderText("Apartment Successfully added!!");
			alert.setContentText(" Welcome!!");
			alert.showAndWait();
			System.out.println("Inserted apartment");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
		
		
	}
	public ResultSet getOneBhkL() {
		// TODO Auto-generated method stub
		String s1="1 BHK";
		String s2="Lake View";
		conn=Connector.getConnection();
		try{
			
			String sql="select apt_id from apartment_details where apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			//preparedStatement.setString(2, s2);
			rs=preparedStatement.executeQuery();
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	public ResultSet getTwoBhkL(){
		String s1="2 BHK";
		String s2="Lake View";
		conn=Connector.getConnection();
		try
		{
			String sql="select apt_id from apartment_details where apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			//preparedStatement.setString(2, s2);
			rs=preparedStatement.executeQuery();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	public ResultSet getstudioL(){
		String s1="studio";
		String s2="Lake View";
		conn=Connector.getConnection();
		try
		{
			String sql="select apt_id from apartment_details where apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			//preparedStatement.setString(2, s2);
			rs=preparedStatement.executeQuery();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	public ResultSet getOneBhkD() {
		// TODO Auto-generated method stub
		String s1="1 BHK";
		String s2="Down Town";
		conn=Connector.getConnection();
		try{
			
			String sql="select apt_id from apartment_details where apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			rs=preparedStatement.executeQuery();
			
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	public ResultSet getStudioD() {
		// TODO Auto-generated method stub
		String s1="Studio";
		String s2="Down Town";
		conn=Connector.getConnection();
		try{
			
			String sql="select apt_id from apartment_details where apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			rs=preparedStatement.executeQuery();
			
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	public ResultSet getTwoBhkD() {
		// TODO Auto-generated method stub
		String s1="2 BHK";
		String s2="Down Town";
		conn=Connector.getConnection();
		try{
			
			String sql="select apt_id from apartment_details where apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			rs=preparedStatement.executeQuery();
			
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
		
	}
	public void deleteApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		try{
			String sql="delete from apartment_details where apt_id=? and apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, apartment.getAptID());
			preparedStatement.setString(2, apartment.getAptType());
			preparedStatement.executeUpdate();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Delete Apartment Confirmation!!");
			alert.setContentText("Are you sue you want to delete this apartment?");

			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Delete Apartment");
			alert1.setHeaderText("You have Successfuly deleted the apartment!!");
			//alert1.setContentText(" You can add more !!");
			alert1.showAndWait();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public Apartment getAptPrice(String apts){
		conn=Connector.getConnection();
		Apartment apt1=new Apartment();
		try{
			String sql="select rentamount,apt_type from apartment_details where apt_id=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, apts);
			rs=preparedStatement.executeQuery();
			try{
				while(rs.next()){
					//apt1.setAptRent(rs.getString("aptRent"));
					//System.out.println(rs.getString("aptRent")+"in dao");
					apt1.setAptRent(Double.parseDouble(rs.getString("rentamount")));
					apt1.setAptType(rs.getString("apt_type"));
				}
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return apt1;
	}
	public String getAptRent(Apartment apartment) {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		String price=null;
		try{
			String sql="select rentamount from apartment_details where apt_id=? and apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, apartment.getAptID());
			preparedStatement.setString(2, apartment.getAptType());
			
			rs=preparedStatement.executeQuery();
			while(rs.next()){
				price=rs.getString("rentamount");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return price;
	}
	public void modifyApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		try{
			String sql="update apartment_details set rentamount=? where apt_id=? and apt_type=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setDouble(1, apartment.getAptRent());
			preparedStatement.setString(2, apartment.getAptID());
			preparedStatement.setString(3, apartment.getAptType());
			//preparedStatement.setString(4, games.getgPlatform());
			preparedStatement.executeUpdate();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Update Apartment");
			alert.setHeaderText("Apartment modified successfully!!");
			//alert.setContentText(" Lets game!!");
			alert.showAndWait();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean checkPay(String cardNumber, String cardName, String cvv1) {
		// TODO Auto-generated method stub
		boolean result=false;
		conn=Connector.getConnection();
		try{
			String sql="select * from card_details where card_name=? and card_no=? and card_cvv=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, cardName);
			preparedStatement.setString(2, cardNumber);
			preparedStatement.setString(3, cvv1);
			rs=preparedStatement.executeQuery();
			try{
			if(rs!=null)
			{
				try{
					while(rs.next())
					{
						int i=1;
						System.out.println(rs.getString(i));
						result=true;
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
			
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
		
	
	}
		catch(Exception ex){
			ex.printStackTrace( );
		}
		return result;
		
	}
	public boolean setBooking(Bookings booking) {
		// TODO Auto-generated method stub
		boolean result=false;
		conn=Connector.getConnection();
		try{
			String sql="insert into booking (customer_name, apt_id, apt_type, rent_date, moveout_date, total_rent) values(?, ?, ?, ?, ?, ?)";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, booking.getCustomerId());
			preparedStatement.setString(2, booking.getAptId());
			preparedStatement.setString(3, booking.getAptType());
			preparedStatement.setString(4,  booking.getRentDate());
			preparedStatement.setString(5,  booking.getMoveoutDate());
			preparedStatement.setString(6, booking.getTotalRent());
			preparedStatement.executeUpdate();
			result=true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
		
	}

	public ResultSet getBooking(String userName) {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		try{
			String sql="select booking_id, apt_id, apt_type, rent_date, moveout_date, total_rent from booking where customer_name=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			rs=preparedStatement.executeQuery();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	public ArrayList<Apartment> getApartments() {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		ArrayList<Apartment> aptList=new ArrayList<Apartment>();
		try{
			String sql="select * from apartment_details";
			preparedStatement=conn.prepareStatement(sql);
			rs=preparedStatement.executeQuery();
			while(rs.next()){
				Apartment apt=new Apartment();
				apt.setAptID(rs.getString("aptID"));
				apt.setAptType(rs.getString("aptType"));
				//apt.setgCategory(rs.getString("gamePlatform"));
				aptList.add(apt);
			}
			for(Apartment i: aptList){
				System.out.println("ApartmentDAO"+i.getAptType());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return aptList;
	}
	public ResultSet getAptID(String type) {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		try{
			String sql="select distinct apt_id from apartment_details where apt_type=? ";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, type);
			//preparedStatement.setString(2, genre);
			rs=preparedStatement.executeQuery();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
	/*public ResultSet getAptType(String id) {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		try{
			String sql="select apt_type from apartment_details where apt_id=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			rs=preparedStatement.executeQuery();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
	public ResultSet getType(String type) {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		try{
			String sql="select apt_type from apartment_details where apt_id=?";
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, type);
			rs=preparedStatement.executeQuery();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
*/
	public ResultSet getType() {
		// TODO Auto-generated method stub
		conn=Connector.getConnection();
		try{
			String sql="select distinct apt_type from apartment_details";
			preparedStatement=conn.prepareStatement(sql);
			rs=preparedStatement.executeQuery();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
	public String getBookingId() throws Exception {
		// TODO Auto-generated method stub
		conn = Connector.getConnection();
		String bookingId=null;
		try{
			String sql = "select max(booking_id) from booking";
			preparedStatement=conn.prepareStatement(sql);
			rs=preparedStatement.executeQuery();
			int i=1;
			while(rs.next()){
			
		    bookingId =rs.getString(i);
		    System.out.println(bookingId);
		    i++;
			}
		
		}
		catch(Exception ex){
			ex.printStackTrace();;
		}
		System.out.println(bookingId + "id");
		return bookingId;
		
	}


}
