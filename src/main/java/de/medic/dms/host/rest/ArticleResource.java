package de.medic.dms.host.rest;


import java.net.URI;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
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

import de.medic.dms.host.exception.DataNotFoundException;
import de.medic.dms.host.model.Article;
import de.medic.dms.host.model.ErrorMessage;
import de.medic.dms.host.model.Relation;
import de.medic.dms.host.services.IArticleService;



	@Path("articles")
	public class ArticleResource {

		@EJB
		private IArticleService articleService;

		
	    @GET
	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})    
	    public List<Article> listArticles(@DefaultValue(value="0") @QueryParam("offset") final String offset,  @DefaultValue(value="15") @QueryParam("limit") final String limit) {
	    	System.out.println(offset + " : " + limit);
	    	return articleService.listArticles(); 
	    }
		
		
	    @GET
	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    @Path("/{id:[0-9]*}")
	    public Article getArticle(@PathParam("id") int id) {
	    	Article temp;
	    	try{
	    		temp = articleService.getArticle(id);  
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
		public Response saveArticle(@NotNull @FormParam("title") String title,	
									@NotNull @FormParam("name") String name,
									@NotNull @FormParam("extension") String extension,
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
			
			//TODO who will create the ID???????
			Random rand = new Random();
			Article newArticle = new Article(rand.nextInt(100000), name, extension, "Article Four");
			
			Article savedArticle = articleService.saveArticle(newArticle);
			String newId = String.valueOf(newArticle.getId());
			
			URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
			
			//We are sending the REST 201 "Created" STANDARD HTTP code.
			return Response.created(uri).entity(savedArticle).build();
					
		}
		
		@PUT
		@Path("/{id:[0-9]*}")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Response updateArticle(@PathParam("id") int id, Article article) {
			
			//They send in a article but lets make sure we update the article id they sent in.
			article.setId(id);
			
			articleService.updateArticle(article);
			
			return Response.ok().build();
			
		}
		
		
		@PUT
		@Path("/{id:[0-9]*}/relations")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		@Consumes("application/x-www-form-urlencoded")
		public Response addArticleRelation(@PathParam("id") int id, 
				                           @FormParam("objecttypeid") int objectTypeId, 
				                           @FormParam("objectid") int objectId) {
			
			//Create a new relation object to attach to object
			Relation newRelation = new Relation();
			newRelation.setObjectTypeId(objectTypeId);//TODO WHERE DO WE GET THIS??
			newRelation.setObjectId(objectId);
			
			//Add the relation to the object
			Article workingArticle = articleService.getArticle(id);
			workingArticle.getRelations().add(newRelation);
			
			articleService.updateArticle(workingArticle);
			
			return Response.ok().build();
			
		}
		
		
		@DELETE
		@Path("/{id:[0-9]*}")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Response deleteArticle(@PathParam("id") int id) {
			articleService.deleteArticle(id);
			return Response.accepted().build();
		}
		
		
		@DELETE
		@Path("/{id:[0-9]*}/relations/{objecttypeid:[0-9]*}/{objectid:[0-9]*}")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		@Consumes("application/x-www-form-urlencoded")
		public Response deleteArticleRelation(@PathParam("id") int id, 
											  @PathParam("objecttypeid") int objectTypeId, 
							                  @PathParam("objectid") int objectId) {
			
			//Create a new relation object to attach to object
			Relation delRelation = new Relation();
			delRelation.setObjectTypeId(objectTypeId);//TODO WHERE DO WE GET THIS??
			delRelation.setObjectId(objectId);
			
			//Delete the relation from the object
			Article workingArticle = articleService.getArticle(id);			
			articleService.deleteRelation(workingArticle, delRelation);
									
			return Response.ok().build();
			
		}		
		
		/*				
		public void setRights(Right right);*/
		
		
	    
	}

