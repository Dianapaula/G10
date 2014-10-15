/**
 * CustomerTest adds Customers
 */

import java.util.List;

public class CustomerTest extends TestBatch{
	
	//add customers into the system
	public void executeTest(Surfstore store) throws TestFailedException{
		store.addCustomer(new Customer("Max Mustermann"));
		store.addCustomer(new Customer("Marlene Musterfrau"));
		store.addCustomer(new Customer("Friedrich Friedelbauer"));
		store.addCustomer(new Customer("Benjamin Linus"));
		store.addCustomer(new Customer("River Tam"));
		store.addCustomer(new Customer("Cthulu"));
		store.addCustomer(new Customer("Heinz Oberhummer"));
		store.addCustomer(new Customer("Zuul"));
		store.addCustomer(new Customer("Wheatley"));
		store.addCustomer(new Customer("A Caveman"));
		List<Customer> list = store.getCustomers();
		for(Customer cus : list){
			System.out.println(cus + "\n");
		}
		if(list.size() != 10){
			throw new TestFailedException("incorrect number of customers");
		}
	}
	
	public String displayTitle(){
		return "Customer-Test";
	}
	
}
