package ru.karachurin.docflow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.karachurin.docflow.model.Organization;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Integer> {
}
