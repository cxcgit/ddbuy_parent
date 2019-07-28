package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caixincheng
 * @Classname TestController
 * @Date 2019-07-28 17:14
 * @Created by cxc
 */
@Controller
public class TestController {
//    @Reference(interfaceClass = TbContentService.class,version = "1.0.0",check = false)
//    private TbContentService tbContentService;

    @RequestMapping("/index")
    @ResponseBody
    public String goIndex(){
        return "index";
    }

}
