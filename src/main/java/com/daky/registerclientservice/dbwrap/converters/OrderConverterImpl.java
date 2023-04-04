package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.OrderData;
import com.daky.registerclientservice.dbwrap.dto.compositedata.OrderKeyData;
import com.daky.registerclientservice.dbwrap.entries.Order;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.OrderKey;
import org.springframework.stereotype.Component;

@Component
public class OrderConverterImpl implements AbstractConverter<OrderData, Order>{
    @Override
    public OrderData populateData(Order order) {
        OrderData orderData = new OrderData();
        orderData.setId(populateKeyData(order.getId()));
        orderData.setMaster(order.getMaster());
        orderData.setClient(order.getClient());
        orderData.setSkill(order.getSkill());
        orderData.setOrderStatus(order.getOrderStatus());
        orderData.setStartTime(order.getStartTime());
        orderData.setEndTime(order.getEndTime());
        return orderData;
    }

    @Override
    public Order populateEntity(OrderData orderData) {
        Order order = new Order();
        order.setId(populateKeyEntity(orderData.getId()));
        order.setMaster(orderData.getMaster());
        order.setClient(orderData.getClient());
        order.setSkill(orderData.getSkill());
        order.setOrderStatus(orderData.getOrderStatus());
        order.setStartTime(orderData.getStartTime());
        order.setEndTime(orderData.getEndTime());
        return order;
    }

    public OrderKeyData populateKeyData(OrderKey orderKey) {
        OrderKeyData orderKeyData = new OrderKeyData();
        orderKeyData.setMasterID(orderKey.getMasterID());
        orderKeyData.setClientID(orderKey.getClientID());
        orderKeyData.setSkillsID(orderKey.getSkillsID());
        orderKeyData.setStatusID(orderKey.getStatusID());
        return orderKeyData;
    }

    public OrderKey populateKeyEntity(OrderKeyData orderKeyData) {
        OrderKey orderData = new OrderKey();
        orderData.setMasterID(orderKeyData.getMasterID());
        orderData.setClientID(orderKeyData.getClientID());
        orderData.setSkillsID(orderKeyData.getSkillsID());
        orderData.setStatusID(orderKeyData.getStatusID());
        return orderData;
    }
}
