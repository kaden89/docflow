package ru.karachurin.docflow.service;

import ru.karachurin.docflow.model.Organization;
import ru.karachurin.docflow.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrganizationService {
    Organization get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void deleteAll();

    Organization update(Organization organization);

    Organization save(Organization organization);

    List<Organization> getAll();
}
