package de.medic.cms.host.dms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.medic.cms.host.dms.dao.IDocumentDAO;
import de.medic.cms.host.dms.model.Document;

@Stateless
public class DocumentDAO_MOCK implements IDocumentDAO {

	private List<Document> mockDocuments;
	
	public DocumentDAO_MOCK(){		
		mockDocuments = new ArrayList<>();
		mockDocuments.add(new Document(123, "Document One"));
		mockDocuments.add(new Document(456, "Document Two"));
		mockDocuments.add(new Document(789, "Document Three"));
	}
	
	@Override
	public List<Document> getAllDocuments() {			
		return mockDocuments;
	}
	
	@Override
	public Document getDocument(int id) {		
		
		int indexOfDoc = findDocumentIndex(id);
		if (indexOfDoc < 0) {
			return null;
		}
		Document document = mockDocuments.get(indexOfDoc);
		return document;		
	}
	
	@Override
	public void updateDocument(Document document) {	
		deleteDocument(document.getId());
		mockDocuments.add(document);
	}
	
	@Override
	public void deleteDocument(int id) {		
		int indexOfDoc = findDocumentIndex(id);
		if (indexOfDoc > -1) {
			Document document = mockDocuments.get(indexOfDoc);
			mockDocuments.remove(mockDocuments.indexOf(document));	
		}	
	}

	@Override
	public Document saveDocument(Document document) {	
		mockDocuments.add(document);
		return document;
	}
	
	public int findDocumentIndex(int id){
		int x = 0;
		int y = -1;
		for(Document next : mockDocuments){
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




