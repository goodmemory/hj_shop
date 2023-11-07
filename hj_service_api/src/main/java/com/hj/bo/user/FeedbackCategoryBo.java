package com.hj.bo.user;

import lombok.Data;

@Data
public class FeedbackCategoryBo {

    private Long feedbackCategoryId;

    private Long pid;

    private String cateName;

    private Integer sort;

    private Integer isShow;
}
