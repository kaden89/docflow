package ru.karachurin.docflow.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.model.Organization;
import ru.karachurin.docflow.service.DivisionService;
import ru.karachurin.docflow.service.EmployeeService;
import ru.karachurin.docflow.service.OrganizationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

/**
 * Created by Денис on 03.12.2016.
 */
@Path(value = OrganizationRestController.REST_URL)
public class OrganizationRestController {

    static final String REST_URL = "/v1/organizations";

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    OrganizationService organizationService;

    @Inject
    DivisionService divisionService;

    @Inject
    EmployeeService employeeService;

    @GET
    @Path("ss")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrganizations(@Context HttpHeaders headers){
        List<String> rangeHeaders = headers.getRequestHeader("range");
        if (rangeHeaders==null) {
            log.info("get all organizations");
            List<Organization> organizations = organizationService.getAll();
            return Response.ok(organizations).build();
        }
        else {
            Range range = new Range(rangeHeaders.get(0));
            log.info("get all organizations pageable"+" limit: "+range.getLimit()+" offset: "+range.getOffset());
            List<Organization> organizations = organizationService.getAllPageable(range);
            return Response.ok(organizations).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganization(@PathParam("id") int organizationId){
        log.info("get organization with id "+ organizationId);
        Organization organization = organizationService.get(organizationId);
        if (organization != null) {
            return Response.ok(organization).build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
            //return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + organizationId).build();
        }
    }

    @GET
    @Path("/{id}/divisions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDivisions(@PathParam("id") int organizationId, @Context HttpHeaders headers){
        List<String> rangeHeaders = headers.getRequestHeader("range");
        if (rangeHeaders==null) {
            log.info("get all divisions");
            List<Division> divisions = divisionService.findAllByOrganization(organizationId);
            return Response.ok(divisions).build();
        }
        else {
            Range range = new Range(rangeHeaders.get(0));
            log.info("get all divisions pageable"+" limit: "+range.getLimit()+" offset: "+range.getOffset());
            List<Division> divisions = divisionService.findAllByOrganizationPageable(organizationId, range);
            return Response.ok(divisions).build();
        }
    }

    @GET
    @Path("/{id}/divisions/{divisionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDivision(@PathParam("id") int organizationId, @PathParam("divisionId") int divisionId){
        log.info("get division with id "+divisionId);
        Division division = divisionService.get(divisionId);

        if (division != null) {
            return Response.ok(division).build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    @GET
    @Path("/{id}/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees(@PathParam("id") int organizationId, @Context HttpHeaders headers){
        List<String> rangeHeaders = headers.getRequestHeader("range");
        if (rangeHeaders==null){
            log.info("get all employees");
            List<Employee> employees = employeeService.findAllByOrganization(organizationId);
            return Response.ok(employees).build();
        }
        else {
            Range range = new Range(rangeHeaders.get(0));
            log.info("get employees pageable"+" limit: "+range.getLimit()+" offset: "+range.getOffset());
            List<Employee> employees = employeeService.findAllByOrganizationPageable(organizationId, range);
            return Response.ok(employees).build();
        }
    }

    @GET
    @Path("/{id}/employees/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") int organizationId,  @PathParam("employeeId") int employeeId){
        log.info("get employee with id "+employeeId);
        Employee employee =  employeeService.get(employeeId);

        if (employee != null) {
            return Response.ok(employee).build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrganization(Organization organization, @Context UriInfo uriInfo){
        log.info("create organization "+organization);
        Organization created = organizationService.save(organization);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(created.getId()));
        return Response.created(builder.build()).entity(organization).build();
    }


    @POST
    @Path("/{id}/divisions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDivision(Division division, @PathParam("id") int organizationId, @Context UriInfo uriInfo){
        log.info("create division "+division);
        Division created =  divisionService.save(division, organizationId);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(created.getId()));
        return Response.created(builder.build()).entity(created).build();
    }

    @POST
    @Path("/{id}/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee, @PathParam("id") int organizationId, @Context UriInfo uriInfo){
        log.info("create employee "+employee);
        Employee created = employeeService.save(employee, organizationId);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(created.getId()));
        return Response.created(builder.build()).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrganization(Organization organization, @PathParam("id") int organizationId){
        log.info("update organization "+organization+" with id "+organizationId);
        Organization updated =  organizationService.update(organization, organizationId);
        return Response.ok(updated).build();
    }

    @PUT
    @Path("/{id}/divisions/{divisionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDivision(Division division, @PathParam("id") int organizationId, @PathParam("divisionId") int divisionId){
        log.info("update division "+division+" with id "+divisionId);
        Division updated = divisionService.update(division, organizationId, divisionId);
        return Response.ok(updated).build();
    }

    @PUT
    @Path("/{id}/employees/{employeeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(Employee employee, @PathParam("id") int organizationId, @PathParam("employeeId") int employeeId){
        log.info("update employee "+employee+" with id "+employeeId);
        Employee  updated = employeeService.update(employee, organizationId, employeeId);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrganization(@PathParam("id") int organizationId){
        log.info("delete organization with id "+organizationId);
        organizationService.delete(organizationId);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}/divisions/{divisionId}")
    public Response deleteDivision(@PathParam("divisionId") int divisionId){
        log.info("delete division with id "+divisionId);
        divisionService.delete(divisionId);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}/employees/{employeeId}")
    public Response deleteEmployee(@PathParam("employeeId") int employeeId) {
        log.info("delete employee with id " + employeeId);
        employeeService.delete(employeeId);
        return Response.ok().build();
    }

}
