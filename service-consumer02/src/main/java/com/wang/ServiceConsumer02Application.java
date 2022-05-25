package com.wang;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

// 开启EurekaClient注解，如果配置了Eureka客户端依赖，默认会开启该注解
// @EnableEurekaClient
@SpringBootApplication
@EnableFeignClients // 开启FeignClient注解
public class ServiceConsumer02Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumer02Application.class, args);
    }

    // 开启负载均衡，随机策略
    @Bean
    public RandomRule randomRule(){
        return new RandomRule();
    }

}
