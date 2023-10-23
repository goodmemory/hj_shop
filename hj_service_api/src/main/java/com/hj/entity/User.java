package com.hj.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * user实体类
 */
@Table(name = "eb_user")
public class User implements Serializable {

    @Id
    private String uId;//用户名

    private String account;

    private String realName;

    public void setAccount(String account) {
        this.account = account;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAccount() {
        return account;
    }

    public String getRealName() {
        return realName;
    }

    public String getuId() {
        return uId;
    }

}
