package com.daky.registerclientservice.dbwrap.controllers;

import com.daky.registerclientservice.dbwrap.dto.OrderData;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.OrderKey;
import com.daky.registerclientservice.dbwrap.services.AbstractRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Resource(name = "orderService")
    private AbstractRegisterService registerService;

    @PostMapping(value = "/orders")
    public ResponseEntity<?> create(@RequestBody OrderData orderData) {
        registerService.create(orderData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<OrderData>> getAllOrders() {
        final List<OrderData> orders = registerService.getAll();

        return orders != null &&  !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/orders/id")
    public ResponseEntity<?> getOrderByID(@RequestParam(name = "masterID") long masterID,
                                          @RequestParam(name = "clientID") long clientID,
                                          @RequestParam(name = "skillID") long skillID,
                                          @RequestParam(name = "statusID") long statusID) {
        OrderKey id = new OrderKey(masterID, clientID, skillID, statusID);
        final Optional<OrderData> orderData = registerService.getById(id);

        return orderData != null
                ? new ResponseEntity<>(orderData, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/orders/id")
    public ResponseEntity<?> updateOrder(@RequestParam(name = "masterID") long masterID,
                                         @RequestParam(name = "clientID") long clientID,
                                         @RequestParam(name = "skillID") long skillID,
                                         @RequestParam(name = "statusID") long statusID,
                                         @RequestBody OrderData orderData) {
        OrderKey id = new OrderKey(masterID, clientID, skillID, statusID);
        final boolean updated = registerService.update(orderData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/orders/id")
    public ResponseEntity<?> deleteOrder(@RequestParam(name = "masterID") long masterID,
                                         @RequestParam(name = "clientID") long clientID,
                                         @RequestParam(name = "skillID") long skillID,
                                         @RequestParam(name = "statusID") long statusID) {

        OrderKey id = new OrderKey(masterID, clientID, skillID, statusID);
        return registerService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
