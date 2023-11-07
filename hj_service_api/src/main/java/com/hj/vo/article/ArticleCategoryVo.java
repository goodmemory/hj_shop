package com.hj.vo.article;

import lombok.Data;

@Data
public class ArticleCategoryVo {

    private Long articleCategoryId;

    /**
     * 文章分类标题
     */
    private String title;

    /**
     * 文章分类简介
     */
    private String info;

    /**
     * 文章分类图片
     */
    private String image;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否隐藏 0：隐藏 1：显示
     */
    private Integer isShow;
}
