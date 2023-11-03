package com.hj.bo.user;

import lombok.Data;

@Data
public class FeedbackCategoryBo {

    private Integer feedbackCategoryId;

    private Integer pid;

    private String cateName;

    private Integer sort;

    private Integer isShow;
}
