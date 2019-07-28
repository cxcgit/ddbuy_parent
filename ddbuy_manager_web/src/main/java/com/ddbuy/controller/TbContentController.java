package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContent;
import com.ddbuy.service.TbContentService;
import com.ddbuy.util.FastDfsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * @author caixincheng
 * @Classname TbContentController
 * @Date 2019-07-22 16:23
 * @Created by cxc
 */
@Controller
public class TbContentController {
    //接收配置文件中的值
    @Value("${nginx.fastdfs.address}")
    private String nginx_FastDfs_address;

    @Reference(interfaceClass = TbContentService.class,version = "1.0.0",check = false)
    private TbContentService tbContentService;

    @RequestMapping(value = "/addTbContent",produces = "application/json")//强制返回值为json
    @ResponseBody
    public String addTbContent(TbContent tbContent, @RequestParam("file") MultipartFile file){
        int i=0;
        try {
            //获取文件字节数组
            byte[] bytes = file.getBytes();
            //获取文件扩展名
            String filename = file.getOriginalFilename();
            String extName = filename.substring(filename.lastIndexOf(".") + 1);
            String[] strings = FastDfsUtil.upLoad(bytes, extName);
            //上传成功后添加信息到数据库
            if (strings!=null){
                String pic=nginx_FastDfs_address+"/"+strings[0]+"/"+strings[1];//strings[0]组名 strings[1]图片名                tbContent.setPic(pic);
                tbContent.setPic(pic);
                i = tbContentService.addTbContent(tbContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        float f=0x687;
        return "{\"result\":"+i+"}";
    }
}
