package com.scnu.edu.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.scnu.edu.sell.dataobject.OrderDetail;
import com.scnu.edu.sell.enums.OrderStatusEnum;
import com.scnu.edu.sell.enums.PayStatusEnum;
import com.scnu.edu.sell.utils.EnumUtil;
import com.scnu.edu.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hepengyu in 0826 08:30
 *
 * @JsonInclude：为null的值就不返回 在配置文件中给全部实体都添加
 * @JsonSerialize：Date转Long类型
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    // 订单id.
    private String orderId;

    // 买家名字.
    private String buyerName;

    // 买家手机号.
    private String buyerPhone;

    // 买家地址.
    private String buyerAddress;

    // 买家微信Openid.
    private String buyerOpenid;

    // 订单总金额.
    private BigDecimal orderAmount;

    // 订单状态, 默认为0新下单.
    private Integer orderStatus;

    // 支付状态, 默认为0未支付.
    private Integer payStatus;

    // 创建时间.
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    // 更新时间.
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    // 对象转JSON格式忽略方法
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
