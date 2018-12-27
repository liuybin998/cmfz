package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl   implements AlbumService {
    //注入dao
    @Autowired
    private AlbumDao albumDao;
    //注入dao
    @Autowired
    private ChapterDao chapterDao;

    /**、
     * 查询所有专辑信息
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAlbum() {
        return albumDao.queryAll();
    }

    /**
     * 添加专辑
     */
    @Override
    public void addAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        /*强转为String类型
        String  date =String.valueOf(new Date());*/
        album.setCreateDate(new Date());
        albumDao.insert(album);
    }

    /**
     * 查询专辑详细信息
     */
    @Override
    public Album findOneAibum(String id) {
        return albumDao.queryid(id);
    }

    /**
     * 删除专辑以及此专辑下的所有章节
     */
    @Override
    public void removeAlbum(String id) {
        chapterDao.deletes(id);//删除文章
        albumDao.delete(id);//删除专辑
    }
    /**
     * 修改专辑中的集数
     */
    @Override
    public void updateCount(String id, Integer count) {
        albumDao.updateCount(id,count);
    }




}
