package com.xebia.app.controllers;

import com.xebia.app.models.Customer;
import com.xebia.app.models.CustomersCollection;
import com.xebia.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/customers")
public class CustomersController {

    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<CustomersCollection> getAll(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Customer customer){
        customerService.create(customer);
        return new ResponseEntity<String>("created", HttpStatus.CREATED);
    }
}
