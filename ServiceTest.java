import java.util.ArrayList;
import java.text.*;
/**
 * ServiceTest simulates rental requests
 */
public class ServiceTest extends TestBatch{
	
	private static  DateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
	
	//simulate some renting requests
	public void executeTest(Surfstore store) throws TestFailedException{
		try{
			store.rent(new ArrayList<Integer>(){{add(0);}}, 4, parser.parse("30.12.2013"));
			System.out.println("Customer 4 returns 0 after 2 days");
			store.returnArticles(new ArrayList<Integer>(){{add(0);}}, 4, parser.parse("01.01.2014"));
			store.rent(new ArrayList<Integer>(){{add(0); add(5); add(9);}}, 2, parser.parse("10.06.2014"));
			store.printRentList();
			System.out.println("\n\n");
			//return on the same day equals cost for one day
			System.out.println("Customer 2 returns 5,9 after 0 days");
			store.returnArticles(new ArrayList<Integer>(){{add(5); add(9);}}, 2, parser.parse("10.06.2014"));
			store.rent(new ArrayList<Integer>(){{add(3); add(10); add(18);}}, 8, parser.parse("13.06.2014"));
			store.rent(new ArrayList<Integer>(){{add(14);}}, 2, parser.parse("13.06.2014"));
			store.rent(new ArrayList<Integer>(){{add(1); add(7); add(13);}}, 5, parser.parse("14.06.2014"));
			
			//display some information about state
			store.printRentList();
			System.out.println("\n\n");
			store.printCustomerArticles(2);
			System.out.println("\n\n");
			store.checkStock("Surf Board");
			System.out.println("\n\n");
			
			System.out.println("Customer 8 returns 10,18 after 2 days");
			store.returnArticles(new ArrayList<Integer>(){{add(10); add(18);}}, 8, parser.parse("15.06.2014"));
			System.out.println("Customer 5 returns 1,7,13 after 1 day");
			store.returnArticles(new ArrayList<Integer>(){{add(1); add(7); add(13);}}, 5, parser.parse("15.06.2014"));
			System.out.println("Customer 2 returns 0 after 7 days");
			store.returnArticles(new ArrayList<Integer>(){{add(0);}}, 2, parser.parse("17.06.2014"));
			store.rent(new ArrayList<Integer>(){{add(0);}}, 4, parser.parse("30.05.2014"));
			System.out.println("Customer 4 returns 0 after 2 days");
			store.returnArticles(new ArrayList<Integer>(){{add(0);}}, 4, parser.parse("01.06.2014"));
			
			
			//final state information
			store.printRentList();
			
		}
		catch(ParseException pe){
			System.out.println(pe);
		}
	}
	
	public String displayTitle(){
		return "Service-Test";
	}
	
}