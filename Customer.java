/**
 * Article represents a Customer
 */

public class Customer {

		private int customerID;
		private String customerName;
		private static int idcount=0;
		
		public Customer(String name) {
			this.customerID=idcount;
			this.customerName=name;
			idcount++;
		}
		
		public int getID(){
				return this.customerID;
		}
		
		public String getName(){
				return this.customerName;
		}
		
		public String toString(){
			return 	"ID: " + this.customerID +
				"\nName: " + this.customerName;
		}
}
