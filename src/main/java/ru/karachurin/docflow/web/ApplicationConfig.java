package ru.karachurin.docflow.web;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

import java.util.Set;

/**
 * Created by Денис on 02.12.2016.
 */

public class ApplicationConfig extends ResourceConfig {

   public ApplicationConfig(){
       register(OrdersRestController.class);
       register(OrganizationRestController.class);
       register(RequestContextFilter.class);
       register(RootController.class);
       // register features
       register(JacksonFeature.class);
   }

    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        resources.add(OrdersRestController.class);
        return resources;
    }
}
