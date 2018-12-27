package com.baizhi.dao;

import com.baizhi.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuruDao extends BaseDao<Guru> {
    public List<Guru> queryAlls( @Param("page")Integer page, @Param("rows") Integer rows);

}
