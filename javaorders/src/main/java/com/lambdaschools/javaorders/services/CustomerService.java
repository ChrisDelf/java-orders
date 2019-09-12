package com.lambdaschools.javaorders.services;

import com.lambdaschools.javaorders.model.Customer;
import com.lambdaschools.javaorders.model.Order;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    List<Order> findAllOrdersByName(String name);

    void delete(long customCode);

    Customer findCustomerByName(String name);

    Customer update(Customer customer, long customCode);

    Customer save(Customer customer);
}
