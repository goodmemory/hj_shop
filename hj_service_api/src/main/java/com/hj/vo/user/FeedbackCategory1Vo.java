package com.hj.vo.user;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FeedbackCategory1Vo {

    private Long feedbackCategoryId;

    private Long pid;

    private String cateName;

    private String path;

    private Integer sort;

    private String pic;

    private Integer isShow;

    private Integer level;

    private Long merId;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    /**
     * 子分类
     */
    private List<FeedbackCategoryVo> feedbackCategoryVoList;

}