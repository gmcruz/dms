package de.medic.cms.host.dms.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.medic.cms.host.dms.dao.IArticleDAO;
import de.medic.cms.host.dms.exception.CatchAllException;
import de.medic.cms.host.dms.exception.DataNotFoundException;
import de.medic.cms.host.dms.model.Article;
import de.medic.cms.host.dms.model.Relation;
import de.medic.cms.host.dms.model.Right;
import de.medic.cms.host.dms.services.IArticleService;

@Stateless
public class ArticleService implements IArticleService {

    @EJB
    IArticleDAO articleDAO;
    
    
    public ArticleService() {}    
	
    public ArticleService(IArticleDAO articleDAO) {
		super();
		this.articleDAO = articleDAO;
	}

	@Override
	public List<Article> listArticles() {	    
		return articleDAO.getAllArticles();
	}
    
	@Override	
	public Article getArticle(int id) throws DataNotFoundException{		
		Article tempArticle = articleDAO.getArticle(id);	
		if(tempArticle == null){
			throw new DataNotFoundException("Article Not Found");
		}
		return tempArticle;
	}
	
	@Override
	public Article saveArticle(Article article) throws CatchAllException{				
		Article tempArticle = articleDAO.saveArticle(article);
		if(tempArticle == null){
			throw new CatchAllException("Article could not be saved.");
		}
		return tempArticle;
	}
	
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);		
	}
	
	@Override
	public void deleteArticle(int id) {
		articleDAO.deleteArticle(id);
	}
	
	@Override
	public void addRelation(Article article, Relation relation) {
		List<Relation> tempRelations = article.getRelations();	
		if(!tempRelations.contains(relation)){
			tempRelations.add(relation);
		}
	}

	@Override
	public void deleteRelation(Article article, Relation relation) {
		List<Relation> tempRelations = article.getRelations();
		int indxOf = tempRelations.indexOf(relation);
		if(indxOf > -1){
			article.getRelations().remove(indxOf);
		}
	}

	@Override
	public void addRight(Article article, Right right) {
		List<Right> tempRights = article.getRights();	
		if(!tempRights.contains(right)){
			tempRights.add(right);
		}
	}

	@Override
	public void deleteRight(Article article, Right right) {
		List<Right> tempRights = article.getRights();
		int indxOf = tempRights.indexOf(right);
		if(indxOf > -1){
			article.getRights().remove(indxOf);
		}
	}

}
