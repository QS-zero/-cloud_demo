package com.learning.product.service.iml;
import java.math.BigDecimal;

import com.learning.product.bean.Product;
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

        return product;
    }
}
