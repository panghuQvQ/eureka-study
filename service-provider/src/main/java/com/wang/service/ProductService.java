package com.wang.service;

import com.wang.pojo.Product;

import java.util.List;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName ProductService.java
 * @Description TODO
 * @createTime 2022年05月11日 10:37:00
 */
public interface ProductService {

    List<Product> selectProductList();
}
