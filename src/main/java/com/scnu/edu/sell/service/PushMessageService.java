package com.scnu.edu.sell.service;

import com.scnu.edu.sell.dto.OrderDTO;

/**
 * 推送消息
 * Created by hepengyu in 0827
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
