package de.mmi.medic.dms.host.util;

import de.mmi.medic.dms.host.model.Document;

public class GenerateDocumentSignature {

	private static String LinkDocumentPath = "/dms/documents/linkdocuments/";
	private static String ArticleDocumentPath = "/dms/documents/articles/";
	
	public static void generateDocumentPath(Document document) {

		switch (document.getClass().getSimpleName().toString()) {
		case "Article":
			document.setDirectoryPath(ArticleDocumentPath + document.getUniqueName() + "." + document.getExtension());
			break;
		case "LinkDocument":
			document.setDirectoryPath(LinkDocumentPath + document.getUniqueName() + "." + document.getExtension());
			break;
		default:
			throw new IllegalArgumentException(
					"Invalid document type from string: " + document.getClass().getName().toString());
		}

	}
	
	public static void generateDocumentUniqueName(Document document){
		document.setUniqueName(java.util.UUID.randomUUID().toString());
	}
	
	
}
