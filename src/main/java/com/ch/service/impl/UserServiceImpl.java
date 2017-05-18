package com.ch.service.impl;

import com.ch.bean.ibean.users.UserinfoIBean;
import com.ch.dao.IUserDao;
import com.ch.model.UserinfoEntity;
import com.ch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserinfoEntity> implements IUserService{
    @Autowired
    private IUserDao userDao;

    public UserServiceImpl(){
        super.setDao(userDao);
    }

    public List<UserinfoEntity> getAllUsers() {
        return userDao.findAll();
    }

    public UserinfoEntity doLogin(UserinfoIBean userinfoIBean) {
        return userDao.findById(userinfoIBean.getUsername());
    }
}
