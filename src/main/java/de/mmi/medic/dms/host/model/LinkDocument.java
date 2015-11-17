package de.mmi.medic.dms.host.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LinkDocument extends Document{
		
	private List<Author> authors;
			
	public LinkDocument() {};
	
	public LinkDocument(int id, String name, String extension, String title) {
		super(id, name, extension, title);		
	}
	
	
	@Override
	public String toString() {
		return "LinkDocument [authors=" + authors + "]";
	}

	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	
}
