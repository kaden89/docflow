package ru.karachurin.docflow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.model.Order;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
    @Query("SELECT DISTINCT o FROM Order o WHERE o.author.id=:authorId")
    public List<Order> findAllByAuthorId(@Param("authorId") int authorId);
    @Query("SELECT DISTINCT o FROM Order o WHERE o.executor.id=:executorId AND o.state!='PREPARE'")
    public List<Order> findAllByExecutorId(@Param("executorId") int executorId);
}
