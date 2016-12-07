package ru.karachurin.docflow.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.karachurin.docflow.model.Organization;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

/**
 * Created by Денис on 07.12.2016.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//@ActiveProfiles("production")
public class OrganizationRestControllerTest extends JerseyTest{

    @Override
    protected Application configure() {
        return new ResourceConfig(OrganizationRestControllerTest.class);
    }

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