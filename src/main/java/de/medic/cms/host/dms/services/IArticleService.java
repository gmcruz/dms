package de.medic.cms.host.dms.services;

import java.util.List;
import javax.ejb.Local;
import de.medic.cms.host.dms.exception.CatchAllException;
import de.medic.cms.host.dms.exception.DataNotFoundException;
import de.medic.cms.host.dms.model.Article;
import de.medic.cms.host.dms.model.Relation;
import de.medic.cms.host.dms.model.Right;


@Local 
public interface IArticleService {

	List<Article> listArticles();

	Article getArticle(int id) throws DataNotFoundException;

	Article saveArticle(Article article) throws CatchAllException;

	void updateArticle(Article article);

	void deleteArticle(int id);

	void addRelation(Article article, Relation relation);

	void deleteRelation(Article article, Relation relation);

	void addRight(Article article, Right right);

	void deleteRight(Article article, Right right);

}