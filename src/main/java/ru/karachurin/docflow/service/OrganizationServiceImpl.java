package ru.karachurin.docflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karachurin.docflow.model.Organization;
import ru.karachurin.docflow.repository.OrganizationRepository;
import ru.karachurin.docflow.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Денис on 03.12.2016.
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository repository;

    @Override
    public Organization get(int id) throws NotFoundException {
        return repository.findOne(id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Organization update(Organization organization, int organizationId) {
        organization.setId(organizationId);
        return repository.save(organization);
    }

    @Override
    public Organization save(Organization organization) {
        organization.setId(null);
        return repository.save(organization);
    }

    @Override
    public List<Organization> getAll() {
        return (List<Organization>) repository.findAll();
    }
}
