package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 轮播图实体类
 */
public class Carousel {
    private String id;//id
    private String url;//图片路径
    private String headline;//标题
    private String status;//状态

    @JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
    private Date time;//上传时间
    private String describ;//描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", headline='" + headline + '\'' +
                ", status='" + status + '\'' +
                ", time=" + time +
                ", describ='" + describ + '\'' +
                '}';
    }

    public Carousel(String id, String url, String headline, String status, Date time, String describ) {
        this.id = id;
        this.url = url;
        this.headline = headline;
        this.status = status;
        this.time = time;
        this.describ = describ;
    }

    public Carousel() {
    }
}
