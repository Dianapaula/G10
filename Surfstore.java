import java.util.*;
/**
 * 
 * Surfstore represents the rental store. 
 * Contains the rent and return methods
 * 		prints a List of rented articles
 * 		calculates rented and available articles
 *		checks which articles are available
 */
public class Surfstore {

	private HashMap<Customer, List<Rents>> customerList = new HashMap<Customer, List<Rents>>(); //Rents	contains all rented Article per customer and their rentdate
	private HashMap<Article, Boolean> inventar = new HashMap<Article, Boolean>(); //contains all articles, and their status 
	private Rents r;
	
	private Customer searchCustomer(int cID){
		for(Customer c : customerList.keySet()){
			if(c.getID() == cID){
				return c;
			}
		}
		return null;
	}
	
	private Article searchArticle(int aID){
		for(Article a : inventar.keySet()){
			if(a.getID() == aID){
				return a;
			}
		}
		return null;
	}
	//returns the rented and available articles
	public void checkStock(String name){
		int available = 0;
		int rented = 0;
		for(Map.Entry<Article, Boolean> me : inventar.entrySet()){
			if(me.getKey().getName().equals(name)){
				if(me.getValue()){
					available++;
				}
				else{
					rented++;
				}
			}
		}
		System.out.println("Article: " + name + "\nin stock: " + available + "\nrented: " + rented + "\n");
	}
	
	public void printCustomerArticles(int cid){
		Customer c = searchCustomer(cid);
		System.out.println("Articles in possession of " + c.getName() + ":\n");
		System.out.println("-------------\n");
		for(Rents r :customerList.get(c)){
			for(Integer i : r.getList()){
				System.out.println(searchArticle(i) + "\n");
			}
		}
		System.out.println("-------------");
	}

	public void addArticle(Article article){
		inventar.put(article, true);
	}
	
	/*rents article and implements new Rents with the articles and rentDate per customer 
	changes status from article
	*/
	public void rent(List<Integer> articles, int CustomerID, Date rentDate){
		for(Integer i : articles){
			if(!inventar.get(searchArticle(i))){
				System.out.println("Bestellung nicht moeglich");
				return;
			}
		}
		customerList.get(searchCustomer(CustomerID)).add(new Rents(articles, rentDate));
		for(Integer i : articles){
			inventar.put(searchArticle(i), false);
		}
	}

	//returning of articles, calculates price (duration)
	public void returnArticles(List<Integer> articles, int CustomerID, Date rentDate){
		double price = 0.0;
		double sum = 0;
		Iterator<Rents> it = customerList.get(searchCustomer(CustomerID)).iterator(); //iterates the rentList per customer
	
		while (it.hasNext()){
			r = it.next();
			for(Integer i : articles){
				if(r.containsArticle(i)){
					//if Rents has no items left, it will be removed from the list
					if(r.removeArticle(i)){
						it.remove();
					}
					Article a = searchArticle(i);
					sum += a.getPrice(); //gets sum of all returned articles
					inventar.put(a, true);
					price = sum * r.duration(rentDate); //multiplies the sum with the duration of the rent.
				}
			}
		}
		System.out.println("Customer has to pay "+price+"€.\n\n");

	}
	
	//add Customer
	public void addCustomer(Customer client){
		customerList.put(client, new ArrayList<Rents>());
	}

	//returns a List with all available Articles
	public List<Article> availableArticles(){
		ArrayList<Article> list = new ArrayList<>();
		for(Article a : inventar.keySet()){
			if(inventar.get(a)){
				list.add(a);
			}
		}
		return list;
	}

	public List<Customer> getCustomers(){
		return new ArrayList<Customer>(customerList.keySet());
	}
	
	//prints all rented articles
	public void printRentList(){
		for(Customer c : customerList.keySet()){
			if(!customerList.get(c).isEmpty()){
				System.out.println("--------Rentstate--------\n" +  c + "\n");
				for(Rents r :customerList.get(c)){
					System.out.println("-------------\n");
					System.out.println("Date: " + r.getRentDate().toString() + "\n");
					for(Integer i : r.getList()){
						System.out.println(searchArticle(i) + "\n");
					}
					System.out.println("-------------");
				}
				System.out.println();
			}
		}
	}
}