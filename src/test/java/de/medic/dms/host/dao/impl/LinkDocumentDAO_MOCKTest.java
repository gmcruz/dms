package de.medic.dms.host.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import de.medic.dms.host.model.LinkDocument;

public class LinkDocumentDAO_MOCKTest {

	LinkDocumentDAO_MOCK linkDocumentDAO_MOCK;		
	
	@Before
	public void setUp() throws Exception {
		linkDocumentDAO_MOCK = new LinkDocumentDAO_MOCK();		
	}
	
	@Test
	public void testGetAllDocuments() {
		//Arrange
		
		//Act
		
		//Assert
		assertEquals(linkDocumentDAO_MOCK.getAllLinkDocuments().size(), 3);
	}

	@Test
	public void testGetDocument() {
		//Arrange
		
		//Act
		LinkDocument doc = linkDocumentDAO_MOCK.getLinkDocument(123);
		
		//Assert
		assertEquals("LinkDocument One", doc.getTitle());
	}

	@Test
	public void testUpdateDocument() {
		//Arrange
		LinkDocument linkDoc = linkDocumentDAO_MOCK.getLinkDocument(123);		
		linkDoc.setTitle("LinkDocument One Updated");
		
		//Act
		linkDocumentDAO_MOCK.updateLinkDocument(linkDoc);
		LinkDocument docUpdated = linkDocumentDAO_MOCK.getLinkDocument(123);		
		
		//Assert
		assertEquals("LinkDocument One Updated", docUpdated.getTitle());		
	}

	@Test
	public void testDeleteDocument() {
		//Arrange
		LinkDocument doc = linkDocumentDAO_MOCK.getLinkDocument(456);
		
		//Act
		linkDocumentDAO_MOCK.deleteLinkDocument(doc.getId());
		
		//Assert
		assertEquals(linkDocumentDAO_MOCK.getAllLinkDocuments().size(), 2);
	}
		
	@Test()  	
	public void testGetNonExistingDocumentShouldThrowDataNotFound() {
		//Arrange
		LinkDocument doc = linkDocumentDAO_MOCK.getLinkDocument(13);
		
		//Act
		
		//Assert
		assertNull(doc);
	}
	

}
