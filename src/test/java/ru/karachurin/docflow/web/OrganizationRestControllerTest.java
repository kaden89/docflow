package ru.karachurin.docflow.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.karachurin.docflow.model.Organization;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

/**
 * Created by Денис on 07.12.2016.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//@ActiveProfiles("production")
public class OrganizationRestControllerTest extends JerseyTest {

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    protected DeploymentContext configureDeployment(){
        return ServletDeploymentContext
                .forServlet(new ServletContainer(new ApplicationConfig()))
                .addListener(ContextLoaderListener.class)
                .contextParam("contextConfigLocation", "classpath:applicationContext.xml")
                .build();
    }


    @Override
    public Application configure() {
        return new ResourceConfig(OrganizationRestController.class);
    }
//    @Override
//    protected Application configure() {
//        return new ResourceConfig(OrganizationRestControllerTest.class);
//    }

    @Test
    public void testGetAllOrganizations() throws Exception {

    }

    @Test
    public void testGetOrganization() throws Exception {
        //Organization response = target("orders/453").request().get(Organization.class);
        //Assert.assertTrue("orderId: 453".equals(response));
    }

    @Test
    public void testGetDivisions() throws Exception {

    }

    @Test
    public void testGetDivision() throws Exception {

    }

    @Test
    public void testGetEmployees() throws Exception {

    }

    @Test
    public void testGetEmployee() throws Exception {

    }

    @Test
    public void testCreateOrganization() throws Exception {

    }

    @Test
    public void testCreateDivision() throws Exception {

    }

    @Test
    public void testCreateEmployee() throws Exception {

    }

    @Test
    public void testUpdateOrganization() throws Exception {

    }

    @Test
    public void testUpdateDivision() throws Exception {

    }

    @Test
    public void testUpdateEmployee() throws Exception {

    }

    @Test
    public void testDeleteOrganization() throws Exception {

    }

    @Test
    public void testDeleteDivision() throws Exception {

    }

    @Test
    public void testDeleteEmployee() throws Exception {

    }

}