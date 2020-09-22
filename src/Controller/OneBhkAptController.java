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
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class OneBhkAptController implements Initializable {
	@FXML private ComboBox<String> apts2;
	ApartmentDao apartmentDao=null;
	ResultSet rs= null;
	List<String> singleBhkList= new ArrayList<String>();
	Apartment apts=null;
	Apartment apts1=null;
	String apt=null;
	@FXML private TextField price;
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		 ApartmentDao apartmentDao=new ApartmentDao();
		 rs=apartmentDao.getOneBhkL();
		 try {
			 System.out.println("Hi from 1bhkcontroller");
			while(rs.next())
			 {	
				
				 int i=1;
				 System.out.println(rs.getString(i)+" OneBhkApt Controller");
				 singleBhkList.add(rs.getString(i));
				 i++;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //addActionPs(rs);
		 apts2.setItems(FXCollections.observableArrayList(singleBhkList));
		 apts2.setOnAction((event) -> {
			 apt=apts2.getSelectionModel().getSelectedItem();
			 //games.setgName(game);
			 getPrice();
			 apts1=apartmentDao.getAptPrice(apt);
			 price.setEditable(false);
			 price.setText((apts1.getAptRent()).toString());
		 });
		 
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
	public void setOneBhkItems(ObservableList<String> observableArrayList) {
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
	public void getPrice(){
		apts=new Apartment();
		apts.setAptID(apt);
		//games=gamesDao.getGamePrice(games);
	}
	
}
