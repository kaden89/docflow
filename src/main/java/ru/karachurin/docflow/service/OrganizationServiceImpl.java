package ru.karachurin.docflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karachurin.docflow.model.Organization;
import ru.karachurin.docflow.repository.OrganizationRepository;
import ru.karachurin.docflow.web.Range;

import java.util.List;

/**
 * Created by Денис on 03.12.2016.
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public Organization get(int id)  {
        return organizationRepository.findOne(id);
    }

    @Override
    public void delete(int id)  {
        organizationRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        organizationRepository.deleteAll();
    }

    @Override
    public Organization update(Organization organization, int organizationId) {
        organization.setId(organizationId);
        return organizationRepository.save(organization);
    }

    @Override
    public Organization save(Organization organization) {
        organization.setId(null);
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> getAll() {
        return (List<Organization>) organizationRepository.findAll();
    }

    @Override
    public List<Organization> getAllPageable(Range range) {
        return (List<Organization>) organizationRepository.findAll(new ChunkRequest(range.getLimit(), range.getOffset()));
    }
}
