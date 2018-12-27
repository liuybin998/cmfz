package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    //用户登录
    public User findUser(String phone);

    //用户注册
    public void register(User user);

    //修改资料
    public User findOne(String id);
    public void update(User user);

}
