package com.hj.vo.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserGroupVo {

    private Long groupId;

    private String groupName;

    private Date createTime;

    private Date updateTime;
}
