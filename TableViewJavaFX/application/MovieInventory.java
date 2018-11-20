package application;

import javafx.application.*; 
import javafx.stage.*; 
import javafx.scene.*; 
import domain.MovieCompany;
import ui.MovieOverview;

public class MovieInventory extends Application {
    public static void main(String[] args)    {        
    	launch(args);    
    }
    
    @Override
	public void start(Stage primaryStage) {
    	MovieCompany movieCompany = new MovieCompany();	
		MovieOverview view = new MovieOverview(movieCompany);
				
		Scene mainScene = new Scene(view);
		
		primaryStage.setTitle("Movie Inventory"); 
        primaryStage.setScene(mainScene); 
        primaryStage.show();
	}
}