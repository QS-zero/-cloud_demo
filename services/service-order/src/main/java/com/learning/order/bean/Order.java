package com.learning.order.bean;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {
    /**
     * 订单id
     */
    private Long id;

    /**
     * 订单总价
     */
    private BigDecimal totalPrice;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 商品列表
     */
    private List<Object> priductList;

}
