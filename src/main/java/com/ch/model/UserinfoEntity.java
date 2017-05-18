package com.ch.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by apple on 2017/5/13.
 */
@Entity
@Table(name = "USERINFO", schema = "ssmtest", catalog = "")
public class UserinfoEntity {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String userPicture;
    private Integer islogin;
    private Integer isactive;
    private Timestamp lastModeify;
    private Timestamp createDate;
    private String createIp;

    @Basic
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 50)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "user_picture", nullable = true, length = 100)
    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    @Basic
    @Column(name = "islogin", nullable = true)
    public Integer getIslogin() {
        return islogin;
    }

    public void setIslogin(Integer islogin) {
        this.islogin = islogin;
    }

    @Basic
    @Column(name = "isactive", nullable = true)
    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    @Basic
    @Column(name = "last_modeify", nullable = true)
    public Timestamp getLastModeify() {
        return lastModeify;
    }

    public void setLastModeify(Timestamp lastModeify) {
        this.lastModeify = lastModeify;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "create_ip", nullable = true, length = 50)
    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserinfoEntity that = (UserinfoEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (userPicture != null ? !userPicture.equals(that.userPicture) : that.userPicture != null) return false;
        if (islogin != null ? !islogin.equals(that.islogin) : that.islogin != null) return false;
        if (isactive != null ? !isactive.equals(that.isactive) : that.isactive != null) return false;
        if (lastModeify != null ? !lastModeify.equals(that.lastModeify) : that.lastModeify != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createIp != null ? !createIp.equals(that.createIp) : that.createIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (userPicture != null ? userPicture.hashCode() : 0);
        result = 31 * result + (islogin != null ? islogin.hashCode() : 0);
        result = 31 * result + (isactive != null ? isactive.hashCode() : 0);
        result = 31 * result + (lastModeify != null ? lastModeify.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createIp != null ? createIp.hashCode() : 0);
        return result;
    }
}
