package ru.karachurin.docflow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.karachurin.docflow.model.Division;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
@Transactional
public interface DivisionRepository extends CrudRepository<Division, Integer> {
    @Query("SELECT DISTINCT d FROM Division d WHERE d.parentDivision IS NULL AND d.organization.id =:organizationId")
    public List<Division> findAllHierarchy(@Param("organizationId") int organizationId);
}
