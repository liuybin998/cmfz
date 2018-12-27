package com.baizhi.dao;

import java.util.List;

public interface BaseDao<T> {

    public Integer findCounts();

    public void update(T t);

    public List<T> queryAll();

    public T queryid(String id);

    public void delete(String id);

    public void insert(T t);



}
