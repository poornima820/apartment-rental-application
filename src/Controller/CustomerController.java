package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import Controller.OneBhkAptController;
import DAO.ApartmentDao;

import Login.Main;
import Model.Apartment;
import Model.Bookings;
import Model.CustomerPage;
import Model.PaymentPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class CustomerController implements Apartments {
	@FXML private ComboBox<String> apt2;
	@FXML private TextArea apt_id;
	@FXML private TextArea price;
	@FXML private Button rentGame;
	ApartmentDao apartmentDao=new ApartmentDao();
	ResultSet rs= null;
	 static ArrayList<String> singleBhkList=null;
	 static ArrayList<String> doubleBhkList=null;
	 static ArrayList<String> studioList=null;
	 static ArrayList<String> bhk1=null;
	 static ArrayList<String> bhk2=null;
	 static ArrayList<String> bhkS=null;
	 static ArrayList<Integer> priceList=null;
	 Apartment apt1=new Apartment();
	 PaymentController paymentControl=new PaymentController();
	 private ArrayList<CustomerPage> customer;
		private ArrayList<Apartment> apartment;
		private ArrayList<PaymentPage> payment;
		ArrayList<Bookings> bookingList=null;
		Bookings booking2=null;
	public ArrayList<CustomerPage> getCustomer() {
		return customer;
	}
	public void setCustomer(ArrayList<CustomerPage> customer) {
		this.customer = customer;
	}
	public ArrayList<Apartment> getApartment() {
		return apartment;
	}
	public void setApartment(ArrayList<Apartment> apartment) {
		this.apartment = apartment;
	}
	public ArrayList<PaymentPage> getPayment() {
		return payment;
	}
	public void setPayment(ArrayList<PaymentPage> payment) {
		this.payment = payment;
	}
	
	@Override
	public void viewApartments() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/apt_details.fxml"));
			Scene scene = new Scene(root,300,375);
			
			Main.stage.setTitle("Apartment");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	/*public void viewBooking() {
		// TODO Auto-generated method stub
		
	}*/
	//@Override
	public void updateBooking() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteBooking() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void payment() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void viewOneBhk() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/apt1_view.fxml"));
			Scene scene = new Scene(root,350,350);
			
			Main.stage.setTitle("Apartment View");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void viewTwoBhk() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/apt2_view.fxml"));
			
			Scene scene = new Scene(root,350,350);
			
			Main.stage.setTitle("Apartment View");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void logout()
	{
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/login.fxml"));
			Scene scene = new Scene(root,400,400);
			Main.stage.setTitle("Login");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void oneBhk() throws IOException {
		// TODO Auto-generated method stub

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/one_bhk_list.FXML"));
		AnchorPane root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		

		Main.stage.setScene(scene);
		Main.stage.setTitle("OneBHK List");
		OneBhkController obc= loader.getController();
		apartmentDao=new ApartmentDao();
		 rs=apartmentDao.getOneBhkL(); 
		 addOneBhk(rs);
		 //obc.addOneBhk(FXCollections.observableArrayList(singleBhkList));
		
		
	}
	private void addOneBhk(ResultSet rs2) {
		// TODO Auto-generated method stub
		try{
			singleBhkList=new ArrayList<String>();
			while(rs2.next())
			{
				int i=1;
				System.out.println(rs2.getString(i));
				singleBhkList.add(rs2.getString(i));
				System.out.println(rs2.getString(i));
				i++;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void setOneBhkLitems(ObservableList<String> co)
	{
		this.apt2.setItems(co);
		//this.sports.setItems(co);
		
	}
	public void setTwoBhkLitems(ObservableList<String> co)
	{
		this.apt2.setItems(co);
		//this.sports.setItems(co);
		
	}
	public void setOneBhkDitems(ObservableList<String> co)
	{
		this.apt2.setItems(co);
		//this.sports.setItems(co);
		
	}
	public void setTwoBhkDitems(ObservableList<String> co)
	{
		this.apt2.setItems(co);
		//this.sports.setItems(co);
		
	}
	/*public void setRacingXitems(ObservableList<String> co)
	{
		this.games2.setItems(co);
		//this.sports.setItems(co);
		
	}*/
	public void oneBhkL() throws IOException {
		// TODO Auto-generated method stub

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/one_bhk_list.FXML"));
		AnchorPane root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		

		Main.stage.setScene(scene);
		Main.stage.setTitle("One BHK Lake view");
		OneBhkAptController obc= loader.getController();
		apartmentDao=new ApartmentDao();
		 rs=apartmentDao.getOneBhkL(); 
		 addOneBhkL(rs);
		 obc.setOneBhkItems(FXCollections.observableArrayList(singleBhkList));
		
		
	}
	private void addOneBhkL(ResultSet rs2) {
		// TODO Auto-generated method stub
		try{
			singleBhkList=new ArrayList<String>();
			while(rs2.next())
			{
				int i=1;
				System.out.println(rs2.getString(i));
				singleBhkList.add(rs2.getString(i));
				System.out.println(rs2.getString(i));
				i++;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void twoBhkL() throws IOException{
		// TODO Auto-generated method stub
		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/two_bhk_list.FXML"));
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.setTitle("Two BHK Lake View");
			CustomerController crd=loader.getController();
			apartmentDao=new ApartmentDao();
			rs=apartmentDao.getTwoBhkL();
			try{
				doubleBhkList=new ArrayList<String>();
				while(rs.next())
				{
					int i=1;
					doubleBhkList.add(rs.getString(i));
					i++;
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			//addRacingPs(rs);
			
			crd.setTwoBhkLitems(FXCollections.observableArrayList(doubleBhkList));
			
		} 
	public void Apartments() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Customer_view.fxml"));
			Scene scene = new Scene(root,350,350);
			
			Main.stage.setTitle("Apartments");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void addOneBhkD(ResultSet rs2) {
		// TODO Auto-generated method stub
		try{
			singleBhkList=new ArrayList<String>();
			while(rs2.next())
			{
				int i=1;
				System.out.println(rs2.getString(i));
				singleBhkList.add(rs2.getString(i));
				System.out.println(rs2.getString(i));
				i++;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void viewBooking() {
		// TODO Auto-generated method stub
			try {
				//BorderPane root = new BorderPane();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/view_booking.fxml"));
				AnchorPane root = (AnchorPane) loader.load();
				Scene scene = new Scene(root,400,400);
				
				Main.stage.setTitle("Booking");
				Main.stage.setScene(scene);
				Main.stage.show();
			} catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
