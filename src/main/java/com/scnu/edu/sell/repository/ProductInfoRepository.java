package com.scnu.edu.sell.repository;

import com.scnu.edu.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductInfoRepository
 * @Description TODO
 * @Author admin
 * @Date 2019/8/25 16:17
 * @ModifyDate 2019/8/25 16:17
 * @Version 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
