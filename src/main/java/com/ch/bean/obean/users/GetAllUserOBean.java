package com.ch.bean.obean.users;

import com.ch.model.UserinfoEntity;

import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */
public class GetAllUserOBean {
    private int totalCount;
    private int totalPage;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    private int currentPage;
    private int countInPage;
    private List<Userinfo>userinfoEntities;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCountInPage() {
        return countInPage;
    }

    public void setCountInPage(int countInPage) {
        this.countInPage = countInPage;
    }


    public List<Userinfo> getUserinfoEntities() {
        return userinfoEntities;
    }

    public void setUserinfoEntities(List<Userinfo> userinfoEntities) {
        this.userinfoEntities = userinfoEntities;
    }

    public GetAllUserOBean(int totalCount, int totalPage, int currentPage, int countInPage, List<Userinfo> userinfoEntities) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.countInPage = countInPage;
        this.userinfoEntities = userinfoEntities;
    }
    public GetAllUserOBean(){}
    public class Userinfo{
        private int id;
        private String username;
        private String password;
        private String nickname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
        public Userinfo(){}
    }
}
