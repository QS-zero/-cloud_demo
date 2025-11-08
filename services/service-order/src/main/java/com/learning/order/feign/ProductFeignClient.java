package com.learning.order.feign;

import com.learning.prodect.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(value = "service-product") // Feign客户端 自动负载均衡
public interface ProductFeignClient {

    /**
     * MVC注解的两套逻辑
     * 1. 在controller上是接受请求
     * 2. 在FeignClient上是发送请求
     */
    @GetMapping("/get-product/{id}")
    Product getProductById(@PathVariable("id") Long id,
                           @RequestHeader("token") String token);

    @GetMapping("/get-product/{id}")
    Product getProductById(@PathVariable("id") Long id);

}
