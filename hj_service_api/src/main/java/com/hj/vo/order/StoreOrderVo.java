package com.hj.vo.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StoreOrderVo {

    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 0普通1自提
     */
    private Integer orderType;
    /**
     * 活动类型
     */
    private Integer activityType;
    /**
     * 收货人
     */
    private String realName;
    /**
     * 商户名称
     */
    private String merName;
    /**
     * 商户类别
     */
    private Integer isTrader;
    /**
     * 商品信息
     */
    private String storeName;
    /**
     * 实际支付
     */
    private BigDecimal payPrice;
    /**
     * 一级订单佣金
     */
    private BigDecimal extensionOne;
    /**
     * 二级订单佣金
     */
    private BigDecimal extensionTwo;
    /**
     * 支付类型
     */
    private Integer payType;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否支付 0：未支付 1：已支付
     */
    private Integer paid;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 联系电话
     */
    private String userPhone;
    /**
     * 收货地址
     */
    private String userAddress;

    /**
     * 商品总数
     */
    private Integer totalNum;
    /**
     * 订单总价
     */
    private BigDecimal totalPrice;
    /**
     * 支付邮费
     */
    private BigDecimal payPostage;
    /**
     * 商家优惠券金额
     */
    private BigDecimal couponPrice;
    /**
     * 平台优惠券金额
     */
    private BigDecimal platformCouponPrice;
    //todo 支付手续费

    /**
     * 积分抵扣金额
     */
    private BigDecimal integralPrice;
    /**
     * 赠送积分
     */
    private Integer giveIntegral;
    /**
     * 商家备注
     */
    private String mark;

}
