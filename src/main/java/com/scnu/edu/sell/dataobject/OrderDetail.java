package com.scnu.edu.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName OrderDetail
 * @Description 订单详情
 * @Author admin
 * @Date 2019/8/25 21:41
 * @ModifyDate 2019/8/25 21:41
 * @Version 1.0
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;

    // 订单id.
    private String orderId;

    // 商品id.
    private String productId;

    // 商品名称.
    private String productName;

    // 商品单价.
    private BigDecimal productPrice;

    // 商品数量.
    private Integer productQuantity;

    // 商品小图.
    private String productIcon;
}
