package de.mmi.medic.dms.host.rest;

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

import de.mmi.medic.dms.host.exception.DataNotFoundException;
import de.mmi.medic.dms.host.model.ErrorMessage;
import de.mmi.medic.dms.host.model.LinkDocument;
import de.mmi.medic.dms.host.services.ILinkDocumentService;



@Path("linkdocuments")
public class DocumentResource {

	@EJB
	private ILinkDocumentService linkDocumentService;

	
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})    
    public List<LinkDocument> listLinkDocuments(@QueryParam("offset") final String offset,  @QueryParam("limit") final String limit) {
    	System.out.println(offset + " : " + limit);
    	return linkDocumentService.listLinkDocuments(); 
    }
	
	
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{id}")
    public LinkDocument getLinkDocument(@PathParam("id") int id) {
    	LinkDocument temp;
    	try{
    		temp = linkDocumentService.getLinkDocument(id);  
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
	public Response saveLinkDocument(@FormParam("title") String title,
								@FormParam("name") String name,
								@FormParam("extension") String extension,
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
		LinkDocument newLinkDocument = new LinkDocument(rand.nextInt(100000), name, extension, title);
		LinkDocument savedLinkDocument = linkDocumentService.saveLinkDocument(newLinkDocument);
		String newLinkId = String.valueOf(newLinkDocument.getId());
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(newLinkId).build();
		
		//We are sending the REST 201 "Created" STANDARD HTTP code.
		return Response.created(uri).entity(savedLinkDocument).build();
				
	}
	
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateDocument(@PathParam("id") int id, LinkDocument linkDocument) {
		
		//They send in a document but lets make sure we update the document id they send in.
		linkDocument.setId(id);
		
		linkDocumentService.updateLinkDocument(linkDocument);
		
		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteLinkDocument(@PathParam("id") int id) {
		linkDocumentService.deleteLinkDocument(id);
		return Response.accepted().build();
	}
	
	
	
	
	/*	
	public void addRelation(Relation relation);
	public void deleteRelation(Relation relation);
	public void setRights(Right right);*/
	
	
    
}
