package com.xebia.assignment_vacc.dao;

import com.xebia.assignment_vacc.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
