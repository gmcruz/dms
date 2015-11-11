package de.medic.cms.host.dms.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import de.medic.cms.host.dms.dao.impl.DocumentDAO_MOCK;
import de.medic.cms.host.dms.exception.DataNotFoundException;
import de.medic.cms.host.dms.model.Document;

public class DocumentDAO_MOCKTest {

	@Test
	public void testGetAllDocuments() {
		DocumentDAO_MOCK documentDAO_MOCK = new DocumentDAO_MOCK();		
		assertEquals(documentDAO_MOCK.getAllDocuments().size(), 3);
	}

	@Test
	public void testGetDocument() {
		DocumentDAO_MOCK documentDAO_MOCK = new DocumentDAO_MOCK();
		Document doc = documentDAO_MOCK.getDocument(123);
		assertEquals("Document One", doc.getName());
	}

	@Test
	public void testUpdateDocument() {
		DocumentDAO_MOCK documentDAO_MOCK = new DocumentDAO_MOCK();
		Document doc = documentDAO_MOCK.getDocument(123);
		doc.setName("Document One Updated");		
		documentDAO_MOCK.updateDocument(doc);
		Document docUpdated = documentDAO_MOCK.getDocument(123);		
		assertEquals("Document One Updated", docUpdated.getName());		
	}

	@Test
	public void testDeleteDocument() {
		DocumentDAO_MOCK documentDAO_MOCK = new DocumentDAO_MOCK();
		Document doc = documentDAO_MOCK.getDocument(456);
		documentDAO_MOCK.deleteDocument(doc.getId());
		assertEquals(documentDAO_MOCK.getAllDocuments().size(), 2);
	}
	
	@Ignore
	@Test(expected = DataNotFoundException.class)  	
	public void testGetNonExistingDocumentShouldThrowDataNotFound() {
		DocumentDAO_MOCK documentDAO_MOCK = new DocumentDAO_MOCK();
		Document doc = documentDAO_MOCK.getDocument(13);
		assertEquals("Document One", doc.getName());
	}

}
