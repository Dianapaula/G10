

public abstract class TestBatch{
	
	
	public void start(Surfstore store){
		System.out.println(displayTitle());
		System.out.println("------------------------------------------------");
		try{
			executeTest(store);
			System.out.println("test successful");
		}
		catch(TestFailedException tfe){
			System.out.println("FAILED");
		}
		System.out.println("------------------------------------------------\n\n");
		
	}
	
	public abstract String displayTitle();
	
	public abstract void executeTest(Surfstore store) throws TestFailedException;
	
}
