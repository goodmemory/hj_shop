package com.hj.vo;

import com.hj.entity.FeedbackCategory;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FeedbackCategoryVo {

    private Integer feedbackCategoryId;

    private Integer pid;

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

    /**
     * 子分类
     */
    private List<FeedbackCategory> feedbackCategoryList;

}
