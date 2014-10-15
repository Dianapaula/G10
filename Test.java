/*

0950807 Magdalena Schwarz
überlegen des Aufbaus
erstellen der Klassen Rents und Surfstore 
duration, return Articles (Iterator)
Objekt Date angeschaut und eingebaut,
Kommentare und Ausgaben gecheckt

1127864 Costea Diana
überlegen des Aufbaus und 
die Klassen Customer und Article geschrieben

1131972 Matthias Hummel
Responsible for test cases and testing
classes: Test TestBatch ArticleTest CustomerTest ServiceTest TestFailedException

*/

//to allow for flexibility, testing code is separated and implemented in subclasses of TestBatch
public class Test{
	
	
	public static void main(String[] args){
		Surfstore store = new Surfstore();
		new ArticleTest().start(store);
		new CustomerTest().start(store);
		new ServiceTest().start(store);
	}
	
}
