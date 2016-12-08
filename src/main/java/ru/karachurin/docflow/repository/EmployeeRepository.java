package ru.karachurin.docflow.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.karachurin.docflow.model.Employee;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    public List<Employee> findAllByOrganizationId(int organizationId);

    public List<Employee> findAllByOrganizationId(int organizationId, Pageable pageable);
}
