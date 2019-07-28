package com.ddbuy.service;

import com.ddbuy.entity.TbContentCategory;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface TbContentCategoryService {
    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    PageInfo<TbContentCategory> selectByExample(Integer page, Integer rows);

    List<TbContentCategory> selectByExample();

    TbContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);
}
