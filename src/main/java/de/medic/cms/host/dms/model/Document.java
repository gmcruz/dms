package de.medic.cms.host.dms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Document {
	
	@Id
	private int id;
	private String name;
	private Date created;
	private List<Author> authors;
			
	public Document() {};
	
	public Document(int id, String name) {
		this.id = id;
		this.name = name;
		this.created = new Date();		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", created=" + created + "]";
	}
	
	
	
}
