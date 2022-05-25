package com.wang.service;

import com.wang.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 声明需要调用的服务
 * 参数：注册中心中，服务的名称
 */
@FeignClient("service-provider")
public interface ProductServiceFeign {

    @GetMapping("/product/list")
    List<Product> selectProductList();
}
