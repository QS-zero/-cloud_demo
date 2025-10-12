package com.learning.product;


import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {


    @Autowired
    DiscoveryClient discoveryClient; // spring 的表规范所有注册中心都可以引用

    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery; // 仅限于nacos

    @Test
    void discoveryClientTest() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service: " + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getServiceId() + ";ip:" + instance.getHost() + ";Port:" + instance.getPort());
            }
        }

    }

    @Test
    void nacosServiceDiscoveryTest() throws NacosException {
        List<String> services = nacosServiceDiscovery.getServices();

        for (String service : services) {
            System.out.println("nacosService: " + service);
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("nacos" + instance.getServiceId() + ";ip:" + instance.getHost() + ";Port:" + instance.getPort());
            }
        }

    }

}
