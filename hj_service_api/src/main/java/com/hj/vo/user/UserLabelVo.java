package com.hj.vo.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserLabelVo {

    private Long labelId;

    private String labelName;

    private Long merId;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private Integer status;
}
