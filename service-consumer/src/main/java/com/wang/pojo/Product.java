package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName Product.java
 * @Description TODO
 * @createTime 2022年05月11日 10:31:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Integer id;

    private String productName;

    private Integer productNum;

    private Double productPrice;

}
