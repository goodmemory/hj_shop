package com.hj.entity.store;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 *
 * @TableName eb_store_product
 */
@TableName(value = "eb_store_product")
@Data
public class StoreProduct implements Serializable {
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Long productId;

    /**
     * 商户Id
     */
    private Long merId;

    /**
     * 商品名称
     */
    private String storeName;

    /**
     * 商品简介
     */
    private String storeInfo;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 产品条码（一维码）
     */
    private String barCode;

    /**
     * 品牌 id
     */
    private Long brandId;

    /**
     * 商户 状态（0：未上架，1：上架）
     */
    private Integer isShow;

    /**
     * 管理员 状态（0：审核中，1：审核通过 -1: 未通过 -2: 下架）
     */
    private Integer status;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 商铺状态是否 1.正常 0. 非正常
     */
    private Integer merStatus;

    /**
     * 分类id
     */
    private Long cateId;

    /**
     * 单位名
     */
    private String unitName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 总后台排序
     */
    private Integer rank;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 最低价格
     */
    private BigDecimal price;

    /**
     * 成本价
     */
    private BigDecimal cost;

    /**
     * 原价
     */
    private BigDecimal otPrice;

    /**
     * 总库存
     */
    private Integer stock;

    /**
     * 是否热卖
     */
    private Integer isHot;

    /**
     * 促销单品
     */
    private Integer isBenefit;

    /**
     * 是否精品
     */
    private Integer isBest;

    /**
     * 是否新品
     */
    private Integer isNew;

    /**
     * 是否优品推荐
     */
    private Integer isGood;

    /**
     * 0.普通商品 1.秒杀商品,2.预售商品，3.助力商品，4.拼团商品
     */
    private Integer productType;

    /**
     * 虚拟销量
     */
    private Integer ficti;

    /**
     * 浏览量
     */
    private Integer browse;

    /**
     * 产品二维码地址(用户小程序海报)
     */
    private String codePath;

    /**
     * 主图视频链接
     */
    private String videoLink;

    /**
     * 运费模板ID
     */
    private Integer tempId;

    /**
     * 规格 0单 1多
     */
    private Integer specType;

    /**
     * 佣金比例 0.系统，1.自定义
     */
    private Integer extensionType;

    /**
     * 审核拒绝理由
     */
    private String refusal;

    /**
     * 评价分数
     */
    private BigDecimal rate;

    /**
     * 评论数
     */
    private Integer replyCount;

    /**
     * 赠送优惠券
     */
    private String giveCouponIds;

    /**
     * 是否为礼包
     */
    private Integer isGiftBag;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 收藏数
     */
    private Integer careCount;

    /**
     * 显示/隐藏
     */
    private Integer isUsed;

    /**
     * 原商品ID
     */
    private Integer oldProductId;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 平台图片
     */
    private String platformImage;

    /**
     * 轮播图
     */
    private String sliderImage;

    /**
     * 保障服务模板
     */
    private Integer guaranteeTemplateId;

    /**
     * 订单单次购买数量最大限制
     */
    private Integer onceCount;

    /**
     * 积分抵扣比例
     */
    private Integer integralRate;

    /**
     * 使用积分抵扣总数
     */
    private Integer integralTotal;

    /**
     * 使用积分抵扣金额总数
     */
    private BigDecimal integralPriceTotal;

    /**
     * 标签id
     */
    private Long labelId;

    /**
     * 1.仅到店自提2快递计价配送3全国包邮
     */
    private String deliveryWay;

    /**
     * 全国包邮
     */
    private Integer deliveryFree;

    /**
     * 0.实体商品，1.虚拟商品
     */
    private Integer type;

    /**
     * 扩展信息
     */
    private String extend;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}