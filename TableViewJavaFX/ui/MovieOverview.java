package ui;

import domain.Movie;
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.scene.text.*; 
import javafx.scene.control.cell.*; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import domain.MovieCompany;

public class MovieOverview extends VBox{	
	private MovieCompany movieCompany ;
    private TableView<Movie> table ;
    
	public MovieOverview (MovieCompany movieCompany){
		this.movieCompany = movieCompany;
		this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));
       	Label lblHeading = new Label("Movie Inventory");        
        lblHeading.setFont(new Font("Arial", 20));
        table = new TableView<Movie>();        
        table.setItems(movieCompany.loadData()); 
        TableColumn<Movie, String> colTitle = new TableColumn("Title");
        colTitle.setMinWidth(300);        
        colTitle.setCellValueFactory(new PropertyValueFactory<Movie, String>("Title"));
        TableColumn<Movie, Integer> colYear = new TableColumn("Year");
        colYear.setMinWidth(100);
        colYear.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("Year"));
        TableColumn<Movie, Double> colPrice = new TableColumn("Price");
        colPrice.setMinWidth(100);
        colPrice.setCellValueFactory(new PropertyValueFactory<Movie, Double>("Price"));
        table.getColumns().addAll(colTitle, colYear, colPrice); 
        Button button = new Button("Add dummy film");
		button.setOnAction(new AddDummyFilmHandler());
		this.getChildren().addAll(lblHeading, table,button);        
     }
       
    class AddDummyFilmHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			movieCompany.addDummyMovie();
		}
	}

}
