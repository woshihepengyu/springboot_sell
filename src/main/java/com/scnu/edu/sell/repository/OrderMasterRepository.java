package com.scnu.edu.sell.repository;

import com.scnu.edu.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by hepengyu in 0825 21:43
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    // 根据买家的openid来查
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
