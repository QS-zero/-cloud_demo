package com.learning.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


// Feign客户端 自动负载均衡
// url 指定服务域名与协议
// https://aliv18.data.moji.com/whapi/json/alicityweather/limit
@FeignClient(value = "weather-product", url = "https://aliv18.data.moji.com")
public interface WeatherFeignClient {

    /**
     * MVC注解的两套逻辑
     * 1. 在controller上是接受请求
     * 2. 在FeignClient上是发送请求
     */
    @PostMapping("/whapi/json/alicityweather/limit")
    String getWeather(@RequestHeader("Authorization") String Authorization,
                       @RequestParam("cityId") String cityId,
                       @RequestParam("token") String token);


}
