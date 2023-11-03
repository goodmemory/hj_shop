package com.hj.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName eb_user_group
 */
@TableName(value = "eb_user_group")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "group_id", type = IdType.AUTO)
    private Integer groupId;

    private String groupName;

    private Date createTime;

    private Date updateTime;

    /**
     * 逻辑删除标志 1：未删除  0：已删除
     */
    private Integer status;
}