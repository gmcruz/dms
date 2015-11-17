package de.mmi.medic.dms.host.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Article extends Document{

	private String htmlTitle;	
	private String friendlyUrl;
	private String description;
	private String keywords;
	private String redirectLink;
	private String uri;
	private String teaserText;
	private String teaserPicture;
	private String teaserTitle;		
	private String bodyText;
	private String headline;
	private String source;
	private String postOnForums;
	private String availableOn;
	private Date articleDate;	
	private Date availableDate;	
	private Date expirationDate;
	private Date creationDate;	
	private Date changeDate;
	private Date publishFrom;	
	private Date publishTo;	
	private int version;	
	private boolean searchable;		
	private List<Right> rights = new ArrayList<>();
	private List<Relation> relations = new ArrayList<>();
	private List<IGraphic> bodyPictures = new ArrayList<>();	//will be a concrete Picture
	private List<Author> authors = new ArrayList<>();	
	//articleType	ENUM
	//category	ENUM
	//
	
	public Article() {}
	
	public Article(int id, String name, String extension, String title) {
		super(id, name, extension, title);
	}

	
	public String getHtmlTitle() {
		return htmlTitle;
	}

	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}

	public String getFriendlyUrl() {
		return friendlyUrl;
	}

	public void setFriendlyUrl(String friendlyUrl) {
		this.friendlyUrl = friendlyUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getRedirectLink() {
		return redirectLink;
	}

	public void setRedirectLink(String redirectLink) {
		this.redirectLink = redirectLink;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTeaserText() {
		return teaserText;
	}

	public void setTeaserText(String teaserText) {
		this.teaserText = teaserText;
	}

	public String getTeaserPicture() {
		return teaserPicture;
	}

	public void setTeaserPicture(String teaserPicture) {
		this.teaserPicture = teaserPicture;
	}

	public String getTeaserTitle() {
		return teaserTitle;
	}

	public void setTeaserTitle(String teaserTitle) {
		this.teaserTitle = teaserTitle;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPostOnForums() {
		return postOnForums;
	}

	public void setPostOnForums(String postOnForums) {
		this.postOnForums = postOnForums;
	}

	public String getAvailableOn() {
		return availableOn;
	}

	public void setAvailableOn(String availableOn) {
		this.availableOn = availableOn;
	}

	public Date getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public Date getPublishFrom() {
		return publishFrom;
	}

	public void setPublishFrom(Date publishFrom) {
		this.publishFrom = publishFrom;
	}

	public Date getPublishTo() {
		return publishTo;
	}

	public void setPublishTo(Date publishTo) {
		this.publishTo = publishTo;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}	
	
	public List<IGraphic> getBodyPictures() {
		return bodyPictures;
	}

	public void setBodyPictures(List<IGraphic> bodyPictures) {
		this.bodyPictures = bodyPictures;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Article [htmlTitle=" + htmlTitle + ", friendlyUrl=" + friendlyUrl + ", description="
				+ description + ", keywords=" + keywords + ", redirectLink=" + redirectLink + ", uri=" + uri
				+ ", teaserText=" + teaserText + ", teaserPicture=" + teaserPicture + ", teaserTitle=" + teaserTitle
				+ ", bodyText=" + bodyText + ", headline=" + headline + ", source=" + source + ", postOnForums="
				+ postOnForums + ", availableOn=" + availableOn + ", articleDate=" + articleDate + ", availableDate="
				+ availableDate + ", expirationDate=" + expirationDate + ", creationDate=" + creationDate
				+ ", changeDate=" + changeDate + ", publishFrom=" + publishFrom + ", publishTo=" + publishTo
				+ ", version=" + version + ", searchable=" + searchable + ", rights=" + rights + ", relations="
				+ relations + ", bodyPictures=" + bodyPictures + ", authors=" + authors + "]";
	}

	
	
		
}
