package com.ch.action;

import com.ch.bean.ibean.users.UserinfoIBean;
import com.ch.model.UserinfoEntity;
import com.ch.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by apple on 2017/5/15.
 */
@ParentPackage(value="struts-default")
@Scope(value="prototype")
    @Controller
public class UserAction extends ActionSupport implements ModelDriven<UserinfoIBean>{
    @Autowired
    IUserService userService;
    private UserinfoIBean userinfoIBean = new UserinfoIBean();
    public UserinfoIBean getModel() {
        return userinfoIBean;
    }


    @Action(value = "/login", results = { @Result(name = "success", location = "main.jsp"),
                                         @Result(name = "fail",location = "login.jsp")})
    public String login() {
        if (userService.doLogin(userinfoIBean) != null) {
            UserinfoEntity userinfoEntity = userService.doLogin(userinfoIBean);
            if (userinfoEntity.getPassword().equals(userinfoIBean.getPassword())) {
                return SUCCESS;
            }
            else {
                return "fail";
            }
        }
        else {
            return "fail";
        }
    }


}
