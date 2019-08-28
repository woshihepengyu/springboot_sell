package com.scnu.edu.sell.repository;

import com.scnu.edu.sell.dataobject.OrderDetail;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail detail = new OrderDetail();
        detail.setDetailId("1124454234454");
        detail.setOrderId("11111");
        detail.setProductIcon("http://111");
        detail.setProductId("1112111");
        detail.setProductName("粥");
        detail.setProductPrice(new BigDecimal(11.2));
        detail.setProductQuantity(222);

        OrderDetail orderDetail = repository.save(detail);
        Assert.assertNotNull(orderDetail);
        Assert.assertTrue("判断是对的", StringUtils.isNotBlank(orderDetail.toString()));
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("11111");
        Assert.assertNotEquals(0, orderDetailList.size());

    }
}