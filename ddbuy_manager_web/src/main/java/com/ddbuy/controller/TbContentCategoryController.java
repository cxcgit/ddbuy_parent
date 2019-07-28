package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.service.TbContentCategoryService;
import com.ddbuy.entity.TbContentCategory;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TbContentCategoryController {
    @Reference(interfaceClass = TbContentCategoryService.class,version ="1.0.0",check = false)
    private TbContentCategoryService tbContentCategoryService;

    //查询所有广告分类带分页
    @RequestMapping("/getAllTbContentCategory")
    @ResponseBody
    public Map<String,Object> getAlltbContentCategory(Integer page, Integer rows){
        PageInfo<TbContentCategory> pageInfo = tbContentCategoryService.selectByExample(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }


    //查询所有广告分类不带分页
    @RequestMapping("/getAllTbContentCategory1")
    @ResponseBody
    public List<TbContentCategory> getAlltbContentCategory(){
        return tbContentCategoryService.selectByExample();
    }

    //查询一条广告信息
    @RequestMapping("/getOneTbContentCategory")
    @ResponseBody
    public TbContentCategory getOneTbContentCategory(Long id){
        return tbContentCategoryService.selectByPrimaryKey(id);
    }

    //添加广告信息
    @RequestMapping("/addTbContentCategory")
    @ResponseBody
    public String addTbContentCategory(TbContentCategory tbContentCategory){
        int i = tbContentCategoryService.insertSelective(tbContentCategory);
        return "{\"result\":"+i+"}";
    }

    //修改广告信息
    @RequestMapping("/upTbContentCategory")
    @ResponseBody
    public String upTbContentCategory(TbContentCategory tbContentCategory){
        int i = tbContentCategoryService.updateByPrimaryKeySelective(tbContentCategory);
        return "{\"result\":"+i+"}";
    }

    //删除广告信息
    @RequestMapping("/delTbContentCategory")
    @ResponseBody
    public String delTbContentCategory(Long id){
        int i = tbContentCategoryService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }
}
