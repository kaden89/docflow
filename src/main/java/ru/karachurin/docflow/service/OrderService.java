package ru.karachurin.docflow.service;

import ru.karachurin.docflow.model.Order;
import ru.karachurin.docflow.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrderService {
    Order get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void deleteAll();

    Order update(Order order);

    Order save(Order order);

    List<Order> getAll();
}
