package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDao guruDao;

    //查询
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findAddGuru(Integer page,Integer rows) {
        return guruDao.queryAlls(page,rows);
    }
    @Override
    public Integer findcount() {
        return guruDao.findCounts();
    }

    //删除
    @Override
    public void removeGuru(String id) {
        guruDao.delete(id);
    }

    //添加
    @Override
    public void addGuru(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }

    //修改
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Guru findid(String id) {
        return guruDao.queryid(id);
    }
    @Override
    public void modifyGuru(Guru guru) {
        guruDao.update(guru);
    }
}
