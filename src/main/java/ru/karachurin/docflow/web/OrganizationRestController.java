package ru.karachurin.docflow.web;

import org.springframework.beans.factory.annotation.Autowired;
import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.model.Organization;
import ru.karachurin.docflow.service.DivisionService;
import ru.karachurin.docflow.service.OrganizationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Денис on 03.12.2016.
 */
@Path("/organizations")
public class OrganizationRestController {

    @Autowired
    OrganizationService organizationService;

    @Autowired
    DivisionService divisionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Organization> getAllOrganizations(){
        return organizationService.getAll();
    }

    @GET
    @Path("/{id}/divisions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Division> getDivisions(@PathParam("id") int organizationId){
        return divisionService.getAllHierarchy(organizationId);
    }

    @POST
    @Path("/{id}/divisions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Division createDivision(Division division, @PathParam("id") int organizationId){
        return divisionService.save(division, organizationId);
    }

    @PUT
    @Path("/{id}/divisions/{divisionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Division updateDivision(Division division, @PathParam("id") int organizationId){
        return divisionService.update(division, organizationId);
    }

}
