package ru.karachurin.docflow.service;

import ru.karachurin.docflow.model.Division;
import ru.karachurin.docflow.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface DivisionService {
    Division get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Division update(Division division, int organizationId, int divisionId);

    Division save(Division division, int organizationId);

    List<Division> getAll(int organizationId);

    public List<Division> findAllByOrganization(int organizationId);
}
