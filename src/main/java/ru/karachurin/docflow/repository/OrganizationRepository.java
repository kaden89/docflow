package ru.karachurin.docflow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.karachurin.docflow.model.Organization;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
    @Query("SELECT DISTINCT o FROM Organization o LEFT JOIN FETCH o.divisions d WHERE d.parentDivision IS NULL ")
    public List<Organization> findAllHierarchy();
}
