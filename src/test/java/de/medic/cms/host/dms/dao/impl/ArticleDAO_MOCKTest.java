package de.medic.cms.host.dms.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import de.medic.cms.host.dms.model.Article;

public class ArticleDAO_MOCKTest {

	ArticleDAO_MOCK articleDAO_MOCK;		
	
	@Before
	public void setUp() throws Exception {
		articleDAO_MOCK = new ArticleDAO_MOCK();		
	}
	
	@Test
	public void testGetAllArticles() {		
		//Arrange
		
		//Act
		
		//Assert
		assertEquals(articleDAO_MOCK.getAllArticles().size(), 3);
	}

	@Test
	public void testGetArticle() {
		//Arrange
		
		//Act
		Article doc = articleDAO_MOCK.getArticle(123);
		
		//Assert
		assertEquals("Article One", doc.getHtmlTitle());
	}

	@Test
	public void testUpdateArticle() {
		//Arrange
		
		//Act
		Article doc = articleDAO_MOCK.getArticle(123);
		doc.setHtmlTitle("Article One Updated");		
		articleDAO_MOCK.updateArticle(doc);
		Article docUpdated = articleDAO_MOCK.getArticle(123);	
		
		//Assert
		assertEquals("Article One Updated", docUpdated.getHtmlTitle());		
	}

	@Test
	public void testDeleteArticle() {
		//Arrange
		Article doc = articleDAO_MOCK.getArticle(456);
		
		//Act
		articleDAO_MOCK.deleteArticle(doc.getId());
		
		//Assert
		assertEquals(articleDAO_MOCK.getAllArticles().size(), 2);
	}	
	
	@Test()  	
	public void testGetNonExistingArticleShouldThrowDataNotFound() {
		//Arrange
		
		//Act
		Article doc = articleDAO_MOCK.getArticle(13);
		
		//Assert
		assertNull(doc);
	}

}