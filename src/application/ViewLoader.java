package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class ViewLoader<T,U> {
	private T fxmlLayout = null;
	private U fxmlController = null;
	
	public ViewLoader (String fxml) throws IOException {
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
			fxmlLayout = fxmlLoader.load();
			fxmlController = fxmlLoader.getController();
			
		}
		catch (IOException ex) { 
			System.out.println("test");
			
		}
		
	}
	public T getLayout(){ return fxmlLayout; }
	public U getController(){ return fxmlController; }

}