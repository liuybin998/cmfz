package com.baizhi.service;

import com.baizhi.dao.DataDao;
import com.baizhi.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DataServiceImpl implements  DataService {

    @Autowired
    private DataDao dataDao;

    @Override
    public List<Data> data() {
        return dataDao.data();
    }
}
