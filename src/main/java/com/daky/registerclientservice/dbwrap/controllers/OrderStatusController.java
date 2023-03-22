package com.daky.registerclientservice.dbwrap.controllers;

import com.daky.registerclientservice.dbwrap.dto.OrdersStatusData;
import com.daky.registerclientservice.dbwrap.services.AbstractRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderStatusController {
    @Resource(name = "orderStatusService")
    private AbstractRegisterService registerService;


    @PostMapping(value = "/orderStatuses")
    public ResponseEntity<?> create(@RequestBody OrdersStatusData ordersStatusData) {
        registerService.create(ordersStatusData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/orderStatuses")
    public ResponseEntity<List<OrdersStatusData>> getAllOrdersStatuses() {
        final List<OrdersStatusData> ordersStatuses = registerService.getAll();

        return ordersStatuses != null &&  !ordersStatuses.isEmpty()
                ? new ResponseEntity<>(ordersStatuses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/orderStatuses/{id}")
    public ResponseEntity<?> getOrderStatusByID(@PathVariable(name = "id") long id) {
        final Optional<OrdersStatusData> ordersStatus = registerService.getById(id);

        return ordersStatus != null
                ? new ResponseEntity<>(ordersStatus, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/orderStatuses/{id}")
    public ResponseEntity<?> updateOrdersStatus(@PathVariable(name = "id") long id,
                                                @RequestBody OrdersStatusData ordersStatusData) {
        final boolean updated = registerService.update(ordersStatusData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/orderStatuses/{id}")
    public ResponseEntity<?> deleteOrdersStatus(@PathVariable(name = "id") long id) {

        return registerService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
