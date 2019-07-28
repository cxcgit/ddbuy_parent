package com.ddbuy;


import com.ddbuy.service.TbItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyCommonServiceApplicationTests {
    @Autowired
    private TbItemService tbItemService;
    @Test
    public void contextLoads() {
        System.out.println(tbItemService.selectProduct());
    }

}
