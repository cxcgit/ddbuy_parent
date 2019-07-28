package com.ddbuy.service;

import com.ddbuy.entity.TbContent;
import com.ddbuy.entity.TbContentExample;

import java.util.List;

/**
 * @author caixincheng
 * @Classname TbContent
 * @Date 2019-07-22 16:13
 * @Created by cxc
 */
public interface TbContentService {
    int addTbContent(TbContent tbContent);

    List<TbContent> selectByExample();
}
