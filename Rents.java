import java.util.*;
/**
 * Rents represents a List with the article numbers and the rent date per customer
 * calculates the duration of rent
 */
public class Rents {

	private List<Integer> rentID;
	private Date date;
	private Date returnDate = new Date();
	
	public Rents(List<Integer> rentID, Date date){
		this.rentID = rentID;
		this.date = date;
	}
	
	public boolean containsArticle(Integer i){
		if(rentID.contains(i)){
			return true;
		}
		return false;
	}

	public boolean removeArticle(Integer i){
		rentID.remove(i);
		if(rentID.isEmpty()){
			return true;
		}
		return false;
	}

	//calculates duration of rent
	public int duration(Date returnDate){
		int countdays = 0;
		countdays += (int) (returnDate.getTime() - date.getTime()) / (1000 * 60 * 60 * 24);
		if(date.compareTo(returnDate)==0) countdays=1; //if its just rented for one day
		return countdays;
	}
	
	public Date getRentDate(){
		return date;
	}
	
	public List<Integer> getList(){
		return rentID;
	}
}