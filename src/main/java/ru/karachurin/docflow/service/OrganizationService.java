package ru.karachurin.docflow.service;

import ru.karachurin.docflow.model.Organization;


import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrganizationService {
    Organization get(int id);

    void delete(int id) ;

    void deleteAll();

    Organization update(Organization organization, int organizationId);

    Organization save(Organization organization);

    List<Organization> getAll();
}
