package de.mmi.medic.dms.host.model;

import java.util.Date;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Author {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private Date created;
			
	public Author() {};
	
	public Author(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.created = new Date();		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}

