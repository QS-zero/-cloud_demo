package com.learning.product.controller;


import com.learning.product.bean.Product;
import com.learning.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/get-product/{id}")
    private Product getProduct(@PathVariable Long id){

        Product product = productService.getProductById(id);

        return product;
    }


}
