package ru.karachurin.docflow.web;


import org.springframework.beans.factory.annotation.Autowired;
import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.service.DivisionService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by Денис on 01.12.2016.
 */

@Path("/hello")
public class HelloController {

    @Autowired
    DivisionService divisionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Division> hello(){
//        repository.save(new Organization());
//        repository.save(new Organization());
        return divisionService.findAllByOrganization(1);
    }


}
