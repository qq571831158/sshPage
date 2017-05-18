package com.ch.service.impl;

import com.ch.dao.BaseDao;
import com.ch.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
    private BaseDao<T> dao;

    public void setDao(BaseDao<T> dao){
        this.dao = dao;
    }


    public T getById(Serializable id) {
        return dao.findById(id);
    }

    public void delete(Serializable id) {
        dao.delete(id);
    }

    public void update(T entity) {
        dao.update(entity);
    }

    public void save(T entity) {
        dao.save(entity);
    }
    public List<T> getByHQL(String hql, Object... params) {
        return dao.findByHQL(hql,params);
    }
}
