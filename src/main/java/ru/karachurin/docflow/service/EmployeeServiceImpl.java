package ru.karachurin.docflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.repository.EmployeeRepository;
import ru.karachurin.docflow.repository.OrganizationRepository;
import ru.karachurin.docflow.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Денис on 05.12.2016.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public Employee get(int id) throws NotFoundException {
        return employeeRepository.findOne(id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        employeeRepository.delete(id);
    }

    @Override
    public Employee update(Employee employee, int organizationId, int employeeId) {
        employee.setId(employeeId);
        employee.setOrganization(organizationRepository.findOne(organizationId));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee save(Employee employee, int organizationId) {
        employee.setId(null);
        employee.setOrganization(organizationRepository.findOne(organizationId));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllByOrganization(int organizationId) {
        return employeeRepository.findAllByOrganizationId(organizationId);
    }
}
