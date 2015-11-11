package de.medic.cms.host.dms.services;

import java.util.List;

import javax.ejb.Local;

import de.medic.cms.host.dms.model.Document;
import de.medic.cms.host.dms.model.Relation;
import de.medic.cms.host.dms.model.Right;

@Local 
public interface IDocumentService {

	public List<Document> listDocuments();
	public Document getDocument(int id);
	public Document saveDocument(Document document);
	public void updateDocument(Document document);
	public void deleteDocument(int id);
	public void addRelation(Relation relation);
	public void deleteRelation(Relation relation);
	public void setRights(Right right);
		
}
