package com.xebia.app.repositories;


import com.xebia.app.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String>,PagingAndSortingRepository<Customer,String>{

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
