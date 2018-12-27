package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    //注入dao
    @Autowired
    private UserDao userDao;

    /**
     * 用户登录
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findUser(String phone) {
        return userDao.queryUser(phone);
    }

    /**
     * 用户注册
     */
    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setSalt("??");
        user.setStatus("正常");
        user.setRegistertime(new Date());
        userDao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findOne(String id) {
        return userDao.queryid(id);
    }
    @Override
    public void update(User user) {
        userDao.update(user);
    }

}
