package ru.karachurin.docflow.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.karachurin.docflow.model.Order;
import ru.karachurin.docflow.service.OrderService;
import ru.karachurin.docflow.util.Range;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;


/**
 * Created by Денис on 01.12.2016.
 */

@Path(value = OrdersRestController.REST_URL)
public class OrdersRestController {
    static final String REST_URL = "/v1/orders";

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    OrderService orderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(@Context HttpHeaders headers){
        List<String> rangeHeaders = headers.getRequestHeader("range");
        if (rangeHeaders==null) {
            log.info("get all orders");
            List<Order> orders = orderService.getAll();
            return Response.ok(orders).build();
        }
        else {
            Range range = new Range(rangeHeaders.get(0));
            log.info("get all orders pageable"+" limit: "+range.getLimit()+" offset: "+range.getOffset());
            List<Order> orders = orderService.getAllPageable(range);
            return Response.ok(orders).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder(@PathParam("id") int orderId){
        log.info("get order with id "+orderId);
        Order order = orderService.get(orderId);
        return Response.ok(order).build();
    }

    @GET
    @Path("/to-execute")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrdersToExecute(@QueryParam("employee-id") int employeeId){
        log.info("get all orders to execute for user with id "+employeeId);
        List<Order> orders = orderService.getToExecute(employeeId);
        return Response.ok(orders).build();
    }

    @GET
    @Path("/given")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGivenOrders(@QueryParam("employee-id") int employeeId){
        log.info("get all given orders from user with id "+employeeId);
        List<Order> orders =  orderService.getGiven(employeeId);
        return Response.ok(orders).build();
    }

    @POST
    @Path("/{id}/next-step")
    @Produces(MediaType.APPLICATION_JSON)
    public Response nextStep(@PathParam("id") int orderId){
        log.info("next step for order with id "+orderId);
        Order order = orderService.nextStep(orderId);
        return Response.ok(order).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(Order order, @Context UriInfo uriInfo){
        log.info("create order "+order);
        Order created = orderService.save(order);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(created.getId()));
        return Response.created(builder.build()).entity(order).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrganization(Order order, @PathParam("id") int orderId){
        log.info("update order "+order+" with id "+orderId);
        Order updated =  orderService.update(order, orderId);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrganization(@PathParam("id") int orderId){
        log.info("delete order with id "+orderId);
        orderService.delete(orderId);
        return Response.ok().build();
    }


}
