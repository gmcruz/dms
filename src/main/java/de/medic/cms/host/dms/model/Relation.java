package de.medic.cms.host.dms.model;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	
public class Relation {
	
	@Id
	private int id;
	private int objectTypeId; //what type of object is being related.
	private int objectId;	//what is the id of the object being related.
	
		
	public Relation() {}

	public Relation(int id, int objectTypeId, int objectId) {
		super();
		this.id = id;
		this.objectTypeId = objectTypeId;
		this.objectId = objectId;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getObjectTypeId() {
		return objectTypeId;
	}
	public void setObjectTypeId(int objectTypeId) {
		this.objectTypeId = objectTypeId;
	}
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	@Override
	public String toString() {
		return "Relation [id=" + id + ", objectTypeId=" + objectTypeId + ", objectId=" + objectId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + objectId;
		result = prime * result + objectTypeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relation other = (Relation) obj;
		if (objectId != other.objectId)
			return false;
		if (objectTypeId != other.objectTypeId)
			return false;
		return true;
	}
	
	
	
	
}
