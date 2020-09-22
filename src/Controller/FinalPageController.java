package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.ApartmentDao;
import DAO.LoginDao;

import Login.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FinalPageController implements Initializable {
	@FXML private Label customerName, aptId, moveInDate,aptType, bookingId;
	ApartmentDao aptDao = new ApartmentDao();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		customerName.setText(LoginDao.username1);
		aptId.setText(PaymentController.apt1.getAptID());
		moveInDate.setText(PaymentController.booking.getRentDate().toString());
		//moveOutDate.setText(PaymentController.booking.getMoveoutDate().toString());
		aptType.setText(PaymentController.booking.getAptType().toString());
		String booking_Id = null;
		try {
			booking_Id = aptDao.getBookingId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookingId.setText(booking_Id); 
	}
public void Apartment() {
	// TODO Auto-generated method stub
	try {
		//BorderPane root = new BorderPane();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/customer_view.fxml"));
		Scene scene = new Scene(root,400,400);
		Main.stage.setTitle("Apartment");
		Main.stage.setScene(scene);
		Main.stage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	}

}
