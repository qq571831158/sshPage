package com.ch.service;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/5/8.
 */
public interface BaseService<T> {

    void save(T entity);

    void update(T entity);

    void delete(Serializable id);

    T getById(Serializable id);

    List<T> getByHQL(String hql, Object... params);
}
