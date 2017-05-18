package com.ch.dao.impl;

import com.ch.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */


@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    //在构造方法中初始化泛型class
    public BaseDaoImpl() {

        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
        System.out.println("DAO的真实实现类是：" + this.clazz.getName());
//        this.type = (Class)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    public void save(T entity) {
        this.getSession().save(entity);
    }

    public void update(T entity) {
        this.getSession().update(entity);
    }

    public void delete(Serializable id) {
        this.getSession().delete(this.findById(id));
    }

    public T findById(Serializable id) {
        return (T)this.getSession().get(clazz,id);
    }

    public List<T> findAll() {
        String s = "from"+" "+clazz.toString().substring(19);
        return this.getSession().createQuery(s).list();
    }

    public List<T> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }
}
