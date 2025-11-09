package com.learning.order.feign.fallback;
import java.math.BigDecimal;

import com.learning.order.feign.ProductFeignClient;
import com.learning.prodect.bean.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProductById(Long id, String token) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调。。。");

        Product product = new Product();
        product.setId(id);
        product.setName("商品，走丢了！！！");
        product.setPrice(new BigDecimal("0"));
        product.setNum(0);

        return product;
    }
}
