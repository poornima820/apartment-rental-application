package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.ApartmentDao;

import Login.Main;
import Model.Apartment;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TwoBhkController implements Initializable {
	@FXML private ComboBox<String> apts2;
	ApartmentDao apartmentDao=null;
	ResultSet rs= null;
	List<String> twoBhkList=new ArrayList<String>();
	
	Apartment apts=null;
	Apartment apts1=null;
	String apt=null;
	@FXML private TextField amount;
	public void viewApartmentsL() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/apt1_view.fxml"));
			Scene scene = new Scene(root,350,350);
			Main.stage.setTitle("Login");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		apartmentDao=new ApartmentDao();
		 rs=apartmentDao.getTwoBhkL();
		 try {
			while(rs.next())
			 {
				 int i=1;
				 twoBhkList.add(rs.getString(i));
				 i++;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //addSportsPs(rs);
		 apts2.setItems(FXCollections.observableArrayList(twoBhkList));
		 apts2.setOnAction((event) -> {
			 apt=apts2.getSelectionModel().getSelectedItem();
			 //games.setgName(game);
			 getPrice();
			 apts1=apartmentDao.getAptPrice(apt);
			 amount.setEditable(false);
			 amount.setText(apts1.getAptRent().toString());
		 
		 
	});
	}
	private void addTwoBhkL(ResultSet rs2) {
		// TODO Auto-generated method stub
		try{
			while(rs2.next())
			{
				int i=1;
				twoBhkList.add(rs2.getString(i));
				System.out.println(rs2.getString(i));
				i++;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void rentApartment() throws IOException {
		// TODO Auto-generated method stub
		//BorderPane root = new BorderPane();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/payment.FXML"));
		AnchorPane root = (AnchorPane) loader.load();
		Scene scene = new Scene(root);
		Main.stage.setTitle("Payment");
		Main.stage.setScene(scene);
		Main.stage.show();
		apts=new Apartment();
		apts.setAptID(apt);
		apts.setAptRent(apts1.getAptRent());
		apts.setAptType(apts1.getAptType());
		PaymentController payment=new PaymentController();
		payment.payment(apts);		
	
	}
	public void viewApartments() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/apt_details.fxml"));
			Scene scene = new Scene(root,350,350);
			Main.stage.setTitle("Apartment");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void getPrice(){
		apts=new Apartment();
		apts.setAptID(apt);
		//games=gamesDao.getGamePrice(games);
	}
			
		
}
