package com.ddbuy;


import com.ddbuy.service.TbContentCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyCommonServiceApplicationTests {
    @Autowired
    private TbContentCategoryService tbContentCategoryService;
    @Test
    public void contextLoads() {
        System.out.println(tbContentCategoryService.selectByExample().size());
    }

}
