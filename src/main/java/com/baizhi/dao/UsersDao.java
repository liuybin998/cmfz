package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersDao extends BaseDao<User> {
    public List<User> queryAlls(@Param("page")Integer page, @Param("rows") Integer rows);
}
