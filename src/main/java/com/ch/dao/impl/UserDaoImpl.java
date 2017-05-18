package com.ch.dao.impl;

import com.ch.dao.IUserDao;
import com.ch.model.UserinfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserinfoEntity> implements IUserDao {
    @Override
    public List<UserinfoEntity> findAll() {
        return this.getSession().createQuery("from UserinfoEntity order by id ASC ").list();
    }

}
