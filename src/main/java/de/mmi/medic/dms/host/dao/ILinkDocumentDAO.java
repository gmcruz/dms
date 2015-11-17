package de.mmi.medic.dms.host.dao;

import java.util.List;

import javax.ejb.Local;

import de.mmi.medic.dms.host.model.LinkDocument;

@Local 
public interface ILinkDocumentDAO {

	List<LinkDocument> getAllLinkDocuments();

	LinkDocument getLinkDocument(int id);

	void updateLinkDocument(LinkDocument linkDocument);

	void deleteLinkDocument(int id);
	
	LinkDocument saveLinkDocument(LinkDocument linkDocument);

}