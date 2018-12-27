package com.baizhi.service;

import com.baizhi.entity.Chapter;

public interface ChapterService {

    void  AddChapter(Chapter chapter);


    //刪除章节
    void removeChap(String id);

    //查询数据条数
    Integer findCount(String aid);
}
