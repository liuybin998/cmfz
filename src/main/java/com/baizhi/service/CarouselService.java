package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselService {
    //查询所有
    List<Carousel> findAllCarousel(Integer page,Integer rows);

    void addCarousel(Carousel carousel);

    Carousel findid(String id);
    void modifyCarousel(Carousel carousel);

    void removeCarousel(String id);

    Integer findcount();

    //用户视角 查看图片
    List<Carousel> findimg();


}
