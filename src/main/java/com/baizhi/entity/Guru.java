package com.baizhi.entity;

/**
 * 上师表实体类
 */
public class Guru {
    private String id;//id
    private String name;//法师名
    private String photo;//照片路径
    private String state;//状态
    private String gender;//性别

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", state='" + state + '\'' +
                ", gender='" + gender + '\'' +
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Guru(String id, String name, String photo, String state, String gender) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.state = state;
        this.gender = gender;
    }

    public Guru() {
    }
}
