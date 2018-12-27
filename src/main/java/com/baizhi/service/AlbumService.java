package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findAlbum();

    void addAlbum(Album album);

    //查询专辑的信息
    Album findOneAibum(String id);

    //删除专辑以及所属的所有章节
    void removeAlbum(String id);

    public void updateCount(String id,Integer count);
}
