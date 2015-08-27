package com.xebia.app.controllers;

import com.xebia.app.exceptions.CustomerNotFoundException;
import com.xebia.app.models.Customer;
import com.xebia.app.models.CustomersCollection;
import com.xebia.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {

    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(){
        try{
            return new ResponseEntity(customerService.getAllCustomers(), HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Customer customer){
        customerService.create(customer);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bulk",method = RequestMethod.POST)
    public ResponseEntity<String> createBulk(@RequestBody CustomersCollection customers){
        customerService.createBulk(customers);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/firstName/{firstName}")
    public ResponseEntity findAllByFirstName(@PathVariable("firstName") String firstName){
        return new ResponseEntity(customerService.findByFirstName(firstName), HttpStatus.OK);
    }

    @RequestMapping(value = "/lastName/{lastName}")
    public ResponseEntity findAllByLastName(@PathVariable("lastName") String lastName){
        return new ResponseEntity(customerService.findByLastName(lastName), HttpStatus.OK);
    }
}
