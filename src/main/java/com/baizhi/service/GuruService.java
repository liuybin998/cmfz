package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {

    //查询
    public List<Guru> findAddGuru(Integer page,Integer rows);
    Integer findcount();

    //删除
    public void removeGuru(String id);

    //添加
    public void addGuru(Guru guru);

    //修改
    public Guru findid(String id);
    public void modifyGuru(Guru guru);
}
