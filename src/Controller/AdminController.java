package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.ApartmentDao;
import Login.Main;
import Model.Apartment;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminController {
	@FXML private TextField apt_id;
	@FXML private TextField apt_type;
	@FXML private TextField apt_rent;
	//@FXML private TextField apt_address;
	private ArrayList<Apartment> apt;
	 ApartmentDao apartmentDao=new ApartmentDao();
	 ResultSet rs= null;
	private ArrayList<Apartment> getApt() {
		return apt;
	}
	private void setApt(ArrayList<Apartment> apt) {
		this.apt = apt;
	}	
	
	public void addApt() {
		// TODO Auto-generated method stub
		// Invoke Add Games FXML
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/add_apt.fxml"));
			Scene scene = new Scene(root,400,400);
			Main.stage.setTitle("Add Apartment");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addAptinDb()
	{
		String result="FAIL";
		Apartment apartment=new Apartment();
		apartment.setAptID(apt_id.getText());
		apartment.setAptType(apt_type.getText());
		apartment.setAptRent(Double.parseDouble(apt_rent.getText()));
		//apartment.setAptAddress(apt_address.getText());
		ApartmentDao apt=new ApartmentDao();
		result = apt.addApartment(apartment);
		if(result.equalsIgnoreCase("success"))
		{
			System.out.println("Apartment Inserted");
			
		}
		
	}
	public void deleteApartment() 
	{
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/delete_apt.fxml"));
			Scene scene = new Scene(root,400,400);
			Main.stage.setTitle("Delete Apartment");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deleteselectedGames() 
	{
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/delete_apt.fxml"));
			Scene scene = new Scene(root,350,350);
			Main.stage.setTitle("Delete");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void modifyApartment() 
	{
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/update_apt.fxml"));
			Scene scene = new Scene(root,400,400);
			Main.stage.setTitle("Update Apartment");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void logout()
	{
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/login.fxml"));
			Scene scene = new Scene(root,350,350);
			Main.stage.setTitle("Login");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void adminPage()
	{
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/admin_apt.fxml"));
			Scene scene = new Scene(root,550,350);
			Main.stage.setTitle("Admin Page");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}


