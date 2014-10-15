/**
 * Article represents an Article
 */

public class Article {
		
		private int articleID;
		private String articleName;
		private double price;
		private static int idcount=0;  
		
		public Article(String name, double price){
			articleID = idcount;
			this.articleName=name;
			this.price=price;
			idcount++;	
		}
		public int getID(){
				return articleID;	
		}
		
		public double getPrice(){
				return this.price;	
		}
		
		public String getName(){
			return articleName;
		}
		
		public String toString(){
				return 	"ID: " + getID() +
					"\nName: " + this.articleName +
					"\nPrice: " + this.price;	
		}
}