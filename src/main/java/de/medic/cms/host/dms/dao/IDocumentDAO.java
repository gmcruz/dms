package de.medic.cms.host.dms.dao;

import java.util.List;

import javax.ejb.Local;

import de.medic.cms.host.dms.model.Document;

@Local 
public interface IDocumentDAO {

	List<Document> getAllDocuments();

	Document getDocument(int id);

	void updateDocument(Document document);

	void deleteDocument(int id);
	
	Document saveDocument(Document document);

}