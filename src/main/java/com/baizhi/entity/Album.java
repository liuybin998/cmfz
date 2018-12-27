package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 专辑表
 * 连接章节表
 * 以对多
 */
public class Album {
    private String id;//专辑id
    private String name;//专辑名
    private Integer count;//集数
    @JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
    private Date createDate;//添加时间
    private String score;//评分
    private String author;//作者
    private String broadCast;//播音
    private String brief;//简介
    private String img;//专辑图片
    private List<Chapter> children;

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                ", createDate=" + createDate +
                ", score='" + score + '\'' +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", img='" + img + '\'' +
                ", children=" + children +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album(String id, String name, Integer count, Date createDate, String score, String author, String broadCast, String brief, String img, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.createDate = createDate;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.img = img;
        this.children = children;
    }

    public Album() {
    }
}
