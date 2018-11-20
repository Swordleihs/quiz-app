package domain;

public class Movie {    
	private String title;     
	private int year;    
	private double price;

	public Movie()    {
		this("",0,0.0);
	}        

	public Movie(String title, int year, double price)     {        
		setTitle(title);        
		setYear(year);        
		setPrice(price);    
	}

	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public void setYear(int year){        
		this.year = year;    
	}
	
	public double getPrice(){        
		return this.price; 
	}
	
	public void setPrice(double price){        
		this.price = price; 
	}

}

