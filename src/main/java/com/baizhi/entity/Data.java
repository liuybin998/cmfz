package com.baizhi.entity;

public class Data {
    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Data(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Data() {
    }
}
