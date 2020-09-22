package Controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import DAO.ApartmentDao;
import DAO.LoginDao;

import Login.Main;
import Model.Apartment;
import Model.Bookings;
import Model.PaymentPage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class PaymentController implements Initializable {
	@FXML private TextField ccnumber;
	@FXML private TextField ccname;
	@FXML private TextField cvv;
	DateFormat dateFormat=new SimpleDateFormat("mm/dd/yyyy");
	Date date = new Date(Calendar.getInstance().getTime().getTime());
	
	
	Calendar cal=Calendar.getInstance();
	//setTime(date);
	String dateNow=dateFormat.format(date);
	String dateNow1=new SimpleDateFormat("mm/dd/yyyy").format(date);
	public static Apartment apt1=new Apartment();
	ApartmentDao apartmentDao=new ApartmentDao();
	PaymentPage payment=new PaymentPage();
	public static Bookings booking =new Bookings();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		}
	public void viewApartments() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/apt_details.fxml"));
			Scene scene = new Scene(root,350,350);
			Main.stage.setTitle("Apartments");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void payment(Apartment apartment) {
		// TODO Auto-generated method stub
		try {
				//BorderPane root = new BorderPane();
			String username= LoginDao.username1;
				booking=new Bookings();
				/*orders.setCustId(username);
				orders.setgId(game.getgName());
				orders.setgPlatform(game.getgPlatform());
				orders.setRentDate(rentalDate);
				orders.setRetDate(returnDate1);
				orders.setTotPrice(games1.getRentPrice());*/
				apt1.setAptID(apartment.getAptID());
				apt1.setAptRent(apartment.getAptRent());
				apt1.setAptType(apartment.getAptType());
			} catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	public void pay() throws IOException{
		boolean result=false;
		boolean result1=false;
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 6);
		Date date2=cal.getTime();
		String dateFuture1=new SimpleDateFormat("mm/dd/yyyy").format(date2);
		String dateFuture2=dateFuture1;
		System.out.println(date+"in payment");
		//Date returnDate=new Date(Calendar.getInstance().getTime().getTime());
		Date returnDate1=cal.getTime();
		//String dateFuture=dateFormat.format(returnDate1);
		String cardNumber=ccnumber.getText();
		String cardName=ccname.getText();
		String cvv1=cvv.getText();
		result=apartmentDao.checkPay(cardNumber, cardName, cvv1);
		System.out.println("after card details");
		System.out.println(result);
		if(result==true){
			booking=new Bookings();
			//booking.setBookingId(bookingId);
			booking.setCustomerId(LoginDao.username1);
			booking.setAptId(apt1.getAptID());
			booking.setAptType(apt1.getAptType());
			booking.setRentDate(dateNow1);
			booking.setMoveoutDate(dateFuture2);
			booking.setTotalRent(apt1.getAptRent().toString());
			result1=apartmentDao.setBooking(booking);
			if(result1==true){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Credit Card");
					alert.setHeaderText("Payment made successfully !!!");
					alert.setContentText(" Please go ahead to view the Booking details!!");
					alert.showAndWait();
					System.out.println("Success");
				
			System.out.println("sucess");
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/finalbookingpage.fxml"));
			Scene scene = new Scene(root,400,400);
			Main.stage.setTitle("Games");
			Main.stage.setScene(scene);
			Main.stage.show();
		}
			
			
			
		String username= LoginDao.username1;
		System.out.println(username);
	}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Credit Card");
			alert.setHeaderText("You have entered the wrong details!!");
			alert.setContentText(" Please check again!!");
			alert.showAndWait();
			System.out.println("Error");
		}
}

}
