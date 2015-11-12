package de.medic.cms.host.dms.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import de.medic.cms.host.dms.model.Document;

public class DocumentDAO_MOCKTest {

	DocumentDAO_MOCK documentDAO_MOCK;		
	
	@Before
	public void setUp() throws Exception {
		documentDAO_MOCK = new DocumentDAO_MOCK();		
	}
	
	@Test
	public void testGetAllDocuments() {
		//Arrange
		
		//Act
		
		//Assert
		assertEquals(documentDAO_MOCK.getAllDocuments().size(), 3);
	}

	@Test
	public void testGetDocument() {
		//Arrange
		
		//Act
		Document doc = documentDAO_MOCK.getDocument(123);
		
		//Assert
		assertEquals("Document One", doc.getName());
	}

	@Test
	public void testUpdateDocument() {
		//Arrange
		Document doc = documentDAO_MOCK.getDocument(123);		
		doc.setName("Document One Updated");
		
		//Act
		documentDAO_MOCK.updateDocument(doc);
		Document docUpdated = documentDAO_MOCK.getDocument(123);		
		
		//Assert
		assertEquals("Document One Updated", docUpdated.getName());		
	}

	@Test
	public void testDeleteDocument() {
		//Arrange
		Document doc = documentDAO_MOCK.getDocument(456);
		
		//Act
		documentDAO_MOCK.deleteDocument(doc.getId());
		
		//Assert
		assertEquals(documentDAO_MOCK.getAllDocuments().size(), 2);
	}
		
	@Test()  	
	public void testGetNonExistingDocumentShouldThrowDataNotFound() {
		//Arrange
		Document doc = documentDAO_MOCK.getDocument(13);
		
		//Act
		
		//Assert
		assertNull(doc);
	}
	

}
