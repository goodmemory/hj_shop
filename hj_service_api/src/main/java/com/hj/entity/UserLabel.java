package com.hj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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

    @TableId(value = "label_id", type = IdType.AUTO)
    private Integer labelId;

    private String labelName;

    private Integer merId;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private static final long serialVersionUID = 1L;
}