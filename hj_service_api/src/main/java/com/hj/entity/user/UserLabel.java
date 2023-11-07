package com.hj.entity.user;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName eb_user_label
 */
@TableName(value = "eb_user_label")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLabel implements Serializable {

    @TableId
    private Long labelId;

    private String labelName;

    private Long merId;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private static final long serialVersionUID = 1L;
}