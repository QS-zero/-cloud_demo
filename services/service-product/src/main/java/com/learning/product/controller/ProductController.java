package com.learning.product.controller;


import com.learning.prodect.bean.Product;
import com.learning.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/get-product/{id}")
    private Product getProduct(@PathVariable Long id,
                               HttpServletRequest  request){
        String header = request.getHeader("X-Token");

        System.out.println("hello, header is " + header);

        Product product = productService.getProductById(id);

        return product;
    }


}
