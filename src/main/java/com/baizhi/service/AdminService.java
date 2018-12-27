package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * 管理员业务层
 */
public interface AdminService {

    public Admin findAdmin(String username);

    public void modifyPassword(Admin admin);

    public Admin findCookieAdmin(String username);

}
