package com.learning.order.service.impl;

import com.learning.order.bean.Order;
import com.learning.order.service.OrderService;
import com.learning.prodect.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DiscoveryClient discoveryClient; // 服务发现

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order createOrder(Long productId, Long userId) {

        Product productFromRemote = getProductFromRemote(productId);

        Order order = new Order();
        order.setId(1L);
        order.setTotalPrice(productFromRemote.getPrice().multiply(new BigDecimal(productFromRemote.getNum())));
        order.setUserId(userId);
        order.setNickName("张三");
        order.setAddress("这是一个收到货地址");
        order.setPriductList(List.of(productFromRemote));


        return order;
    }

    private Product getProductFromRemote(Long productId){

        //1. 获取目标服务所有机器的ip+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance instance = instances.get(0);
        // 远程URL http://localhost:9000/get-product/20
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/get-product/" + productId;
        log.info("远程请求url:{}", url);
        // 2. 通过restTemplate远程调用
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }

}
