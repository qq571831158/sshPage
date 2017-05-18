package com.ch.dao;


import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/5/8.
 */

public interface BaseDao<T> {

    void save(T entity);

    void update(T entity);

    void delete(Serializable id);

    T findById(Serializable id);

    List<T> findAll();

    List<T> findByHQL(String hql, Object... params);

}
