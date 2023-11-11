package com.hj.vo.store;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StoreProductReplyVo implements Serializable {
    /**
     * 评论ID
     */
    private Long replyId;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 商户 id
     */
    private Long merId;

    /**
     * 订单商品ID
     */
    private Long orderProductId;

    /**
     * 商品 sku
     */
    private String unique;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String storeName;

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
     * 管理员回复内容
     */
    private String merchantReplyContent;

    /**
     * 商家排序
     */
    private Integer sort;

    /**
     * 0未删除1已删除
     */
    private Integer status;

    /**
     * 0未回复1已回复
     */
    private Integer isReply;

    /**
     * 0不是虚拟评价1是虚拟评价
     */
    private Integer isVirtual;

    /**
     * 用户名称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    private Date createTime;

}