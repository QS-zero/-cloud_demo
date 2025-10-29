package com.learning.order;

import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.util.List;

@SpringBootTest
@Slf4j
public class LoadbalancerTest {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    DiscoveryClient discoveryClient;

    @Test
    public void test() {

        // 获取服务列表
//        List<ServiceInstance> clientInstances = discoveryClient.getInstances("service-product");

        // 获取一个服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-product");
        log.info("host: " + serviceInstance.getHost() + ";port: " + serviceInstance.getPort());
         serviceInstance = loadBalancerClient.choose("service-product");
        log.info("host: " + serviceInstance.getHost() + ";port: " + serviceInstance.getPort());
         serviceInstance = loadBalancerClient.choose("service-product");
        log.info("host: " + serviceInstance.getHost() + ";port: " + serviceInstance.getPort());
         serviceInstance = loadBalancerClient.choose("service-product");
        log.info("host: " + serviceInstance.getHost() + ";port: " + serviceInstance.getPort());
    }
}
