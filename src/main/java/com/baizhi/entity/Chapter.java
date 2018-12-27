package com.baizhi.entity;

/**
 * 章节表
 */
public class Chapter {
    private String id;//id
    private String aid;//专辑id
    private String name;//章节名
    private String size;//章节大小
    private String url;//章节路径
    private String time;//章节时长

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", aid='" + aid + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", url='" + url + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Chapter(String id, String aid, String name, String size, String url, String time) {
        this.id = id;
        this.aid = aid;
        this.name = name;
        this.size = size;
        this.url = url;
        this.time = time;
    }

    public Chapter() {
    }
}
