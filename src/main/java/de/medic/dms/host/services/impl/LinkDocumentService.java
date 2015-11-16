package de.medic.dms.host.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.medic.dms.host.dao.ILinkDocumentDAO;
import de.medic.dms.host.exception.DataNotFoundException;
import de.medic.dms.host.model.LinkDocument;
import de.medic.dms.host.model.Relation;
import de.medic.dms.host.model.Right;
import de.medic.dms.host.services.ILinkDocumentService;

@Stateless
public class LinkDocumentService implements ILinkDocumentService {

    @EJB
    ILinkDocumentDAO linkDocumentDAO;
	
    @Override
	public List<LinkDocument> listLinkDocuments() {	
    
		return linkDocumentDAO.getAllLinkDocuments();
	}
    
	@Override	
	public LinkDocument getLinkDocument(int id) throws DataNotFoundException{		
		LinkDocument tempLinkDocument = linkDocumentDAO.getLinkDocument(id);	
		if(tempLinkDocument == null){
			throw new DataNotFoundException("Link Document Not Found");
		}
		return tempLinkDocument;
	}
	
	@Override
	public LinkDocument saveLinkDocument(LinkDocument linkDocument) {		
		return linkDocumentDAO.saveLinkDocument(linkDocument);
	}
	@Override
	public void updateLinkDocument(LinkDocument linkDocument) {
		linkDocumentDAO.updateLinkDocument(linkDocument);
	}
	
	@Override
	public void deleteLinkDocument(int id) {
		linkDocumentDAO.deleteLinkDocument(id);
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
