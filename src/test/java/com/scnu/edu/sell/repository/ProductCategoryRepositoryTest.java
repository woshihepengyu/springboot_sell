package com.scnu.edu.sell.repository;

import com.scnu.edu.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
//        findOne方法的返回值也改了，变成了Optional<T>。
//        Optional是Java8的新特性之一，它显示的告诉调用者该值可能是空值，需要做出判断，避免出现空指针异常。
        Optional<ProductCategory> byId = repository.findById(1);
        ProductCategory productCategory = null;
        if (byId.isPresent()) {
            productCategory = byId.get();
        }
        System.out.println(productCategory.toString());
    }

    // Transactional 数据库不要有我们测试的数据
    @Test
    @Transactional
    public void saveTest() {
        Optional<ProductCategory> byId = repository.findById(2);
        ProductCategory productCategory = null;
        if (byId.isPresent()) {
            productCategory = byId.get();
            productCategory.setCategoryType(7);
            repository.save(productCategory);
        }
    }
}