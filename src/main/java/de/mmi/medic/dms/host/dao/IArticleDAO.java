package de.mmi.medic.dms.host.dao;

import java.util.List;

import javax.ejb.Local;

import de.mmi.medic.dms.host.model.Article;

@Local 
public interface IArticleDAO {

	List<Article> getAllArticles();

	Article getArticle(int id);

	void updateArticle(Article article);

	void deleteArticle(int id);
	
	Article saveArticle(Article article);

}