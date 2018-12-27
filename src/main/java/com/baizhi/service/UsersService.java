package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UsersService {

    //查询
    public List<User> findAllUser(Integer page, Integer rows);
    Integer findcount();

    //修改用户状态啊
    User findOneUser(String id);
    void modifyUser(User user);
}
