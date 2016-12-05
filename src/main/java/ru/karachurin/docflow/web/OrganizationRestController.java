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

import javax.inject.Inject;
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

    @Inject
    OrganizationService organizationService;

    @Inject
    DivisionService divisionService;

    @Inject
    EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Organization> getAllOrganizations(){
        log.info("get all organizations");
        return organizationService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Organization getOrganization(@PathParam("id") int organizationId){
        log.info("get organization with id "+ organizationId);
        return organizationService.get(organizationId);
    }

    @GET
    @Path("/{id}/divisions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Division> getDivisions(@PathParam("id") int organizationId){
        log.info("get all divisions");
        return divisionService.findAllByOrganization(organizationId);
    }

    @GET
    @Path("/{id}/divisions/{divisionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Division getDivision(@PathParam("id") int organizationId, @PathParam("divisionId") int divisionId){
        log.info("get division with id "+divisionId);
        return divisionService.get(divisionId);
    }
    @GET
    @Path("/{id}/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees(@PathParam("id") int organizationId){
        log.info("get all employees");
        return employeeService.findAllByOrganization(organizationId);
    }

    @GET
    @Path("/{id}/employees/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("id") int organizationId,  @PathParam("employeeId") int employeeId){
        log.info("get employee with id "+employeeId);
        return employeeService.get(employeeId);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Organization createOrganization(Organization organization){
        log.info("create organization "+organization);
        return organizationService.save(organization);
    }


    @POST
    @Path("/{id}/divisions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Division createDivision(Division division, @PathParam("id") int organizationId){
        log.info("create division "+division);
        return divisionService.save(division, organizationId);
    }

    @POST
    @Path("/{id}/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee createEmployee(Employee employee, @PathParam("id") int organizationId){
        log.info("create employee "+employee);
        return employeeService.save(employee, organizationId);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Organization updateOrganization(Organization organization, @PathParam("id") int organizationId){
        log.info("update organization "+organization+" with id "+organizationId);
        return organizationService.update(organization, organizationId);
    }

    @PUT
    @Path("/{id}/divisions/{divisionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Division updateDivision(Division division, @PathParam("id") int organizationId, @PathParam("divisionId") int divisionId){
        log.info("update division "+division+" with id "+divisionId);
        return divisionService.update(division, organizationId, divisionId);
    }

    @PUT
    @Path("/{id}/employees/{employeeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(Employee employee, @PathParam("id") int organizationId, @PathParam("employeeId") int employeeId){
        log.info("update employee "+employee+" with id "+employeeId);
        return employeeService.update(employee, organizationId, employeeId);
    }

}
