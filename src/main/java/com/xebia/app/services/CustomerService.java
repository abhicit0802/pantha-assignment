package com.xebia.app.services;


import com.xebia.app.exceptions.CustomerNotFoundException;
import com.xebia.app.models.Customer;
import com.xebia.app.models.CustomersCollection;
import com.xebia.app.repositories.CustomerRepository;
import com.xebia.app.utils.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomersCollection getAllCustomers() throws CustomerNotFoundException{
        CsvUtil util = new CsvUtil("customers.csv");
        List<Customer> customers = null;
        try {
            customers = util.read();
        }catch (Exception e){
            throw new CustomerNotFoundException("No customers present");
        }
        return new CustomersCollection(customers);
    }

    public boolean create(Customer customer){
      customerRepository.save(customer);
        return true;
    }

    public boolean createBulk(CustomersCollection customers){
       customerRepository.save(customers.getCustomers());
        return true;
    }

    public CustomersCollection findByFirstName(String firstName){
        return new CustomersCollection(customerRepository.findByFirstName(firstName));
    }

    public CustomersCollection findByLastName(String lastName){
        return new CustomersCollection(customerRepository.findByLastName(lastName));
    }

    public Customer findById(String id){
        return customerRepository.findOne(id);
    }
}
