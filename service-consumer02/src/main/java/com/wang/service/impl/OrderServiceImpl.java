package com.wang.service.impl;

import com.wang.pojo.Order;
import com.wang.pojo.Product;
import com.wang.service.OrderService;
import com.wang.service.ProductServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private ProductServiceFeign productServiceFeign;

    @Override
    public Order selectOrderById(Integer id) {
       return new Order(id,"order-001","中国",31994D,
               productServiceFeign.selectProductList());
    }
}

