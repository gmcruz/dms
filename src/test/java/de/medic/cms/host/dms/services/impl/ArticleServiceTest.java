package de.medic.cms.host.dms.services.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import de.medic.cms.host.dms.dao.impl.ArticleDAO_MOCK;
import de.medic.cms.host.dms.exception.DataNotFoundException;
import de.medic.cms.host.dms.model.Article;
import de.medic.cms.host.dms.model.Relation;
import de.medic.cms.host.dms.model.Right;

public class ArticleServiceTest {
	
	ArticleService articleService;
	
	@Before
	public void setUp() throws Exception {
		articleService = new ArticleService(new ArticleDAO_MOCK());
	}
	
	
	@Test
	public void testListArticles() {		
		//Arrange		
						
		//Act
		List<Article> arts = articleService.listArticles();
		
		//Assert
		assertEquals(3, arts.size());
	}

	
	@Test
	public void testGetArticle() {		
		//Arrange
				
		//Act
		Article art = articleService.getArticle(123);
		
		//Assert
		assertEquals("Article Not Found", "Article One", art.getHtmlTitle());
	}	

	@Test(expected=DataNotFoundException.class)
	public void testgetArticle_DataNotFoundException() {		
		//Arrange
				
		//Act
		@SuppressWarnings("unused")
		Article art = articleService.getArticle(666);	
		
		//Assert
		//@Test(expected=DataNotFoundException.class)
	}
	
	
	@Test
	public void testSaveArticle() {		
		//Arrange
		Article art = articleService.getArticle(123);
		Random rand = new Random();		
		
		//Act		
		art.setId(rand.nextInt(100000));
		art.setHtmlTitle("New Article to read");
		articleService.saveArticle(art);
		List<Article> arts = articleService.listArticles();
		
		//Assert
		assertEquals(4, arts.size());
	}
	
	@Test
	public void testUpdateArticle() {		
		//Arrange	
		Article art = articleService.getArticle(123);
		String expected = "Article One updated title";
		
		//Act;
		art.setHtmlTitle(expected);
		articleService.saveArticle(art);
		Article updatedArt = articleService.getArticle(123);	
				
		//Assert
		assertEquals("Article Html Titles do not match.", expected, updatedArt.getHtmlTitle());
	}
		
	@Test
	public void testDeleteArticle() {		
		//Arrange	
				
		//Act
		articleService.deleteArticle(123);
		List<Article> arts = articleService.listArticles();
		
		//Assert
		assertEquals(2, arts.size());
	}	
	
	@Test
	public void testAddRelationToArticle() {		
		//Arrange
		Random rand = new Random();	
		Article article = articleService.getArticle(123);
		int realtionId = rand.nextInt(100000); 
		int relationObjectTypeId = rand.nextInt(100000); 
		int relationObjectId = rand.nextInt(100000);
		Relation newRelation = new Relation(realtionId, relationObjectTypeId, relationObjectId);
				
		//Act
		articleService.addRelation(article, newRelation);		
		Article articleChanged = articleService.getArticle(123);
		
		//Assert
		assertEquals(1, articleChanged.getRelations().size());
	}
	
	@Test
	public void testDeleteRelationFromArticle() {		
		//Arrange
		Random rand = new Random();	
		Article article = articleService.getArticle(123);
		int realtionId = rand.nextInt(100000); 
		int relationObjectTypeId = rand.nextInt(100000); 
		int relationObjectId = rand.nextInt(100000);
		Relation newRelation = new Relation(realtionId, relationObjectTypeId, relationObjectId);
				
		//Act
		articleService.addRelation(article, newRelation);		
		Article articleChanged = articleService.getArticle(123);
		articleService.deleteRelation(articleChanged, newRelation);
		
		//Assert
		assertEquals(0, articleChanged.getRelations().size());
	}
	
	@Test
	public void testAddRightToArticle() {		
		//Arrange
		Random rand = new Random();	
		Article article = articleService.getArticle(123);
		int realtionId = rand.nextInt(100000); 
		int rightObjectTypeId = rand.nextInt(100000); 
		int rightObjectId = rand.nextInt(100000);
		int rightType = rand.nextInt(100000); 
		Right newRight = new Right(realtionId, rightObjectTypeId, rightObjectId, rightType);
				
		//Act
		articleService.addRight(article, newRight);		
		Article articleChanged = articleService.getArticle(123);
		
		//Assert
		assertEquals(1, articleChanged.getRights().size());
	}	
	
	@Test
	public void testDeleteRightFromArticle() {		
		//Arrange
		Random rand = new Random();	
		Article article = articleService.getArticle(123);
		int realtionId = rand.nextInt(100000); 
		int rightObjectTypeId = rand.nextInt(100000); 
		int rightObjectId = rand.nextInt(100000);
		int rightType = rand.nextInt(100000); 
		Right newRight = new Right(realtionId, rightObjectTypeId, rightObjectId, rightType);
				
		//Act
		articleService.addRight(article, newRight);		
		Article articleChanged = articleService.getArticle(123);
		articleService.deleteRight(articleChanged, newRight);
		
		//Assert
		assertEquals(0, articleChanged.getRights().size());
	}	
	
	
}
