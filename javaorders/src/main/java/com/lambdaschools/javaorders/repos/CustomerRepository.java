package com.lambdaschools.javaorders.repos;

import com.lambdaschools.javaorders.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
    Customer findBycustname(String customname);
}
