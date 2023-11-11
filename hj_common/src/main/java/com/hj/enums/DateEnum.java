package com.hj.enums;

public enum DateEnum {

    TODAY(1, "today", "今天"),
    YESTERDAY(2, "yesterday", "昨天"),
    LATELY7(3, "lately7", "最近7天"),
    LATELY30(4, "lately30", "最近30天"),
    MONTH(5, "month", "本月"),
    YEAR(6, "year", "本年");

    // 类型代码
    private Integer status;
    // 类型标识
    private String tag;
    //中文描述
    private String msg;

    DateEnum(Integer status, String tag, String msg) {
        this.status = status;
        this.tag = tag;
        this.msg = msg;
    }

    public String tag() {
        return tag;
    }
}
