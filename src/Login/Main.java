package Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
		public static Stage stage;
		
		@Override
		public void start(Stage primaryStage) {
			try{
				stage=primaryStage;
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/login.fxml"));
				Scene scene = new Scene(root,400,400);
				stage.setTitle("Login");
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}


