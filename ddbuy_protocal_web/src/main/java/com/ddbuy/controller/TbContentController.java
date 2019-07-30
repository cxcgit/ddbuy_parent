package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContent;
import com.ddbuy.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author caixincheng
 * @Classname TbContentController
 * @Date 2019-07-24 14:57
 * @Created by cxc
 */
@Controller
public class TbContentController {
    @Reference(interfaceClass = TbContentService.class,version = "1.0.0",check = false)
    private TbContentService tbContentService;

    @RequestMapping("/getAllTbContent")
    @ResponseBody
    public List<TbContent> getAllTbContent(){
        System.out.println(1);
        return tbContentService.selectAllContent();
    }
}
