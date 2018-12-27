package com.baizhi.dao;

import com.baizhi.entity.Chapter;

public interface ChapterDao extends BaseDao<Chapter> {
    void deletes(String id);

    Integer showCount(String aid);

}
