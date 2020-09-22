package Controller;

//import DatabaseDAO.createAccountDAO;
import DAO.LoginDao;
import DAO.CreateAccountDao;
import Login.Main;
import Model.CustomerPage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController extends Main {
	@FXML private TextField username;
	@FXML private TextField password;
	@FXML private TextField password1;
	@FXML private TextField username1;
	@FXML private TextField firstname;
	@FXML private TextField lastname;
	@FXML private TextField phnumber;
	@FXML private TextField emailId;
	private Stage dialogStage;
	 CreateAccountDao createAccountDao=new CreateAccountDao();
	  
	  

	  private Stage getDialogStage() {
		return dialogStage;
	}
	private void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	/**
	 * 
	 */

	public void login()
		{
		String username = this.username.getText();
		String password = this.password.getText();
		String result = "Fail";
		//String result;
		String userType = null;
		
		/*if(user_name.equals("admin") && password.equals("admin")){
			System.out.println("Success");
		}
		else{
			System.out.println("Login Failed");
		}*/
		LoginDao loginDao = new LoginDao();
		result = loginDao.login(username, password);
		System.out.println(result + "Inside Login");
		
		if(result.equalsIgnoreCase("success"))
		{
			System.out.println("Login Successfull");
			userType = loginDao.CheckLoginType(username);
				if(userType.equalsIgnoreCase("a"))
					
				{
						System.out.println("Success");
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Successful Login");
						alert.setHeaderText("You have Successfuly logged in!!");
						alert.setContentText("Welcome Mr.Admin!!");
						alert.showAndWait();
					
					System.out.println("Hi admin");
					try {
						AnchorPane root;
						root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/admin_apt.fxml"));
						Scene scene = new Scene(root);

						Main.stage.setScene(scene);
						Main.stage.setTitle("ADMIN_PAGE");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
				else if(userType.equalsIgnoreCase("c"))	
					
				{System.out.println("Success");
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login Success");
				alert.setHeaderText("Login Success!!");
				alert.setContentText("Welcome!!");
				alert.showAndWait();
					System.out.println("Customer");
					try {
						AnchorPane root;
						root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/customer_view.fxml"));
						Scene scene = new Scene(root);

						Main.stage.setScene(scene);
						Main.stage.setTitle("CUSTOMER_VIEW_PAGE");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					}
				
			}
		else
		{ 
			System.out.println("Error");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Wrong Login");
			alert.setHeaderText("You have entered the wrong username/password");
			alert.setContentText("Please try again!!");

			alert.showAndWait();
		}
		}
	public void createAccoutAction() {
		// TODO Auto-generated method stub
		System.out.println("Create Account ");
		try{
			AnchorPane root;
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/createaccount.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Customer Create Account");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void createAccountOperation() {
		// TODO Auto-generated method stub
		CustomerPage customerpage = new CustomerPage();
		
		customerpage.setFirst_Name(firstname.getText());
		
		customerpage.setLast_Name(lastname.getText());
		customerpage.setEmailID(emailId.getText());
		customerpage.setUser_Name(username1.getText());
		
		customerpage.setPass_word(password1.getText());
		customerpage.setPh_Num(phnumber.getText());
		createAccountDao.createaccount(customerpage);		
		try{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/login.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setTitle("Login");
			Main.stage.setScene(scene);
		}
		catch(Exception e){
			e.printStackTrace();
		}

}
	public void loginOperation() {
		// TODO Auto-generated method stub
		System.out.println("Create Account ");
		try{
			
			
			AnchorPane root;
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/login.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Customer");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

