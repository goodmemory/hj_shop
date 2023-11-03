package com.hj.enums;

public enum UserEnum {

    USER_HJ(1, "hj", "红旌商城用户"),
    USER_WECHAT(2, "wechat", "微信用户"),
    USER_WECHAT_MINI(3, "routine", "微信小程序用户"),
    USER_H5(4, "h5", "H5用户");

    // 用户类型代码
    private Integer status;
    // 用户类型标识
    private String tag;
    //中文描述
    private String msg;

    UserEnum(Integer status, String tag, String msg) {
        this.status = status;
        this.tag = tag;
        this.msg = msg;
    }

    public String tag() {
        return tag;
    }
}
