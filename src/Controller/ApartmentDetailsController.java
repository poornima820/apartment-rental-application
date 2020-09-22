package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.ApartmentDao;
import Login.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class ApartmentDetailsController implements Initializable{
	static ArrayList<String> singleBhkList=null;
	static ArrayList<String> doubleBhkList=null;
	static ArrayList<String> studioList=null;
	@FXML private ComboBox<String> oneBhk;
	@FXML private Button rentApt;
	ApartmentDao apartmentDao = new ApartmentDao();
	ResultSet rs= null;
	public void viewApts() {
		// TODO Auto-generated method stub
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/apt_details.fxml"));
			Scene scene = new Scene(root,500,500);
			Main.stage.setTitle("Apartment Details");
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void oneBhkApt() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/one_bhk_list.fxml"));
		Scene scene = new Scene(root,350,350);
		Main.stage.setTitle("Action");
		Main.stage.setScene(scene);
		Main.stage.show();
		//PlayStationController crd= loader.getController();
		//gamesDao=new GamesDAO();
		 //rs=gamesDao.getPsActionGames(); 
		 //addActionPs(rs);
		 //crd.setActionitems(FXCollections.observableArrayList(actionList));
	}
	public void twoBhkApt() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/two_bhk_list.fxml"));
		Scene scene = new Scene(root,350,350);
		Main.stage.setTitle("Two BHK");
		Main.stage.setScene(scene);
		Main.stage.show();
		//PlayStationController crd= loader.getController();
		//gamesDao=new GamesDAO();
		 //rs=gamesDao.getPsActionGames(); 
		 //addActionPs(rs);
		 //crd.setActionitems(FXCollections.observableArrayList(actionList));
	}
	public void studio() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/studio.fxml"));
		Scene scene = new Scene(root,350,350);
		Main.stage.setTitle("Studio");
		Main.stage.setScene(scene);
		Main.stage.show();
		//PlayStationController crd= loader.getController();
		//gamesDao=new GamesDAO();
		 //rs=gamesDao.getPsActionGames(); 
		 //addActionPs(rs);
		 //crd.setActionitems(FXCollections.observableArrayList(actionList));
	}
	public void setActionitems(ObservableList<String> co)
	{
		this.oneBhk.setItems(co);
		//this.sports.setItems(co);
		
	}
	private void addOneBhkRoom(ResultSet rs2) {
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
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
}
