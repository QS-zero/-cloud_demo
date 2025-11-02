package com.learning.order.controller;


import com.learning.order.bean.Order;
import com.learning.order.properties.OrderProperties;
import com.learning.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope // 自动刷新
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProperties orderProperties;

//    @Value("${order.timeout}")
//    private String timeout;
//
//    @Value("${order.auto-confirm}")
//    private String autoConfirm;

    @GetMapping("/create-order")
    private Order createOrder(@RequestParam("productId") Long productId,
                              @RequestParam("userId") Long userId){

        Order order = orderService.createOrder(productId, userId);

        return order;
    }

    @GetMapping("/get-config")
    public String getOrder() {
        return "timeout:" + orderProperties.getTimeout() +
                ";autoConfirm:" + orderProperties.getAutoConfirm() +
                ";dbUrl:" + orderProperties.getDbUrl();
    }
}
