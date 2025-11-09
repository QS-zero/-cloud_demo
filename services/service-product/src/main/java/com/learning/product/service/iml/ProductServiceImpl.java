package com.learning.product.service.iml;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.learning.prodect.bean.Product;
import com.learning.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("HuaWei-Mate60pro");
        product.setPrice(new BigDecimal("99"));
        product.setNum(2);

//        try {
//            TimeUnit.SECONDS.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return product;
    }
}
