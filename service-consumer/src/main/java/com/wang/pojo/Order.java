package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName Order.java
 * @Description TODO
 * @createTime 2022年05月11日 11:16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Integer id;

    private String orderNo;

    private String orderAddress;

    private Double totalPrice;

    private List<Product> productList;
}
