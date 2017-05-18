package com.ch.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;

/**
 * Created by apple on 2017/5/15.
 */
@Controller
@ParentPackage("struts-default")
@Action(value = "/index", results = { @Result(name = "success", location = "login.jsp")})
public class IndexAction extends ActionSupport{
    public String excute(){
        return SUCCESS;
    }

}
