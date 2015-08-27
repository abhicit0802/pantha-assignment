package com.xebia.app.services;


import com.xebia.app.dto.OrderDto;
import com.xebia.app.models.Customer;
import com.xebia.app.models.Order;
import com.xebia.app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerService customerService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerService customerService){
        this.orderRepository = orderRepository;
    }

    public boolean create(Order order){
        System.out.println(order.getCustomerId()+" "+order.getName());
      orderRepository.save(order);
        return true;
    }

    public List<OrderDto> getAll(){
      List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order o : orders){
                Customer c = customerService.findById(o.getCustomerId());
                orderDtos.add(new OrderDto(o, c));
        }
        return orderDtos;
    }

    public OrderDto findOne(String id){
        Order order = orderRepository.findOne(id);
        Customer customer = customerService.findById(id);

        return new OrderDto(order,customer);
    }

}
