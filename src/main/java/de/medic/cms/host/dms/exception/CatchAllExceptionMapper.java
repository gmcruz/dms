package de.medic.cms.host.dms.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.medic.cms.host.dms.model.ErrorMessage;

//Allows Jersey to register this mapper as an exception
@Provider
public class CatchAllExceptionMapper implements ExceptionMapper<CatchAllException> {

	@Override
	public Response toResponse(CatchAllException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404);
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}