package com.hj.bo.user;

import lombok.Data;

import java.util.List;

@Data
public class UserListBo {

    private List<String> uids;
    private Integer groupId;
    private Integer labelId;
}
