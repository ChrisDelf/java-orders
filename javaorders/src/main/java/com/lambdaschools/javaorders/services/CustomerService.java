package com.lambdaschools.javaorders.services;

import com.lambdaschools.javaorders.model.Customer;
import com.lambdaschools.javaorders.model.Order;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();

    Customer findCustomerByName(String name);

    void delete(long custcode);

    Customer save(Customer customer);

    Customer update(Customer customer, long id);
}
