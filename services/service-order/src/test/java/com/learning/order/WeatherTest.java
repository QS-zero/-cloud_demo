package com.learning.order;


//2209

import com.learning.order.feign.WeatherFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class WeatherTest {

    @Autowired
    private WeatherFeignClient weatherFeignClient;

    @Test
    public void test() {
        String result = weatherFeignClient.getWeather(
                "e1245861df2c4ed682f6f17487854279",
                "2209",
                "27200005b3475f8b0e26428f9bfb13e9");

        log.info("result: {}", result);


    }
}
