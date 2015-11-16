package de.medic.dms.host.model;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import de.medic.dms.host.util.GenerateDocumentSignature;

@XmlRootElement
public abstract class Document implements IDocument{
	
	@Id
	@NotNull
	private int id;	
	
	@NotNull
	private String uniqueName;
	
	@NotNull
	private String directoryPath;
	
	@NotNull
	private String name;	
	
	@NotNull
	@Size(min=3, max=10)
	private String extension;
	
	private String title;
	private Date created;
			
	public Document() {};
	
	public Document(int id, String name, String extension, String title) {
		this.id = id;
		this.name = name;
		this.extension = extension;
		this.title = title;	
		this.created = new Date();	
		generateUniqueName();
		generateDirectoryPath();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public void generateUniqueName() {
		GenerateDocumentSignature.generateDocumentUniqueName(this);		
	}

	@Override
	public void generateDirectoryPath() {
		GenerateDocumentSignature.generateDocumentPath(this);			
	}
	
	
	
}
