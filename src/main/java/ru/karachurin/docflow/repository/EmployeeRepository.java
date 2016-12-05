package ru.karachurin.docflow.repository;

import org.springframework.data.repository.CrudRepository;
import ru.karachurin.docflow.model.Employee;

/**
 * Created by Денис on 02.12.2016.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
