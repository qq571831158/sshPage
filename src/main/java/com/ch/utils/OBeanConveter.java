package com.ch.utils;

import com.ch.bean.obean.users.GetAllUserOBean;
import com.ch.model.UserinfoEntity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */
public class OBeanConveter {
    public static List<GetAllUserOBean.Userinfo> UserEntityToUserReturn(List<UserinfoEntity> list){
        List<GetAllUserOBean.Userinfo> userinfoList = new LinkedList<GetAllUserOBean.Userinfo>() ;
        for (int i=0;i<list.size();i++){
            GetAllUserOBean.Userinfo userinfo = new GetAllUserOBean().new Userinfo();
            userinfo.setId(list.get(i).getId());
            userinfo.setUsername(list.get(i).getUsername());
            userinfo.setPassword(list.get(i).getPassword());
            userinfo.setNickname(list.get(i).getNickname());
            userinfoList.add(userinfo);
        }
        return userinfoList;
    }
}
