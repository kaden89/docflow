package ru.karachurin.docflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.repository.DivisionRepository;
import ru.karachurin.docflow.repository.OrganizationRepository;
import ru.karachurin.docflow.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
@Service
@Transactional
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Autowired
    OrganizationRepository organizationRepository;
    @Override
    public Division get(int id) throws NotFoundException {
        return divisionRepository.findOne(id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        divisionRepository.delete(id);
    }

    @Override
    public Division update(Division division, int organizationId, int divisionId) {
        division.setId(divisionId);
        division.setOrganization(organizationRepository.findOne(organizationId));
        return divisionRepository.save(division);
    }

    @Override
    public Division save(Division division, int organizationId) {
        division.setId(null);
        division.setOrganization(organizationRepository.findOne(organizationId));
        return divisionRepository.save(division);
    }

    @Override
    public List<Division> getAll(int organizationId) {
        return (List<Division>) divisionRepository.findAll();
    }

    @Override
    public List<Division> findAllByOrganization(int organizationId) {
        return divisionRepository.findAllByOrganizationId(organizationId);
    }
}
