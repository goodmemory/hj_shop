package com.hj.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserLabelVo {

    private Integer labelId;

    private String labelName;

    private Integer merId;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private Integer status;
}
