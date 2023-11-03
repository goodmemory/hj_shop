package com.hj.vo.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserGroupVo {

    private Integer groupId;

    private String groupName;

    private Date createTime;

    private Date updateTime;
}
