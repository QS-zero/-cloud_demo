package com.learning.order.bean.service.impl;

import com.learning.order.bean.Order;
import com.learning.order.bean.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Long productId, Long userId) {

        Order order = new Order();
        order.setId(1L);
        // TODO 后续计算
        order.setTotalPrice(new BigDecimal("0"));
        order.setUserId(userId);
        order.setNickName("张三");
        order.setAddress("这是一个收到货地址");
        // TODO 远程调用商品列表
        order.setPriductList(null);


        return order;
    }

}
