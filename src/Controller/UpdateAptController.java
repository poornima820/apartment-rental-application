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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class UpdateAptController implements Initializable {
	@FXML private ComboBox<String> aptID;
	@FXML private ComboBox<String> aptType;
	
	@FXML private TextField price;
	@FXML private Button update;
	ResultSet rs=null, rs1=null, rs2=null;
	List<String> aptIdList=null;
	List<String> aptTypeList=null;
	
	String aptId1;
	String type;
	
	ApartmentDao apartmentDao=null;
	Apartment apts=null;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		apartmentDao=new ApartmentDao();
		rs=apartmentDao.getType();
		addType(rs);
		aptType.setItems(FXCollections.observableArrayList(aptTypeList));
		aptType.setOnAction((event)->{
			type =aptType.getSelectionModel().getSelectedItem();
			/*rs1=apartmentDao.getGenre(type);
			addGenre(rs1);
			gameGenre.setItems(FXCollections.observableArrayList(genreList));
			gameGenre.getSelectionModel().clearSelection();
			gameGenre.setOnAction((event1)->{
			genre=gameGenre.getSelectionModel().getSelectedItem();*/
			rs2=rs=apartmentDao.getAptID(type);
			addAptID(rs2);
			aptID.setItems(FXCollections.observableArrayList(aptIdList));
			aptID.setOnAction((event2)->{
			aptId1=aptID.getSelectionModel().getSelectedItem();
			apts=new Apartment();
			apts.setAptID(aptId1);
			apts.setAptType(type);
			//games.setgPlatform(platform);
			String price1=apartmentDao.getAptRent(apts);
			price.setText(price1);
				});
			});
		
		update.setOnAction((value)->{
			apts=new Apartment();
			apts.setAptID(aptId1);
			apts.setAptType(type);
			//games.setgPlatform(platform);
			apts.setAptRent(Double.parseDouble(price.getText()));
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Update Apartment Confirmation");
			alert.setContentText("Are you sure you want to modify the rent of this apartment ?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				apartmentDao.modifyApartment(apts);
			} else if(result.get() == ButtonType.CANCEL) {
				
			}
		});}
		public void addAptID(ResultSet rs){
			try{
				aptIdList=new ArrayList<String>();
				while(rs.next()){
					int i=1;
					aptIdList.add(rs.getString(i));
					System.out.println(rs.getString(i));
					i++;
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
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
public void adminHome()
{
	try {
		//BorderPane root = new BorderPane();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/admin_apt.fxml"));
		Scene scene = new Scene(root,550,350);
		Main.stage.setTitle("Admin Home Page");
		Main.stage.setScene(scene);
		Main.stage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
}

}
