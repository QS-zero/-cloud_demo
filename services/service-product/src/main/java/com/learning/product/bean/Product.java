package com.learning.product.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    /**
     *  商品id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品数量
     */
    private Integer num;

}
