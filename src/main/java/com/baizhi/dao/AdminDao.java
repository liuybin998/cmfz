package com.baizhi.dao;

import com.baizhi.entity.Admin;

/**
 * 管理员相关的底层实现
 * ====
 *  管理员登录
 *  修改密码
 */
public interface AdminDao extends  BaseDao<Admin>{

    //管理员登录
    Admin queryUserName(String username);

    //自动登录 欢迎用户
    Admin queryAdmin(String username);

}
