package com.learning.order.controller;


import com.learning.order.bean.Order;
import com.learning.order.bean.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create-order")
    private Order createOrder(@RequestParam("productId") Long productId,
                            @RequestParam("userId") Long userId){

        Order order = orderService.createOrder(productId, userId);

        return order;
    }

}
