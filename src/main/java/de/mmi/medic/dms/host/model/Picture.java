package de.mmi.medic.dms.host.model;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Picture implements IGraphic {
	
	@Id
	private String id;
	private String title;
	private int size;
	private String link;

	public Picture() {}
		
	public Picture(String id, String title, int size, String link) {
		super();
		this.id = id;
		this.title = title;
		this.size = size;
		this.link = link;
	}

	@Override
	public URI getURI() {
		URI uri = null;
		try {
			uri = new URI(this.link);
		} catch (URISyntaxException e) {			
			e.printStackTrace();
		}
		return uri;
	}

	@Override
	public int getSizeInKB() {		
		return size;
	}

	@Override
	public String getTitle() {		
		return title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", title=" + title + ", size=" + size + ", link=" + link + "]";
	}
	
	
	

}
