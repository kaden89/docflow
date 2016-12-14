package ru.karachurin.docflow.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.service.DivisionService;
import ru.karachurin.docflow.service.EmployeeService;
import ru.karachurin.docflow.service.OrderService;
import ru.karachurin.docflow.service.OrganizationService;
import ru.karachurin.docflow.web.to.Children;
import ru.karachurin.docflow.web.to.Root;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 09.12.2016.
 */
@Path(value = "/v1/root")
public class RootController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    OrganizationService organizationService;

    @Inject
    DivisionService divisionService;

    @Inject
    EmployeeService employeeService;

    @Inject
    OrderService orderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoot(){
        Root root = new Root("Organizations", "", organizationService.getAll());
        return Response.ok(root).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizations(@PathParam("id") int id){
        Root root = new Root("organization", "");
        List<Children> children = new ArrayList<>();
        children.add(new Children("Divisions", ""+id+"/divisions", true));
        children.add(new Children("Employees", ""+id+"/employees", true));
        root.setChildren(children);
        return Response.ok(root).build();
    }

    @GET
    @Path("/{id}/divisions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDivisions(@PathParam("id") int organizationId, @Context HttpHeaders headers){
            log.info("get all divisions");
            List<Division> divisions = divisionService.findAllByOrganization(organizationId);
            Root root = new Root("divisions", "", divisions);
            return Response.ok(root).build();
    }

    @GET
    @Path("/{id}/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees(@PathParam("id") int organizationId, @Context HttpHeaders headers){
        List<String> rangeHeaders = headers.getRequestHeader("range");
        log.info("get all employees");
        List<Employee> employees = employeeService.findAllByOrganization(organizationId);
        Root root = new Root("employees", "", employees);
        return Response.ok(root).build();
    }

}
