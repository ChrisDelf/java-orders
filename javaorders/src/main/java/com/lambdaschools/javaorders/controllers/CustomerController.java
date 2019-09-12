package com.lambdaschools.javaorders.controllers;

import com.lambdaschools.javaorders.model.Customer;
import com.lambdaschools.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    // http://localhost:2019/project/customer/order
    @GetMapping(value = "/customer/order", produces = {"application/json"})
    public ResponseEntity<?> listAllCustWithOrders()
    {
        List<Customer> myCustomers = customerService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
}