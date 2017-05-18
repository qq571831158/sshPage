package com.ch.service;

import com.ch.bean.ibean.users.UserinfoIBean;
import com.ch.model.UserinfoEntity;

import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */
public interface IUserService extends BaseService<UserinfoEntity> {
     List<UserinfoEntity> getAllUsers();
     UserinfoEntity doLogin(UserinfoIBean userinfoIBean);
}
