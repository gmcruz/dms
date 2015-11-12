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
import de.medic.cms.host.dms.model.Article;
import de.medic.cms.host.dms.model.ErrorMessage;
import de.medic.cms.host.dms.services.IArticleService;



	@Path("articles")
	public class ArticleResource {

		@EJB
		private IArticleService articleService;

		
	    @GET
	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})    
	    public List<Article> listArticles(@QueryParam("offset") final String offset,  @QueryParam("limit") final String limit) {
	    	System.out.println(offset + " : " + limit);
	    	return articleService.listArticles(); 
	    }
		
		
	    @GET
	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    @Path("/{id}")
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
		public Response saveArticle(@FormParam("title") String title,	
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
			Article newArticle = new Article(101112, "Article Four", "http://localhost:8080/dms/rest/articles/101112");
			Article savedArticle = articleService.saveArticle(newArticle);
			String newId = String.valueOf(newArticle.getId());
			
			URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
			
			//We are sending the REST 201 "Created" STANDARD HTTP code.
			return Response.created(uri).entity(savedArticle).build();
					
		}
		
		@PUT
		@Path("/{id}")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Response updateArticle(@PathParam("id") int id, Article article) {
			
			//They send in a article but lets make sure we update the article id they send in.
			article.setId(id);
			
			articleService.updateArticle(article);
			
			return Response.ok().build();
			
		}
		
		@DELETE
		@Path("/{id}")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Response deleteArticle(@PathParam("id") int id) {
			articleService.deleteArticle(id);
			return Response.accepted().build();
		}
		
		
		
		
		/*	
		public void addRelation(Relation relation);
		public void deleteRelation(Relation relation);
		public void setRights(Right right);*/
		
		
	    
	}

