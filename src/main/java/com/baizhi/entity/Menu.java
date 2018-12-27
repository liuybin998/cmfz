package com.baizhi.entity;

import java.util.List;

/**
 * 菜单表 实体类
 */
public class Menu{
    private String id;
    private String name;
    private String iconcls;
    private String parentid;
    private String url;
    private List<Menu> menus;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", parentid='" + parentid + '\'' +
                ", url='" + url + '\'' +
                ", menus=" + menus +
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

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu(String id, String name, String iconcls, String parentid, String url, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.iconcls = iconcls;
        this.parentid = parentid;
        this.url = url;
        this.menus = menus;
    }

    public Menu() {
    }
}
