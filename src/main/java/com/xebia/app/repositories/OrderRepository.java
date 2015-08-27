package com.xebia.app.repositories;


import com.xebia.app.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends MongoRepository<Order,String>,PagingAndSortingRepository<Order,String> {

}
