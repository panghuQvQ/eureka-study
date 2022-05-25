package com.wang.service;

import com.wang.pojo.Order;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2022年05月11日 11:26:00
 */
public interface OrderService {

    Order selectOrderById(Integer id);
}
