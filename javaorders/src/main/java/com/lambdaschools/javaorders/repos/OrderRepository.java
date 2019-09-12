package com.lambdaschools.javaorders.repos;

import com.lambdaschools.javaorders.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
