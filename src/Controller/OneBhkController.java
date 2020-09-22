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

public class OneBhkController implements Initializable {
	@FXML private ComboBox<String> oneBhk;
	ApartmentDao apartmentDao=null;
	ResultSet rs= null;
	List<String> singleBhkList= new ArrayList<String>();
	Apartment apts=null;
	Apartment apt1=null;
	String apt=null;
	@FXML private TextField amount;
	public void oneBhk() throws IOException {
	
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		 ApartmentDao apartmentDao=new ApartmentDao();
		 rs=apartmentDao.getOneBhkL();
		 try {
			while(rs.next())
			 {
				 int i=1;
				 System.out.println(rs.getString(i)+" One BHK controller");
				 singleBhkList.add(rs.getString(i));
				 i++;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //addActionPs(rs);
		 oneBhk.setItems(FXCollections.observableArrayList(singleBhkList));
		 oneBhk.setOnAction((event) -> {
			 apt=oneBhk.getSelectionModel().getSelectedItem();
			 //games.setgName(game);
			 getPrice();
			 apt1=apartmentDao.getAptPrice(apt);
			 amount.setEditable(false);
			 amount.setText(apt1.getAptRent().toString());
		 
		 
		 });
}
	public void getPrice(){
		apts=new Apartment();
		apts.setAptID(apt);
		//games=gamesDao.getGamePrice(games);
	}
	private void addOneBhk(ResultSet rs) {
		// TODO Auto-generated method stub
		try{
			while(rs.next())
			{
				int i=1;
				//actionList=new ArrayList<String>();
				singleBhkList.add(rs.getString(i));
				System.out.println(rs.getString(i));
				i++;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void rentApt() throws IOException {
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
		apts.setAptRent(apt1.getAptRent());
		apts.setAptType(apt1.getAptType());
		PaymentController paymentControl=new PaymentController();
		paymentControl.payment(apts);
		
		
		
		
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
}
