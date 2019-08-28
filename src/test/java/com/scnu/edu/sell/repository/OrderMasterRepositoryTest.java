package com.scnu.edu.sell.repository;

import com.scnu.edu.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void findByBuyerOpenidTest() {
        // 第0页开始的2项
        // PageRequest extends AbstractPageRequest
        // AbstractPageRequest implements Pageable
        PageRequest request = new PageRequest(1, 3);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        // 第1页虽然可以看到有显示数据个数 但是有些数据content为空的
        Assert.assertNotEquals(0, result.getTotalElements());
//        System.out.println(result.getTotalElements());

    }


    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234564");
        orderMaster.setBuyerName("小何");
        orderMaster.setBuyerPhone("123456789013");
        orderMaster.setBuyerAddress("华师");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }


}