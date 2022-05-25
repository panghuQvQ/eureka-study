package com.wang.service.impl;

import com.wang.pojo.Product;
import com.wang.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName ProductServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月11日 10:39:00
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
                new Product(1,"华为手机",2,5888D),
                new Product(2,"联想笔记本",1,6888D),
                new Product(3,"小米平板",5,2888D)
        );
    }
}
