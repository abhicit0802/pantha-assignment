package com.xebia.app.controllers;

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
    public ResponseEntity create(@RequestBody Order order){
     orderService.create(order);
        return new ResponseEntity("created", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return new ResponseEntity(orderService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") String id){
        return new ResponseEntity(orderService.findOne(id), HttpStatus.OK);
    }
}
