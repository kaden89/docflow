package ru.karachurin.docflow.service;

import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.web.Range;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface EmployeeService {
    Employee get(int id);

    void delete(int id);

    Employee update(Employee employee, int organizationId, int employeeId);

    Employee save(Employee employee, int organizationId);

    List<Employee> findAllByOrganization(int organizationId);

    List<Employee> findAllByOrganizationPageable(int organizationId, Range range);
}
