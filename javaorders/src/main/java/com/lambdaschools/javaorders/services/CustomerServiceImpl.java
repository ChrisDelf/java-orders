package com.lambdaschools.javaorders.services;

import com.lambdaschools.javaorders.model.Customer;
import com.lambdaschools.javaorders.model.Order;
import com.lambdaschools.javaorders.repos.CustomerRepository;
import com.lambdaschools.javaorders.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    private CustomerRepository custRepo;
    private OrderRepository orderRepo;

    @Override
    public List<Customer> findAll()
    {
        ArrayList<Customer> list = new ArrayList<>();
        custRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Order> findAllOrdersByName(String name) throws EntityNotFoundException
    {
        ArrayList<Order> list = new ArrayList<>();
        return list;
    }

    @Override
    public void delete(long customCode) throws EntityNotFoundException
    {

        if (custRepo.findById(customCode).isPresent())
        {
            custRepo.deleteById(customCode);
        } else
        {
            throw new EntityNotFoundException(Long.toString(customCode));
        }
    }

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();

        newCustomer.setCustomName(customer.getCustomName());
        newCustomer.setCity(customer.getCity());
        newCustomer.setCustCountry(customer.getCustCountry());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setWorkingArea(customer.getWorkingArea());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningAmt(customer.getOpeningAmt());
        newCustomer.setOutstandingAmt(customer.getOutstandingAmt());
        newCustomer.setReceiveAmt(customer.getReceiveAmt());
        newCustomer.setPaymentAmt(customer.getPaymentAmt());

        return custRepo.save(newCustomer);
    }

    @Transactional
    @Override
    public Customer update(Customer customer, long custCode)
    {
        return null;
    }


}
