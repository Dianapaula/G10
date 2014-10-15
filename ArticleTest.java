/**
 * ArticleTest adds Articles 
 */

import java.util.List;

public class ArticleTest extends TestBatch{
	
	//add a small number of articles to the store
	//information from http://www.pacificsurfschool.com/rentals#rental-prices
	public void executeTest(Surfstore store) throws TestFailedException{
		store.addArticle(new Article("Surf Board", 16.0));
		store.addArticle(new Article("Surf Board", 16.0));
		store.addArticle(new Article("Surf Board", 16.0));
		store.addArticle(new Article("Fiberglass Surf Board", 33.0));
		store.addArticle(new Article("Fiberglass Surf Board", 33.0));
		store.addArticle(new Article("Wetsuit", 16.0));
		store.addArticle(new Article("Wetsuit", 16.0));
		store.addArticle(new Article("Child Wetsuit", 11.5));
		store.addArticle(new Article("Body Board", 11.5));
		store.addArticle(new Article("Body Board", 11.5));
		store.addArticle(new Article("Body Board", 11.5));
		store.addArticle(new Article("Skim Board", 11.5));
		store.addArticle(new Article("Boots, Gloves, Hood", 3.0));
		store.addArticle(new Article("Boots, Gloves, Hood", 3.0));
		store.addArticle(new Article("SUP & Paddle", 33.0));
		store.addArticle(new Article("SUP & Paddle", 33.0));
		store.addArticle(new Article("Bike (with surf rack)", 20.0));
		store.addArticle(new Article("SUP Paddle", 20.0));
		store.addArticle(new Article("Roof Racks", 3.0));
		store.addArticle(new Article("Swim Fins", 3.0));
		List<Article> list = store.availableArticles();
		for(Article item : list){
			System.out.println(item + "\n");
		}
		if(list.size() != 20){
			throw new TestFailedException("incorrect number of items");
		}
	}
	
	public String displayTitle(){
		return "Article-Test";
	}
	
}
