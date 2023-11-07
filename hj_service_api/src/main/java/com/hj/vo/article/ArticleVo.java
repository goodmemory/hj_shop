package com.hj.vo.article;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleVo {
    /**
     * 文章管理ID
     */
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
     * 浏览次数
     */
    private String visit;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 原文链接
     */
    private String url;

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 商户id
     */
    private Integer merId;

    /**
     * 是否热门(小程序)
     */
    private Integer isHot;

    /**
     * 是否轮播图(小程序)
     */
    private Integer isBanner;

    /**
     * 是否显示 0：隐藏 1：显示
     */
    private Integer isShow;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 微信图文id
     */
    private Integer wechatNewsId;

    /**
     * 删除状态 0：删除 1：未删除
     */
    private Integer status;

    /**
     * 文章分类标题
     */
    private String categoryTitle;

    /**
     * 文章内容
     */
    private String content;
}
