package com.hj.bo.store;

import lombok.Data;

import java.io.Serializable;

@Data
public class StoreProductReplyBo implements Serializable {

    private Integer page;

    private Integer pageSize;

    private String keyword;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 用户名称
     */
    private String nickname;

    private Integer isReply;

    /**
     * 0=普通商品
     */
    private Integer productType;

    /**
     * 商品分数
     */
    private Integer productScore;

    /**
     * 服务分数
     */
    private Integer serviceScore;

    /**
     * 物流分数
     */
    private Integer postageScore;

    /**
     * 平均值
     */
    private Double rate;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论图片
     */
    private String pics;


    /**
     * 日期
     */
    private String date;

    private String beginDate;
    private String endDate;
}