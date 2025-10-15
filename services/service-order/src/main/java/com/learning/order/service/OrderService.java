package com.learning.order.service;

import com.learning.order.bean.Order;

public interface OrderService {

    Order createOrder(Long productId, Long userId);
}
