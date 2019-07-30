package com.ddbuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.ddbuy.entity.TbContent;
import com.ddbuy.entity.TbContentExample;
import com.ddbuy.mapper.TbContentMapper;
import com.ddbuy.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author caixincheng
 * @Classname TbContentServiceImpl
 * @Date 2019-07-22 16:14
 * @Created by cxc
 */
@Component
@Service(interfaceClass = TbContentService.class,version = "1.0.0",timeout = 3000)
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentMapper tbContentMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int addTbContent(TbContent tbContent) {
        //增删改的时候清空redis缓存
        if (redisTemplate.hasKey("content"))
        redisTemplate.delete("content");
        return tbContentMapper.insertSelective(tbContent);
    }

    /**
     * 查询全部的广告，并存在redis中
     * @return
     */
    @Override
    public List<TbContent> selectAllContent() {
        List<TbContent> list=null;
        ValueOperations<String, List<TbContent>> operations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey("content")){
            System.out.println("redis");
            list=operations.get("content");
        }else{
            System.out.println("msql");
            list=tbContentMapper.selectByExample(new TbContentExample());
            operations.set("content",list,24, TimeUnit.HOURS);
        }
        return list;
    }
}
