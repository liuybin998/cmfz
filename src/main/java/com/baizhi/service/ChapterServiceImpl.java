package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements  ChapterService {

    //注入dao
    @Autowired
    private ChapterDao Chapter;
    //添加章节
    @Override
    public void AddChapter(Chapter chapter){
        chapter.setId(UUID.randomUUID().toString());
        Chapter.insert(chapter);
    }


    /**
     * 删除 章节
     */
    @Override
    public void removeChap(String id) {
        Chapter.delete(id);
    }

    /**
     *
     * 查询此专辑中的有效条数
     *
     */
    @Override
    public Integer findCount(String aid) {
        return Chapter.showCount(aid);
    }

}
