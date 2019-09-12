package com.lambdaschools.javaorders.controllers;

import com.lambdaschools.javaorders.model.Customer;
import com.lambdaschools.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    // http://localhost:2019/customer/order
    // Get
    @GetMapping(value = "/customer/order",
            produces = {"application/json"})
    public ResponseEntity<?> getAllCustomers()
    {
        List<Customer> myCustomers = customerService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
    //  http://localhost:2019/customer/name/{customname}
    //Get

    @GetMapping(value = "/customer/name/{customname}",
            produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(@PathVariable String customname)
    {
        Customer myCustomer = customerService.findCustomerByName(customname);
        return new ResponseEntity<>(myCustomer, HttpStatus.OK);
    }
}