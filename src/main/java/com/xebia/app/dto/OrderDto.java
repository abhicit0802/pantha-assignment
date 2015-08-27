package com.xebia.app.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.xebia.app.models.Customer;
import com.xebia.app.models.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderDto {
    @JsonProperty("order")
    private Order order;
    @JsonProperty("customer")
    private Customer customer;
}
