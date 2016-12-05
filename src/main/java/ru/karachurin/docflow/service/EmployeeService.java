package ru.karachurin.docflow.service;

import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface EmployeeService {
    Employee get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Employee update(Employee employee, int organizationId, int employeeId);

    Employee save(Employee employee, int organizationId);

    List<Employee> findAllByOrganization(int organizationId);
}
