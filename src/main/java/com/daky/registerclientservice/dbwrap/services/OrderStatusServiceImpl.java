package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.converters.OrdersStatusConverterImpl;
import com.daky.registerclientservice.dbwrap.dto.OrdersStatusData;
import com.daky.registerclientservice.dbwrap.entries.OrderStatus;
import com.daky.registerclientservice.dbwrap.repositories.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("orderStatusService")
public class OrderStatusServiceImpl implements AbstractRegisterService<OrdersStatusData, OrdersStatusData, Long> {

    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private OrdersStatusConverterImpl ordersStatusConverter;

    @Override
    public OrdersStatusData create(OrdersStatusData ordersStatusData) {
        OrderStatus orderStatus = ordersStatusConverter.populateEntity(ordersStatusData);
        return ordersStatusConverter.populateData(orderStatusRepository.save(orderStatus));
    }

    @Override
    public List<OrdersStatusData> getAll() {
        List<OrdersStatusData> ordersStatuses = new ArrayList<>();
        List<OrderStatus> orderStatusList = orderStatusRepository.findAll();
        orderStatusList.forEach(orderStatus -> {
            ordersStatuses.add(ordersStatusConverter.populateData(orderStatus));
        });
        return ordersStatuses;
    }

    @Override
    public Optional<OrdersStatusData> getById(Long orderStatusId) {
        Optional<OrderStatus> orderStatus = orderStatusRepository.findById(orderStatusId);
        if(orderStatus.isEmpty()) {
            return null;
        }
        return Optional.of(ordersStatusConverter.populateData(orderStatus.get()));
    }

    @Override
    public boolean update(OrdersStatusData ordersStatusData, Long orderStatusId) {
        if (orderStatusRepository.existsById(orderStatusId)) {
            OrderStatus orderStatus = ordersStatusConverter.populateEntity(ordersStatusData);
            orderStatus.setId(orderStatusId);
            orderStatusRepository.save(orderStatus);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long orderStatusId) {
        if (orderStatusRepository.existsById(orderStatusId)) {
            orderStatusRepository.deleteById(orderStatusId);
            return true;
        }
        return false;
    }
}
