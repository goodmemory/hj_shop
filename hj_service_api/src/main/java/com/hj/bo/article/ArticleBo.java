package com.hj.bo.article;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章管理表
 *
 * @TableName eb_article
 */
@Data
public class ArticleBo implements Serializable {
    /**
     * 文章管理ID
     */
    @TableId
    private Long articleId;

    /**
     * 分类id
     */
    private Long cid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章图片
     */
    private String imageInput;

    /**
     * 文章简介
     */
    private String synopsis;

    /**
     * 原文链接
     */
    private String url;

    /**
     * 是否显示 0：隐藏 1：显示
     */
    private Integer isShow;

    /**
     * 添加时间
     */
    private Date createTime;


    /**
     * 删除状态 0：删除 1：未删除
     */
    private Integer status;

    /**
     * 文章内容
     */
    private String content;

}