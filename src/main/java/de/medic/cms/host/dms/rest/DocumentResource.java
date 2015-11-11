package de.medic.cms.host.dms.rest;

import java.net.URI;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import de.medic.cms.host.dms.exception.DataNotFoundException;
import de.medic.cms.host.dms.model.Document;
import de.medic.cms.host.dms.model.ErrorMessage;
import de.medic.cms.host.dms.services.IDocumentService;



@Path("documents")
public class DocumentResource {

	@EJB
	private IDocumentService documentService;

	
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})    
    public List<Document> listDocuments(@QueryParam("offset") final String offset,  @QueryParam("limit") final String limit) {
    	System.out.println(offset + " : " + limit);
    	return documentService.listDocuments(); 
    }
	
	
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{id}")
    public Document getDocument(@PathParam("id") int id) {
    	Document temp;
    	try{
    		temp = documentService.getDocument(id);  
    	}catch(DataNotFoundException dnfe){
    		
    		ErrorMessage errorMessage = new ErrorMessage(dnfe.getMessage(), 404);
    		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    		throw new NotFoundException(response);
    	}
        return temp;
    }
    
	@POST	
	@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response saveDocument(@FormParam("title") String title,	
								@FormParam("products") String products,
								@FormParam("ingredients") String ingredients,
								@FormParam("companies") String companies,
								@FormParam("articledate") String articledate,
								@FormParam("description") String description,
								@FormParam("originalfile") String originalfile,
								@FormParam("sources") String sources,
								@FormParam("friendlyurl") String friendlyurl,
								@FormParam("htmltitel") String htmltitel,
								@FormParam("keywords") String keywords,
								@FormParam("rights") String rights,
								@Context UriInfo uriInfo
							) {
		
		Random rand = new Random();
		Document newDocument = new Document(rand.nextInt(100000), title);
		Document savedDocument = documentService.saveDocument(newDocument);
		String newId = String.valueOf(newDocument.getId());
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		
		//We are sending the REST 201 "Created" STANDARD HTTP code.
		return Response.created(uri).entity(savedDocument).build();
				
	}
	
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateDocument(@PathParam("id") int id, Document document) {
		
		//They send in a document but lets make sure we update the document id they send in.
		document.setId(id);
		
		documentService.updateDocument(document);
		
		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteDocument(@PathParam("id") int id) {
		documentService.deleteDocument(id);
		return Response.accepted().build();
	}
	
	
	
	
	/*	
	public void addRelation(Relation relation);
	public void deleteRelation(Relation relation);
	public void setRights(Right right);*/
	
	
    
}
