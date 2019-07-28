package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.service.TbItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caixincheng
 * @Classname SolrComtroller
 * @Date 2019-07-28 22:57
 * @Created by cxc
 */
@Controller
public class SolrComtroller {
    @Reference(interfaceClass = TbItemService.class,version = "1.0.0",check = false)
    private TbItemService tbItemService;

    @RequestMapping("/import")
    @ResponseBody
    public Boolean importSolr(){
        return tbItemService.selectProduct();
    }
}
