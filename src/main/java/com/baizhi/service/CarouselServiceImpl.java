package com.baizhi.service;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService{
    //注入dao
    @Autowired
    private CarouselDao carouselDao;

    /**
     * 查询所有轮播图
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> findAllCarousel(Integer page,Integer rows) {
        return carouselDao.queryAlls(page,rows);
    }

    /**
     * 添加轮播图
     */
    @Override
    public void addCarousel(Carousel carousel) {
        carousel.setId(UUID.randomUUID().toString());
        carousel.setTime(new Date());
        carouselDao.insert(carousel);
    }
    
    /**
     * 修改轮播图信息
     * 先查询出轮播图的详细信息后展示
     * 然后调用修改方法接收数据 进行修改
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Carousel findid(String id) {
        return carouselDao.queryid(id);
    }
    @Override
    public void modifyCarousel(Carousel carousel) {
        carouselDao.update(carousel);
    }
    /**
     * 删除轮播图
     */
    @Override
    public void removeCarousel(String id) {
        carouselDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer findcount() {
        return carouselDao.findCounts();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> findimg() {
        return carouselDao.queryimg();
    }
}
