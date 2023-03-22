package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.OrdersStatusData;
import com.daky.registerclientservice.dbwrap.entries.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrdersStatusConverterImpl implements AbstractConverter<OrdersStatusData, OrderStatus> {
    @Override
    public OrdersStatusData populateData(OrderStatus orderStatus) {
        OrdersStatusData ordersStatusData = new OrdersStatusData();
        ordersStatusData.setId(orderStatus.getId());
        ordersStatusData.setStatus(orderStatus.getStatus());
        return ordersStatusData;
    }

    @Override
    public OrderStatus populateEntity(OrdersStatusData ordersStatusData) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatus(ordersStatusData.getStatus());
        return orderStatus;
    }
}
