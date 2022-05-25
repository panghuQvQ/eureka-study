package com.wang.service.impl;

import com.wang.pojo.Order;
import com.wang.pojo.Product;
import com.wang.service.OrderService;
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


/**
 * 对于服务的消费的三种实现方式：
 * 方法一：DiscoveryClient：通过元数据获取服务的信息
 * 方法二：LoadBalancerClient：Ribbon的负载均衡器
 * 方法三：@LoadBalanced：通过注解开启Ribbon的负载均衡器
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient; // Ribbon 负载均衡器

    @Override
    public Order selectOrderById(Integer id) {
       return new Order(id,"order-001","中国",31994D,
               selectProductListByLoadBalancerClient());
    }

    /**
     * 方法一：DiscoveryClient：使用元数据获取服务信息
     * @return
     */
    private List<Product> selectProductListByDiscoveryClient(){
        StringBuffer sb = null;

        // 从注册中心中，获取服务列表
        List<String> serviceIds = discoveryClient.getServices();
        if(CollectionUtils.isEmpty(serviceIds)){
            return null;
        }

        // 根据服务名称，从注册中心中，获取服务
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("service-provider");
        if(CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }

        ServiceInstance si = serviceInstances.get(0);
        sb = new StringBuffer();
        sb.append("http://" + si.getHost()+":"+si.getPort()+"/product/list");

        // ResponseEntity:封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });

        return response.getBody();
    }

    /**
     * 方法二：LoadBalancerClient：Ribbon的负载均衡器
     */
    private List<Product> selectProductListByLoadBalancerClient(){
        StringBuffer sb = null;

        // 根据服务名称，从注册中心中，获取服务
        ServiceInstance si = loadBalancerClient.choose("service-provider");
        if(si == null ){
            return null;
        }

        sb = new StringBuffer();
        sb.append("http://" + si.getHost()+":"+si.getPort()+"/product/list");
        System.out.println(sb.toString());

        // ResponseEntity:封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });

        return response.getBody();
    }

    /**
     * 方法三：@LoadBalanced：通过注解开启Ribbon的负载均衡器
     * 步骤1：在启动类的restTemplate()方法上添加--->@LoadBalanced注解
     * 步骤2：请求服务
     */
    private List<Product> selectProductListByLoadBalancerAnnotation(){
        // ResponseEntity:封装了返回数据
        // service-provider: 注册中心中，微服务应用名称
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://service-provider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });

        return response.getBody();
    }
}
