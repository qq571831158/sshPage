package com.ch.action;

import com.ch.bean.OBeanBase;
import com.ch.bean.obean.users.GetAllUserOBean;
import com.ch.model.UserinfoEntity;
import com.ch.service.IUserService;
import com.ch.utils.OBeanConveter;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by apple on 2017/5/17.
 */
@Controller
@ParentPackage(value = "json-default")
@Scope(value = "prototype")
public class PageAction extends ActionSupport {

    @Autowired
    private IUserService userServiceImpl;
    private List<UserinfoEntity> userList;//查询的list

    private List<UserinfoEntity> resultList;//分页后的list


    private int pageNumber;//请求参数

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    private OBeanBase carrier;//返回json载体

    //返回json载体
    public OBeanBase getCarrier() {
        return carrier;
    }


    @Action(value = "getAllUser", results = {@Result(name = "allUsers", type = "json", params = {"root", "carrier"})})
    public String getAllUsers() {
        carrier = new OBeanBase();
        userList = userServiceImpl.getAllUsers();
        int fromIndex = pageNumber * 4 - 4;
        int toIndex = pageNumber * 4;
        int totalCount = userList.size();
        int totalPage = (int) Math.ceil((double) totalCount / 4);
        if (totalCount == 0) {
            carrier.setInfo("E01", "无记录");
        } else if ((toIndex > totalCount) && (fromIndex < totalCount)) {
            resultList = userList.subList(fromIndex, totalCount);
            carrier.setInfo("S01", "查询成功");
            carrier.setContents(new GetAllUserOBean(totalCount, totalPage, pageNumber, resultList.size(), OBeanConveter.UserEntityToUserReturn(resultList)));
        } else if (toIndex < totalCount) {
            resultList = userList.subList(fromIndex, toIndex);
            carrier.setInfo("S01", "查询成功");
            carrier.setContents(new GetAllUserOBean(totalCount, totalPage, pageNumber, resultList.size(), OBeanConveter.UserEntityToUserReturn(resultList)));
        } else if (fromIndex > totalCount) {
            carrier.setInfo("S02", "记录超过上限");
        }
        return "allUsers";
    }
}
