package com.learning.order.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "order")
@Component
/**
 * 订单服务配置类
 * 无需注解自动刷新
 */
public class OrderProperties {

    private String timeout;

    private String autoConfirm;

    private String dbUrl;

}
