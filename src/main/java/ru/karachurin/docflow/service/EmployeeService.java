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

    void deleteAll();

    Employee update(Employee employee);

    Employee save(Employee employee);

    List<Employee> getAll();
}
