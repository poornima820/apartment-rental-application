package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.ApartmentDao;

import Login.Main;
import Model.Apartment;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class DeleteApartment implements Initializable {
	@FXML private ComboBox<String> aptId;
	@FXML private ComboBox<String> aptType;
	
	@FXML private Button deleteApt;
	ApartmentDao apartmentDao=null;
	ResultSet rs=null, rs1=null, rs2=null;
	List<String> aptIdList=null;
	List<String> aptTypeList=null;
	//List<String> platformList=null;
	String aptId1;
	String type;
	//String platform;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		apartmentDao=new ApartmentDao();
		rs=apartmentDao.getType();
		addType(rs);
		aptType.setItems(FXCollections.observableArrayList(aptTypeList));
		aptType.setOnAction((event)->{
			type=aptType.getSelectionModel().getSelectedItem();
			/*rs1=apartmentDao.getGenre(type);
			addGenre(rs1);
			gGenre.setItems(FXCollections.observableArrayList(genreList));
			gGenre.setOnAction((event1)->{
			genre=gGenre.getSelectionModel().getSelectedItem();*/
			rs2=rs=apartmentDao.getAptID(type);
			addAptId(rs2);
			aptId.setItems(FXCollections.observableArrayList(aptIdList));
			aptId.setOnAction((event2)->{
			aptId1=aptId.getSelectionModel().getSelectedItem();
				});
			});
		
		deleteApt.setOnAction((event3)->{
			Apartment apartment=new Apartment();
			apartment.setAptID(aptId1);
			apartment.setAptType(type);
			//apartment.setgPlatform(platform);
			apartmentDao=new ApartmentDao();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Delete Apartment Confirmation");
			alert.setContentText("Are you sure you want to delete the apartment ?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				apartmentDao.deleteApartment(apartment);
			} else if(result.get() == ButtonType.CANCEL) {
				
			}
			
		});
	}
public void addAptId(ResultSet rs){
	try{
		aptIdList=new ArrayList<String>();
		while(rs.next()){
			int i=1;
			aptIdList.add(rs.getString(i));
			i++;
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
public void deleteApartment(){
	
}
public void addType(ResultSet rs){
	try{
		aptTypeList=new ArrayList<String>();
		while(rs.next()){
			int i=1;
			aptTypeList.add(rs.getString(i));
			i++;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
public void adminHomePage()
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
}