package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    /**
     * 管理员登录方法
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findAdmin(String username) {
        return adminDao.queryUserName(username);
    }

    /**
     * 管理员修改密码
     */
    @Override
    public void modifyPassword(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public Admin findCookieAdmin(String username) {
        return adminDao.queryAdmin(username);
    }
}
