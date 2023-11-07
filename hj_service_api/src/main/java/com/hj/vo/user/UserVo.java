package com.hj.vo.user;

import com.hj.entity.user.UserGroup;
import com.hj.entity.user.UserLabel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserVo {

    private Long uid;

    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 手机号码
     */
    private String phone;

    private String cardId;

    /**
     * 生日
     */
    private Date birthday;

    private Integer isPromoter;

    private Integer status;

    private List<UserGroup> groupList;

    private List<UserLabel> labelList;
}
