package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.ApartmentDao;
import DAO.LoginDao;
import Login.Main;
import Model.Bookings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ViewBookingController implements Initializable {
	List<Bookings> BookingsList=new ArrayList<Bookings>();
	ResultSet rs=null;
	ApartmentDao apartmentDao=new ApartmentDao();
	Bookings bookings2=null;
	 @FXML  TableView<Bookings> viewBookings;
	 @FXML TableColumn<Bookings, String> aptId;
	 @FXML TableColumn<Bookings, String> aptType;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String userName=LoginDao.username1;
		BookingsList=new ArrayList<Bookings>();
		rs=apartmentDao.getBooking(userName);
		
		try{
			while(rs.next()){
				bookings2=new Bookings();
				bookings2.setBookingId(rs.getString("booking_id"));
				bookings2.setAptId(rs.getString("apt_id"));
				bookings2.setAptType(rs.getString("apt_type"));
				bookings2.setRentDate(rs.getString("rent_date"));
				bookings2.setMoveoutDate(rs.getString("moveout_Date"));
				BookingsList.add(bookings2);
		}
			viewBookings.setItems(FXCollections.observableArrayList(BookingsList));
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void Apartment() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/customer_view.fxml"));
			Scene scene = new Scene(root,350,350);
			Main.stage.setTitle("Apartments");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}


