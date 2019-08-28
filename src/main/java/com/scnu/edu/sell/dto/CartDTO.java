package com.scnu.edu.sell.dto;

import lombok.Data;

/**
 * 购物车
 * Created by hepengyu in 09:02
 */
@Data
public class CartDTO {

    // 商品Id.
    private String productId;

    // 数量.
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
