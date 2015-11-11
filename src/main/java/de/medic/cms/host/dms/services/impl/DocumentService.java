package de.medic.cms.host.dms.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.medic.cms.host.dms.dao.IDocumentDAO;
import de.medic.cms.host.dms.exception.DataNotFoundException;
import de.medic.cms.host.dms.model.Document;
import de.medic.cms.host.dms.model.Relation;
import de.medic.cms.host.dms.model.Right;
import de.medic.cms.host.dms.services.IDocumentService;

@Stateless
public class DocumentService implements IDocumentService {

    @EJB
    IDocumentDAO documentDAO;
	
    @Override
	public List<Document> listDocuments() {	
    
		return documentDAO.getAllDocuments();
	}
    
	@Override	
	public Document getDocument(int id) throws DataNotFoundException{		
		Document tempDocument = documentDAO.getDocument(id);	
		if(tempDocument == null){
			throw new DataNotFoundException("Document Not Found");
		}
		return tempDocument;
	}
	
	@Override
	public Document saveDocument(Document document) {		
		return documentDAO.saveDocument(document);
	}
	@Override
	public void updateDocument(Document document) {
		documentDAO.updateDocument(document);
	}
	
	@Override
	public void deleteDocument(int id) {
		documentDAO.deleteDocument(id);
	}
	
	@Override
	public void addRelation(Relation relation) {
		
	}

	@Override
	public void deleteRelation(Relation relation) {
		
	}

	@Override
	public void setRights(Right right) {
		
	}

}
