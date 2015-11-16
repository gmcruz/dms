package de.medic.dms.host.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.medic.dms.host.dao.IArticleDAO;
import de.medic.dms.host.model.Article;

@Stateless
public class ArticleDAO_MOCK implements IArticleDAO {

	private List<Article> mockArticles;
	
	public ArticleDAO_MOCK(){		
		mockArticles = new ArrayList<>();
		mockArticles.add(new Article(123, "articleone", "doc", "Article One"));
		mockArticles.add(new Article(456, "articleone", "txt", "Article Two"));
		mockArticles.add(new Article(789, "articleone", "ppt", "Article Three"));
	}
	
	@Override
	public List<Article> getAllArticles() {			
		return mockArticles;
	}
	
	@Override
	public Article getArticle(int id) {		
		
		int indexOfDoc = findArticleIndex(id);
		if (indexOfDoc < 0) {
			return null;
		}
		Article article = mockArticles.get(indexOfDoc);
		return article;		
	}
	
	@Override
	public void updateArticle(Article article) {	
		deleteArticle(article.getId());
		mockArticles.add(article);
	}
	
	@Override
	public void deleteArticle(int id) {		
		int indexOfDoc = findArticleIndex(id);
		if (indexOfDoc > -1) {
			Article article = mockArticles.get(indexOfDoc);
			mockArticles.remove(mockArticles.indexOf(article));	
		}	
	}

	@Override
	public Article saveArticle(Article article) {	
		mockArticles.add(article);
		return article;
	}
	
	public int findArticleIndex(int id){
		int x = 0;
		int y = -1;
		for(Article next : mockArticles){
			if(next.getId() == id){
				y=x; 
				break;
			}
			x=x+1;
		}
		return y;		
	}
}




