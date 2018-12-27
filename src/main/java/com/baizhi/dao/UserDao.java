package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao extends BaseDao<User> {

    //用户注册BaseDao中insert

    //用户登录
    public User queryUser(String phone);

}
