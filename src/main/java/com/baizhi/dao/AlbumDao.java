package com.baizhi.dao;

import com.baizhi.entity.Album;

public interface AlbumDao extends BaseDao<Album> {

    void updateCount(String id,Integer count);
}
