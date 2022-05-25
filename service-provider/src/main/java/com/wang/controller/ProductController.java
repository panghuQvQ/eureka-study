package com.wang.controller;

import com.wang.pojo.Product;
import com.wang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName ProductController.java
 * @Description TODO
 * @createTime 2022年05月11日 10:46:00
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> selectProductList(){
        return productService.selectProductList();
    }
}
