package domain;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovieCompany {
	private ObservableList<Movie> data;
	
	public MovieCompany(){
		data = FXCollections.observableArrayList(new ArrayList<Movie>());
		data.add(new Movie("It's a Wonderful Life", 1946, 14.95));
		data.add(new Movie("Young Frankenstein", 1974, 16.95));
		data.add(new Movie("Star Wars Episode 4", 1976, 17.95));
		data.add(new Movie("The Princess Bride",1987, 16.95));
		data.add(new Movie("Glory", 1989, 14.95));
		data.add(new Movie("The Game",1997, 14.95));
		data.add(new Movie("Shakespeare in Love",1998, 19.95));
		data.add(new Movie("The Invention of Lying", 2009, 18.95));
		data.add(new Movie("The King's Speech", 2010, 19.95));
	}
	
	public ObservableList<Movie> loadData()     {    	
        return data;
    }
	
	public void addDummyMovie(){
		Movie movie = new Movie("Dummy", 2018,20.00);
		data.add(movie);		
	}
}
