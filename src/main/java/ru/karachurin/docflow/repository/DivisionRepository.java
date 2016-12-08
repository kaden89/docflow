package ru.karachurin.docflow.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.karachurin.docflow.model.Division;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
@Transactional
public interface DivisionRepository extends PagingAndSortingRepository<Division, Integer> {
    public List<Division> findAllByOrganizationId(int organizationId);
    public List<Division> findAllByOrganizationId(int organizationId, Pageable pageable);
}
