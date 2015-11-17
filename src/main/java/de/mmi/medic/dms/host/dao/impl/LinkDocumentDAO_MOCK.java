package de.mmi.medic.dms.host.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.mmi.medic.dms.host.dao.ILinkDocumentDAO;
import de.mmi.medic.dms.host.model.LinkDocument;

@Stateless
public class LinkDocumentDAO_MOCK implements ILinkDocumentDAO {

	private List<LinkDocument> mockLinkDocuments;
	
	public LinkDocumentDAO_MOCK(){		
		mockLinkDocuments = new ArrayList<>();
		mockLinkDocuments.add(new LinkDocument(123, "linkdocumentone", "pdf", "LinkDocument One"));
		mockLinkDocuments.add(new LinkDocument(456, "linkdocumenttwo", "pdf", "LinkDocument Two"));
		mockLinkDocuments.add(new LinkDocument(789, "linkdocumentthree", "pdf", "LinkDocument Three"));
	}
	
	@Override
	public List<LinkDocument> getAllLinkDocuments() {			
		return mockLinkDocuments;
	}
	
	@Override
	public LinkDocument getLinkDocument(int id) {		
		
		int indexOfDoc = findLinkDocumentIndex(id);
		if (indexOfDoc < 0) {
			return null;
		}
		LinkDocument document = mockLinkDocuments.get(indexOfDoc);
		return document;		
	}
	
	@Override
	public void updateLinkDocument(LinkDocument linkDocument) {	
		deleteLinkDocument(linkDocument.getId());
		mockLinkDocuments.add(linkDocument);
	}
	
	@Override
	public void deleteLinkDocument(int id) {		
		int indexOfDoc = findLinkDocumentIndex(id);
		if (indexOfDoc > -1) {
			LinkDocument document = mockLinkDocuments.get(indexOfDoc);
			mockLinkDocuments.remove(mockLinkDocuments.indexOf(document));	
		}	
	}

	@Override
	public LinkDocument saveLinkDocument(LinkDocument document) {	
		mockLinkDocuments.add(document);
		return document;
	}
	
	public int findLinkDocumentIndex(int id){
		int x = 0;
		int y = -1;
		for(LinkDocument next : mockLinkDocuments){
			//System.out.println("if(" + next.getId() + " == " + id + ")");
			if(next.getId() == id){
				//System.out.println("YES Found match on if(" + next.getId() + " == " + id + ")");
				y=x; 
				break;
			}
			x=x+1;
		}
		//System.out.println("RETURNING THE FOUND index as: " + y);
		return y;		
	}
}




