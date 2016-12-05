package ru.karachurin.docflow.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.model.Organization;
import ru.karachurin.docflow.service.DivisionService;
import ru.karachurin.docflow.service.EmployeeService;
import ru.karachurin.docflow.service.OrganizationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Денис on 03.12.2016.
 */
@Path(value = OrganizationRestController.REST_URL)
public class OrganizationRestController {

    static final String REST_URL = "/v1/organizations";

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    OrganizationService organizationService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Organization> getAllOrganizations(){
        return organizationService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Organization getOrganization(@PathParam("id") int organizationId){
        return organizationService.get(organizationId);
    }

    @GET
    @Path("/{id}/divisions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Division> getDivisions(@PathParam("id") int organizationId){
        return divisionService.findAllByOrganization(organizationId);
    }

    @GET
    @Path("/{id}/divisions/{divisionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Division getDivision(@PathParam("id") int organizationId, @PathParam("divisionId") int divisionId){
        return divisionService.get(divisionId);
    }
    @GET
    @Path("/{id}/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees(@PathParam("id") int organizationId){
        return employeeService.findAllByOrganization(organizationId);
    }

    @GET
    @Path("/{id}/employees/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("id") int organizationId,  @PathParam("employeeId") int employeeId){
        return employeeService.get(employeeId);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Organization createOrganization(Organization organization){
        return organizationService.save(organization);
    }


    @POST
    @Path("/{id}/divisions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Division createDivision(Division division, @PathParam("id") int organizationId){
        return divisionService.save(division, organizationId);
    }

    @POST
    @Path("/{id}/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee createEmployee(Employee employee, @PathParam("id") int organizationId){
        return employeeService.save(employee, organizationId);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Organization updateOrganization(Organization organization, @PathParam("id") int organizationId){
        return organizationService.update(organization, organizationId);
    }

    @PUT
    @Path("/{id}/divisions/{divisionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Division updateDivision(Division division, @PathParam("id") int organizationId, @PathParam("divisionId") int divisionId){
        return divisionService.update(division, organizationId, divisionId);
    }

    @PUT
    @Path("/{id}/employees/{employeeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(Employee employee, @PathParam("id") int organizationId, @PathParam("employeeId") int employeeId){
        return employeeService.update(employee, organizationId, employeeId);
    }

}
