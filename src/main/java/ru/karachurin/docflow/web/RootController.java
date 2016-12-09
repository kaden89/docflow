package ru.karachurin.docflow.web;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Денис on 09.12.2016.
 */
@Path(value = "/v1")
public class RootController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoot(){
        return Response.ok(new Root()).build();
    }
}
