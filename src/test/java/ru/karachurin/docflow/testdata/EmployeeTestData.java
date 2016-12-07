package ru.karachurin.docflow.testdata;

import ru.karachurin.docflow.model.Employee;

import java.util.Arrays;
import java.util.List;

import static ru.karachurin.docflow.model.BaseEntity.START_SEQ;
import static ru.karachurin.docflow.testdata.DivisionTestData.DIVISION1;
import static ru.karachurin.docflow.testdata.DivisionTestData.DIVISION3;
import static ru.karachurin.docflow.testdata.OrganizationTestData.ORGANIZATION1;

/**
 * Created by Денис on 03.12.2016.
 */
public class EmployeeTestData {

    public static final int EMPLOYEE1_ID = START_SEQ + 7;
    public static final Employee EMPLOYEE1 =
            new Employee(EMPLOYEE1_ID, "Vasya", "Vasilev", "Vasilevich", "seller", ORGANIZATION1);
    public static final Employee EMPLOYEE2 =
            new Employee(EMPLOYEE1_ID, "Petya", "Petrov", "Petrovich", "accountant", ORGANIZATION1);
    public static final Employee EMPLOYEE3 =
            new Employee(EMPLOYEE1_ID, "Ivan", "Ivanov", "Ivanovich", "programmer", ORGANIZATION1);
    public static final Employee EMPLOYEE4 =
            new Employee(EMPLOYEE1_ID, "Petr", "Petrov", "Petrovich", "tester", ORGANIZATION1);

    public static final List<Employee> EMPLOYEES = Arrays.asList(EMPLOYEE1, EMPLOYEE2, EMPLOYEE3, EMPLOYEE4);

    public static Employee getCreated(){
        return  new Employee(null, "new", "Vasilev", "Vasilevish", "tester", ORGANIZATION1);
    }

    public static Employee getUpdated(){
        return  new Employee(EMPLOYEE1_ID, "Vasya", "Vasilev", "Vasilevish", "manager", ORGANIZATION1);
    }
}
