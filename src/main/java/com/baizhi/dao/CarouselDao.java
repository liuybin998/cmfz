package com.baizhi.dao;

import com.baizhi.entity.Carousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarouselDao extends BaseDao<Carousel>{
    public List<Carousel> queryAlls(@Param("page")Integer page, @Param("rows") Integer rows);


    public List<Carousel> queryimg();
}
