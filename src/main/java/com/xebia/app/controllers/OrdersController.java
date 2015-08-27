package com.xebia.app.controllers;

import com.xebia.app.exceptions.InvalidOrderException;
import com.xebia.app.exceptions.OrderNotFoundException;
import com.xebia.app.models.Order;
import com.xebia.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {
    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Order order){
        try {
            orderService.create(order);
            return new ResponseEntity<>("created", HttpStatus.CREATED);
        }catch (InvalidOrderException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(){
        try {
            return new ResponseEntity(orderService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") String id){
        try {
            return new ResponseEntity(orderService.findOne(id), HttpStatus.OK);
        }catch (OrderNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
