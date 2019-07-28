package com.ddbuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.service.TbContentCategoryService;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.entity.TbContentCategoryExample;
import com.ddbuy.mapper.TbContentCategoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = TbContentCategoryService.class,version = "1.0.0",timeout = 1000)
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tbContentCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TbContentCategory record) {
        return tbContentCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(TbContentCategory record) {
        return tbContentCategoryMapper.insertSelective(record);
    }

    @Override
    public PageInfo<TbContentCategory> selectByExample(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<TbContentCategory> tbContentCategoryList = tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
        return new PageInfo<>(tbContentCategoryList);
    }

    @Override
    public List<TbContentCategory> selectByExample() {
        return tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
    }

    @Override
    public TbContentCategory selectByPrimaryKey(Long id) {
        return tbContentCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbContentCategory record) {
        return tbContentCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbContentCategory record) {
        return tbContentCategoryMapper.updateByPrimaryKey(record);
    }
}
