package com.daky.registerclientservice.dbwrap.repositories;

import com.daky.registerclientservice.dbwrap.entries.Order;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.OrderKey;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, OrderKey>{
}
