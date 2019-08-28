package com.scnu.edu.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName ProductCategory
 * @Description 类目
 * @Author admin
 * @Date 2019/8/25 14:17
 * @ModifyDate 2019/8/25 14:17
 * @Version 1.0
 */
// @Table(name = "product_category")
// 实体映射成表
@Entity
@Data
@DynamicUpdate
public class ProductCategory {
    // 类目id (主键 + 自增)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    // 类目名字
    private String categoryName;
    // 类目编号
    private Integer categoryType;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
