package ru.karachurin.docflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karachurin.docflow.model.Order;
import ru.karachurin.docflow.model.State;
import ru.karachurin.docflow.repository.OrderRepository;
import ru.karachurin.docflow.util.Range;

import java.util.List;

/**
 * Created by Денис on 05.12.2016.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order get(int id) {
        return orderRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        orderRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @Override
    public Order update(Order order, int orderId) {
        order.setId(orderId);
        return orderRepository.save(order);
    }

    @Override
    public Order save(Order order) {
        order.setId(null);
        order.setState(State.PREPARE);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public List<Order> getAllPageable(Range range) {
        return (List<Order>) orderRepository.findAll(new ChunkRequest(range.getLimit(), range.getOffset()));
    }

    @Override
    public List<Order> getGiven(int employeeId) {
        return orderRepository.findAllByAuthorId(employeeId);
    }

    @Override
    public List<Order> getToExecute(int employeeId) {
        return orderRepository.findAllByExecutorId(employeeId);
    }

    @Override
    public Order nextStep(int orderId) {
        Order order = get(orderId);
        order.nextStep();
        return orderRepository.save(order);
    }
}
