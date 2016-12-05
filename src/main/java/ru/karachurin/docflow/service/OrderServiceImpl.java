package ru.karachurin.docflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.karachurin.docflow.model.Order;
import ru.karachurin.docflow.repository.OrderRepository;
import ru.karachurin.docflow.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Денис on 05.12.2016.
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order get(int id) throws NotFoundException {
        return orderRepository.findOne(id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        orderRepository.delete(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public List<Order> getGiven(int employeeId) {
        return orderRepository.findAllByAuthorId(employeeId);
    }

    @Override
    public List<Order> getToExecute(int employeeId) {
        return orderRepository.findAllByExecutorId(employeeId);
    }
}
