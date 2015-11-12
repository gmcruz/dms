package de.medic.cms.host.dms.model;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	
public class Right {
	
	@Id
	private int id;
	private int objectTypeId; //what type of object is being related.
	private int objectId;	//what is the id of the object being related.
	private int rightType;  //What kind of right does this object have 
		
	
	public Right() {}

	public Right(int id, int objectTypeId, int objectId, int rightType) {
		super();
		this.id = id;
		this.objectTypeId = objectTypeId;
		this.objectId = objectId;
		this.rightType = rightType;
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
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	@Override
	public String toString() {
		return "Right [id=" + id + ", objectTypeId=" + objectTypeId + ", objectId=" + objectId + ", rightType="	+ rightType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + objectId;
		result = prime * result + objectTypeId;
		result = prime * result + rightType;
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
		Right other = (Right) obj;
		if (objectId != other.objectId)
			return false;
		if (objectTypeId != other.objectTypeId)
			return false;
		if (rightType != other.rightType)
			return false;
		return true;
	}

	
	
}
