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
    public Customer findCustomerByName(String name)
    {
        Customer restaurant = custRepo.findBycustname(name);
        if(restaurant == null)
        {
            throw new EntityNotFoundException("name " + name);
        }
        return restaurant;
    }

    @Override
    public void delete(long custCode) throws EntityNotFoundException
    {

        if (custRepo.findById(custCode).isPresent())
        {
            custRepo.deleteById(custCode);
        } else
        {
            throw new EntityNotFoundException(Long.toString(custCode));
        }
    }

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());

        for (Order o : customer.getOrders())
        {
            newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvancedamount(), newCustomer, o.getOrderDescription()));
        }
        return custRepo.save(newCustomer);
    }
    @Transactional
    @Override
    public Customer update(Customer customer, long id)
    {
        Customer currentCustomer = custRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (customer.getCustname() != null)
        {
            currentCustomer.setCustname(customer.getCustname());
        }
        if (customer.getCustcity() != null)
        {
            currentCustomer.setCustcity(customer.getCustcity());
        }
        if (customer.getWorkingarea() != null)
        {
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }
        if (customer.getCustcountry() != null)
        {
            currentCustomer.setCustcountry(customer.getCustcountry());
        }
        if (customer.getGrade() != null)
        {
            currentCustomer.setGrade(customer.getGrade());
        }
        if (customer.getOpeningamt() != 0)
        {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if (customer.getReceiveamt() != 0)
        {
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }
        if (customer.getPaymentamt() != 0)
        {
            currentCustomer.setPaymentamt(customer.getPaymentamt());
        }
        if (customer.getOpeningamt() != 0)
        {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if (customer.getPhone() != null)
        {
            currentCustomer.setPhone(customer.getPhone());
        }
        if (customer.getAgent() != null)
        {
            currentCustomer.setAgent(customer.getAgent());
        }

        if (customer.getOrders().size() > 0)
        {
            for (Order o : customer.getOrders())
            {
                currentCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvancedamount(), currentCustomer, o.getOrderDescription()));
            }
        }
        return custRepo.save(currentCustomer);
    }

}
