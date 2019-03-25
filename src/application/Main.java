package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
try {
			
			ViewLoader<AnchorPane, Object> viewLoader = new ViewLoader<AnchorPane, Object>("View1.fxml");
			AnchorPane anchorPane = viewLoader.getLayout();
			Scene scene = new Scene(anchorPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Kalkulator");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}