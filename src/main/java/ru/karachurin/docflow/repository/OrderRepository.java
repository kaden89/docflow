package ru.karachurin.docflow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.karachurin.docflow.model.Employee;
import ru.karachurin.docflow.model.Order;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
    @Query("SELECT DISTINCT o FROM Order o WHERE o.author.id=:authorId")
    public List<Order> findAllByAuthorId(int authorId);
    @Query("SELECT DISTINCT o FROM Order o WHERE o.executor.id=:executorId")
    public List<Order> findAllByExecutorId(int executorId);
}
