package com.scnu.edu.sell.service;


import com.scnu.edu.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by hepengyu
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
