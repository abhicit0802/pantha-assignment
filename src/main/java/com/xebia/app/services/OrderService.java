package com.xebia.app.services;


import com.xebia.app.dto.OrderDto;
import com.xebia.app.exceptions.InvalidOrderException;
import com.xebia.app.exceptions.OrderNotFoundException;
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

    public boolean create(Order order) throws InvalidOrderException{
        System.out.println(order.getCustomerId()+" "+order.getName());
        try {
            orderRepository.save(order);
            return true;
        }catch (Exception e){
          throw new InvalidOrderException("invalid order record");
        }
    }

    public List<OrderDto> getAll() throws OrderNotFoundException{
      List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        try {
            for (Order o : orders) {
                Customer c = customerService.findById(o.getCustomerId());
                orderDtos.add(new OrderDto(o, c));
            }
            return orderDtos;
        }catch (Exception e){
            throw new OrderNotFoundException("No order records found");
        }
    }

    public OrderDto findOne(String id)throws OrderNotFoundException{
        try {
            Order order = orderRepository.findOne(id);
            Customer customer = customerService.findById(id);
            return new OrderDto(order,customer);
        }catch (Exception e){
            throw new OrderNotFoundException("order record not found for order id -"+id);
        }

    }

}
