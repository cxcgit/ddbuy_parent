package com.ddbuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.mapper.TbItemMapper;
import com.ddbuy.service.TbItemService;
import com.ddbuy.util.Product;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author caixincheng
 * @Classname TbItemServiceImpl
 * @Date 2019-07-28 22:24
 * @Created by cxc
 */
@Component
@Service(interfaceClass = TbItemService.class,version = "1.0.0",timeout = 1000)
public class TbItemServiceImpl implements TbItemService {
    @Value("${spring.data.solr.host}")
    private String solrUrl;
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public Boolean selectProduct() {
        try {
            //导入索引库
            //调用dao层获取所有记录
            List<Product> list=tbItemMapper.selectProduct();
            //将记录导入索引库
            //1.创建solr的服务器对象
            HttpSolrClient solr = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
            //3.添加到索引库
            solr.addBeans(list);
            //4.提交
            solr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
