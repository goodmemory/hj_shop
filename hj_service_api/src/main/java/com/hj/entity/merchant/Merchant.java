package com.hj.entity.merchant;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商户表
 *
 * @TableName eb_merchant
 */
@TableName(value = "eb_merchant")
@Data
public class Merchant implements Serializable {
    /**
     * 商户id
     */
    @TableId(type = IdType.AUTO)
    private Long merId;

    /**
     * 商户分类 id
     */
    private Long categoryId;

    /**
     * 店铺类型 id
     */
    private Long typeId;

    /**
     * 商户名称
     */
    private String merName;

    /**
     * 商户姓名
     */
    private String realName;

    /**
     * 商户手机号
     */
    private String merPhone;

    /**
     * 商户地址
     */
    private String merAddress;

    /**
     * 商户关键字
     */
    private String merKeyword;

    /**
     * 商户头像
     */
    private String merAvatar;

    /**
     * 商户banner图片
     */
    private String merBanner;

    /**
     * 商户店店铺街图片
     */
    private String miniBanner;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 商品描述评分
     */
    private BigDecimal productScore;

    /**
     * 服务评分
     */
    private BigDecimal serviceScore;

    /**
     * 物流评分
     */
    private BigDecimal postageScore;

    /**
     * 商户备注
     */
    private String mark;

    /**
     * 总后台管理员ID
     */
    private Integer regAdminId;

    /**
     *
     */
    private Integer sort;

    /**
     * 商户是否禁用0锁定,1正常
     */
    private Integer status;

    /**
     * 提成比例
     */
    private BigDecimal commissionRate;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 1未删除 0删除
     */
    private Integer isDel;

    /**
     * 添加的产品是否审核 0不审核 1审核
     */
    private Integer isAudit;

    /**
     * 是否审核直播间0不审核1审核
     */
    private Integer isBroRoom;

    /**
     * 是否审核直播商品0不审核1审核
     */
    private Integer isBroGoods;

    /**
     * 是否推荐
     */
    private Integer isBest;

    /**
     * 是否自营 1：自营 0：非自营
     */
    private Integer isTrader;

    /**
     * 商户是否1开启0关闭
     */
    private Integer merState;

    /**
     * 店铺简介
     */
    private String merInfo;

    /**
     * 店铺电话
     */
    private String servicePhone;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 关注总数
     */
    private Integer careCount;

    /**
     * 剩余复制商品次数
     */
    private Integer copyProductNum;

    /**
     * 电子面单剩余次数
     */
    private Integer exportDumpNum;

    /**
     * 商户余额
     */
    private BigDecimal merMoney;

    /**
     * 银行卡转账信息
     */
    private String financialBank;

    /**
     * 微信转账信息
     */
    private String financialWechat;

    /**
     * 支付宝转账信息
     */
    private String financialAlipay;

    /**
     * 默认使用类型
     */
    private Integer financialType;

    /**
     * 微信支付分配的分账号
     */
    private String subMchid;

    /**
     * 配送方式
     */
    private String deliveryWay;

    /**
     * 保证金
     */
    private BigDecimal margin;

    /**
     * 是否有保证金（0无，1有未支付，10已支付，-1 申请退款, -10 拒绝退款）
     */
    private Integer isMargin;

    /**
     * 配送余额
     */
    private BigDecimal deliveryBalance;

    /**
     * 保证金额度
     */
    private BigDecimal otMargin;

    /**
     * 邀请者（员工id）
     */
    private Integer inviterId;

    /**
     * 省id
     */
    private Integer provinceId;

    /**
     * 市id
     */
    private Integer cityId;

    /**
     * 区域id
     */
    private Integer regionId;

    /**
     * 商户banner图片
     */
    private String merImages;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}