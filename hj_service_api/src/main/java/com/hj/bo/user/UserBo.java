package com.hj.bo.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserBo {

    private Integer page;

    private Integer pageSize;

    private String uid;

    private String account;

    private String pwd;
    //确认密码
    private String confirmPwd;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 手机号码
     */
    private String phone;

    private String cardId;
    /**
     * 性别
     */
    private Integer sex;

    private Integer status;

    private String userType;

    private Integer isPromoter;

    /**
     * 生日
     */
    private Date birthday;
    /**
     * 用户备注
     */
    private String mark;

    /**
     * 用户标签 id
     */
    private Integer labelId;

    /**
     * 用户分组id
     */
    private Integer groupId;

    /**
     * 用户购买次数
     */
    private Integer payCount;

    //访问情况（首次访问：add_time,最后访问：visit）
    private String userTimeType;

    //访问时间：2023/11/23-2023/12/20
    private String userTime;
}
