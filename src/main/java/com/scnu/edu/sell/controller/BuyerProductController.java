package com.scnu.edu.sell.controller;

import com.scnu.edu.sell.VO.ProductInfoVO;
import com.scnu.edu.sell.VO.ProductVO;
import com.scnu.edu.sell.VO.ResultVO;
import com.scnu.edu.sell.dataobject.ProductCategory;
import com.scnu.edu.sell.dataobject.ProductInfo;
import com.scnu.edu.sell.service.CategoryService;
import com.scnu.edu.sell.service.ProductService;
import com.scnu.edu.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BuyerProductController
 * @Description 买家商品
 * @Author admin
 * @Date 2019/8/25 17:03
 * @ModifyDate 2019/8/25 17:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1、查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2、查询类目(一次性查询)
        List<Integer> categoryTypeList = new ArrayList<>();
        // 传统方法
        //        for (ProductInfo productInfo : productInfoList) {
        //            categoryTypeList.add(productInfo.getCategoryType());
        //        }
        // 精简方法 (jdk8)
        categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3、数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // copy data
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
