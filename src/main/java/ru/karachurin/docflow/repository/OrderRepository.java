package ru.karachurin.docflow.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.karachurin.docflow.model.Order;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
}
