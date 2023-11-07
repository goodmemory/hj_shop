package com.hj.entity.user;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName eb_feedback_category
 */
@TableName(value = "eb_feedback_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long feedbackCategoryId;

    private Long pid;

    private String cateName;

    private String path;

    private Integer sort;

    private String pic;

    private Integer isShow;

    private Integer level;

    private Integer merId;

    private Date createTime;

    private Date updateTime;

    private Integer status;


}