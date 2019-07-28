package com.ddbuy.util;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author caixincheng
 * @Classname Product
 * @Date 2019-07-28 22:18
 * @Created by cxc
 */
public class Product {
    @Field
    private Long pid;
    @Field
    private String title;
    @Field
    private String image;
    @Field
    private Double price;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
