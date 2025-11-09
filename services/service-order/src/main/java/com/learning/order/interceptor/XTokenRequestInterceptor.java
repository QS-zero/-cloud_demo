package com.learning.order.interceptor;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component // 全局的拦截器？？
public class XTokenRequestInterceptor implements RequestInterceptor {

    /**
     * FeignClient发送请求之前会调用此方法
     * @param requestTemplate 请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("X-Token拦截器");
        requestTemplate.header("X-Token",
                UUID.randomUUID().toString());
    }
}
