package ru.karachurin.docflow.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.model.Order;
import ru.karachurin.docflow.service.DivisionService;
import ru.karachurin.docflow.service.OrderService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
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
    public List<Order> getAllOrders(){
        return orderService.getAll();
    }

    @GET
    @Path("/toExecute")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrdersToExecute(@QueryParam("employeeId") int employeeId){
        return orderService.getToExecute(employeeId);
    }

    @GET
    @Path("/given")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllGivenOrders(@QueryParam("employeeId") int employeeId){
        return orderService.getGiven(employeeId);
    }

}
