package de.medic.dms.host.services;

import java.util.List;

import javax.ejb.Local;

import de.medic.dms.host.model.LinkDocument;
import de.medic.dms.host.model.Relation;
import de.medic.dms.host.model.Right;

@Local 
public interface ILinkDocumentService {

	public List<LinkDocument> listLinkDocuments();
	public LinkDocument getLinkDocument(int id);
	public LinkDocument saveLinkDocument(LinkDocument document);
	public void updateLinkDocument(LinkDocument document);
	public void deleteLinkDocument(int id);
	public void addRelation(Relation relation);
	public void deleteRelation(Relation relation);
	public void setRights(Right right);
		
}
