package com.xebia.app.services;


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

    public CustomersCollection getAllCustomers(){
        CsvUtil util = new CsvUtil("customers.csv");
        List<Customer> customers = null;
        try {
            customers = util.read();
        }catch (Exception e){

        }
        return new CustomersCollection(customers);
    }

    public boolean create(Customer customer){
        System.out.println(customer.getFirstName());
      customerRepository.save(customer);
        System.out.println("customer");
        return true;
    }
}
