package ru.karachurin.docflow.service;

import ru.karachurin.docflow.model.Order;
import ru.karachurin.docflow.web.to.Range;

import java.util.List;

/**
 * Created by Денис on 02.12.2016.
 */
public interface OrderService {
    Order get(int id);

    void delete(int id) ;

    void deleteAll();

    Order update(Order order, int orderId);

    Order save(Order order);

    List<Order> getAll();

    List<Order> getAllPageable(Range range);

    List<Order> getGiven(int employeeId);

    List<Order> getToExecute(int employeeId);

    Order nextStep(int orderId);
}
