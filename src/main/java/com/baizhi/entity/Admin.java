package com.baizhi.entity;

/**
 * 管理员表
 * 主要职责：在后台进行数据的增删改操作
 */
public class Admin {
    private String id;//管理员id
    private String name;//管理员名字
    private String username;//管理员用户名
    private String password;//管理员密码
    private String title;//管理员权限等级
    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
    public Admin(String id, String name, String username, String password, String title) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.title = title;
    }
    public Admin() {}
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
