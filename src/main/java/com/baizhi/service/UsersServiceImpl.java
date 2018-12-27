package com.baizhi.service;

import com.baizhi.dao.UsersDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAllUser(Integer page, Integer rows) {
        return usersDao.queryAlls(page,rows);
    }
    @Override
    public Integer findcount() {
        return usersDao.findCounts();
    }


    /**
     * 修改用户状态
     */
    @Override
    public User findOneUser(String id) {
        return usersDao.queryid(id);
    }
    @Override
    public void modifyUser(User user) {
        usersDao.update(user);
    }
}
