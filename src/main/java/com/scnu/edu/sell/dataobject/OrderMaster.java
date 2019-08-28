package com.scnu.edu.sell.dataobject;

import com.scnu.edu.sell.enums.OrderStatusEnum;
import com.scnu.edu.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderMaster
 * @Description 订单主表
 * @Author admin
 * @Date 2019/8/25 21:34
 * @ModifyDate 2019/8/25 21:34
 * @Version 1.0
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {
    // 订单id.
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    // 支付状态, 默认为0未支付.
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    // 创建时间.
    private Date createTime;

    // 更新时间.
    private Date updateTime;

//    @Transient
//    private List<OrderDetail> orderDetailList;

}
