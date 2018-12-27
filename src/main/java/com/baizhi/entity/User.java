package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 用户 实体类
 */
public class User {
    private String id;//用户id
    private String name;//用户名字
    private String phone;//用户电话
    private String password;//用户密码
    private String img;//用户照片
    private String fname;//用户法名
    private String sex;//用户性别
    private String region;//用户 地区
    private String signature;//用户签名
    private String status;//用户状态
    @JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
    private Date registertime;//注册时间
    private String salt;//盐值

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", img='" + img + '\'' +
                ", fname='" + fname + '\'' +
                ", sex='" + sex + '\'' +
                ", region='" + region + '\'' +
                ", signature='" + signature + '\'' +
                ", status='" + status + '\'' +
                ", registertime=" + registertime +
                ", salt='" + salt + '\'' +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User(String id, String name, String phone, String password, String img, String fname, String sex, String region, String signature, String status, Date registertime, String salt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.img = img;
        this.fname = fname;
        this.sex = sex;
        this.region = region;
        this.signature = signature;
        this.status = status;
        this.registertime = registertime;
        this.salt = salt;
    }
    public User() {
    }
}
