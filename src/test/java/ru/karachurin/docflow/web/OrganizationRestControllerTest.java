package ru.karachurin.docflow.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;
import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.model.Organization;
import ru.karachurin.docflow.service.OrganizationService;
import ru.karachurin.docflow.util.json.JsonUtil;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static ru.karachurin.docflow.testdata.DivisionTestData.DIVISION1;
import static ru.karachurin.docflow.testdata.EmployeeTestData.EMPLOYEE1;
import static ru.karachurin.docflow.testdata.OrganizationTestData.ORGANIZATION1;
import static ru.karachurin.docflow.testdata.OrganizationTestData.ORGANIZATIONS;
import static ru.karachurin.docflow.testdata.OrganizationTestData.getCreated;

/**
 * Created by Денис on 07.12.2016.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//@ActiveProfiles("production")
public class OrganizationRestControllerTest extends JerseyTest {

    static final String REST_URL = OrganizationRestController.REST_URL+"/";

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
                .contextParam("spring.profiles.default", "production")
                .build();
    }


    @Override
    public Application configure() {
        return new ResourceConfig(OrganizationRestController.class);
    }

    @Test
    public void testGetAllOrganizations() throws Exception {
        GenericType<List<Organization>> generic = new GenericType<>(new ArrayList<Organization>().getClass().getGenericSuperclass());
        List<Organization> response = target(REST_URL).request().get(generic);
        Assert.assertEquals(response, ORGANIZATIONS);
    }

    @Test
    public void testGetOrganization() throws Exception {
        Organization response = target(REST_URL+"100001").request().get(Organization.class);
        Assert.assertEquals(response, ORGANIZATION1);
    }

    @Test
    public void testGetDivisions() throws Exception {

    }

    @Test
    public void testGetDivision() throws Exception {
        Division response = target(REST_URL+"100001/divisions/100003").request().get(Division.class);
        Assert.assertEquals(response, DIVISION1);
    }

    @Test
    public void testGetEmployees() throws Exception {

    }

    @Test
    public void testGetEmployee() throws Exception {
        Employee response = target(REST_URL+"100001/employees/100007").request().get(Employee.class);
        Assert.assertEquals(response, EMPLOYEE1);
    }

    @Test
    public void testCreateOrganization() throws Exception {
        Organization created = getCreated();
        Entity<Organization> entity = Entity.entity(ORGANIZATION1, MediaType.APPLICATION_JSON);
        Organization response = target(REST_URL).request().post(entity, Organization.class);
        response.setId(null);
        Assert.assertEquals(response, created);

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