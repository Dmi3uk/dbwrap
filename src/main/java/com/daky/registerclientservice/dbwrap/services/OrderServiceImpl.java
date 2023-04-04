package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.converters.OrderConverterImpl;
import com.daky.registerclientservice.dbwrap.dto.OrderData;
import com.daky.registerclientservice.dbwrap.entries.Order;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.OrderKey;
import com.daky.registerclientservice.dbwrap.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl implements AbstractRegisterService<OrderData, OrderData, OrderKey> {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderConverterImpl orderConverter;

    @Override
    public OrderData create(OrderData orderData) {
        Order order = orderConverter.populateEntity(orderData);
        return orderConverter.populateData(orderRepository.save(order));
    }

    @Override
    public List<OrderData> getAll() {
        List<OrderData> orders = new ArrayList<>();
        List<Order> orderList = orderRepository.findAll();
        orderList.forEach(order -> {
            orders.add(orderConverter.populateData(order));
        });
        return orders;
    }

    @Override
    public Optional<OrderData> getById(OrderKey id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) {
            return null;
        }
        return Optional.of(orderConverter.populateData(order.get()));
    }

    @Override
    public boolean update(OrderData orderData, OrderKey id) {
        if (orderRepository.existsById(id)) {
            Order order = orderConverter.populateEntity(orderData);
            order.setId(id);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(OrderKey id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
