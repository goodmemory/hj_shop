package com.hj.bo.user;

import lombok.Data;

import java.util.List;

@Data
public class UserListBo {

    private List<Long> uids;
    private Long groupId;
    private Long labelId;
}
