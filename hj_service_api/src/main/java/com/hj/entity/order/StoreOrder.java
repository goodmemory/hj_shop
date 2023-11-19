package com.hj.entity.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 *
 * @TableName eb_store_order
 */
@TableName(value = "eb_store_order")
@Data
public class StoreOrder implements Serializable {
    /**
     * 订单ID
     */
    @TableId
    private Long orderId;

    /**
     * 拆单前 id
     */
    private Long mainId;

    /**
     * 订单组 id
     */
    private Long groupOrderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 推荐人id
     */
    private Long spreadUid;

    /**
     * 二级推荐人 id
     */
    private Long topUid;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 详细地址
     */
    private String userAddress;

    /**
     * 购物车id
     */
    private Long cartId;

    /**
     * 订单商品总数
     */
    private Integer totalNum;

    /**
     * 订单总价
     */
    private BigDecimal totalPrice;

    /**
     * 邮费
     */
    private BigDecimal totalPostage;

    /**
     * 实际支付金额
     */
    private BigDecimal payPrice;

    /**
     * 支付邮费
     */
    private BigDecimal payPostage;

    /**
     * 是否为自购
     */
    private Integer isSelfbuy;

    /**
     * 一级佣金
     */
    private BigDecimal extensionOne;

    /**
     * 二级佣金
     */
    private BigDecimal extensionTwo;

    /**
     * 平台手续费
     */
    private BigDecimal commissionRate;

    /**
     * 使用积分数量
     */
    private Integer integral;

    /**
     * 积分抵扣金额
     */
    private BigDecimal integralPrice;

    /**
     * 赠送积分
     */
    private Integer giveIntegral;

    /**
     * 优惠券id
     */
    private String couponId;

    /**
     * 优惠券金额
     */
    private BigDecimal couponPrice;

    /**
     * 平台优惠券金额
     */
    private BigDecimal platformCouponPrice;

    /**
     * 0普通1自提
     */
    private Integer orderType;

    /**
     * 支付状态
     */
    private Integer paid;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付方式 0余额 1微信 2小程序 3 h5  4支付宝 5 支付宝扫码 6 微信扫码
     */
    private Integer payType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 订单状态（0：待发货；1：待收货；2：待评价；3：已完成； 9: 拼团中 10:  待付尾款 11:尾款超时未付 -1：已退款）
     */
    private Integer status;

    /**
     * 发货类型(1:发货 2: 送货 3: 虚拟)
     */
    private String deliveryType;

    /**
     * 0:实物订单 1:虚拟订单
     */
    private Integer isVirtual;

    /**
     * 快递名称/送货人姓名
     */
    private String deliveryName;

    /**
     * 快递单号/手机号
     */
    private String deliveryId;

    /**
     * 备注
     */
    private String mark;

    /**
     * 管理员备注
     */
    private String remark;

    /**
     * 总后台备注
     */
    private String adminMark;

    /**
     * 核销码
     */
    private String verifyCode;

    /**
     * 核销时间/收货时间
     */
    private Date verifyTime;

    /**
     * 核销客服 id
     */
    private Integer verifyServiceId;

    /**
     * 微信支付订单号(分账时有效)
     */
    private String transactionId;

    /**
     * 0:普通 1:秒杀 2:预售 3:助力 4:拼团 10:套餐
     */
    private Integer activityType;

    /**
     * 自定义表单数据
     */
    private String orderExtend;

    /**
     * 商户ID
     */
    private Long merId;

    /**
     * 对账id
     */
    private Integer reconciliationId;

    /**
     * 成本价
     */
    private BigDecimal cost;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 后台是否删除
     */
    private Integer isSystemDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        StoreOrder other = (StoreOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
                && (this.getMainId() == null ? other.getMainId() == null : this.getMainId().equals(other.getMainId()))
                && (this.getGroupOrderId() == null ? other.getGroupOrderId() == null : this.getGroupOrderId().equals(other.getGroupOrderId()))
                && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getSpreadUid() == null ? other.getSpreadUid() == null : this.getSpreadUid().equals(other.getSpreadUid()))
                && (this.getTopUid() == null ? other.getTopUid() == null : this.getTopUid().equals(other.getTopUid()))
                && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
                && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
                && (this.getUserAddress() == null ? other.getUserAddress() == null : this.getUserAddress().equals(other.getUserAddress()))
                && (this.getCartId() == null ? other.getCartId() == null : this.getCartId().equals(other.getCartId()))
                && (this.getTotalNum() == null ? other.getTotalNum() == null : this.getTotalNum().equals(other.getTotalNum()))
                && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
                && (this.getTotalPostage() == null ? other.getTotalPostage() == null : this.getTotalPostage().equals(other.getTotalPostage()))
                && (this.getPayPrice() == null ? other.getPayPrice() == null : this.getPayPrice().equals(other.getPayPrice()))
                && (this.getPayPostage() == null ? other.getPayPostage() == null : this.getPayPostage().equals(other.getPayPostage()))
                && (this.getIsSelfbuy() == null ? other.getIsSelfbuy() == null : this.getIsSelfbuy().equals(other.getIsSelfbuy()))
                && (this.getExtensionOne() == null ? other.getExtensionOne() == null : this.getExtensionOne().equals(other.getExtensionOne()))
                && (this.getExtensionTwo() == null ? other.getExtensionTwo() == null : this.getExtensionTwo().equals(other.getExtensionTwo()))
                && (this.getCommissionRate() == null ? other.getCommissionRate() == null : this.getCommissionRate().equals(other.getCommissionRate()))
                && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
                && (this.getIntegralPrice() == null ? other.getIntegralPrice() == null : this.getIntegralPrice().equals(other.getIntegralPrice()))
                && (this.getGiveIntegral() == null ? other.getGiveIntegral() == null : this.getGiveIntegral().equals(other.getGiveIntegral()))
                && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
                && (this.getCouponPrice() == null ? other.getCouponPrice() == null : this.getCouponPrice().equals(other.getCouponPrice()))
                && (this.getPlatformCouponPrice() == null ? other.getPlatformCouponPrice() == null : this.getPlatformCouponPrice().equals(other.getPlatformCouponPrice()))
                && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
                && (this.getPaid() == null ? other.getPaid() == null : this.getPaid().equals(other.getPaid()))
                && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
                && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getDeliveryType() == null ? other.getDeliveryType() == null : this.getDeliveryType().equals(other.getDeliveryType()))
                && (this.getIsVirtual() == null ? other.getIsVirtual() == null : this.getIsVirtual().equals(other.getIsVirtual()))
                && (this.getDeliveryName() == null ? other.getDeliveryName() == null : this.getDeliveryName().equals(other.getDeliveryName()))
                && (this.getDeliveryId() == null ? other.getDeliveryId() == null : this.getDeliveryId().equals(other.getDeliveryId()))
                && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getAdminMark() == null ? other.getAdminMark() == null : this.getAdminMark().equals(other.getAdminMark()))
                && (this.getVerifyCode() == null ? other.getVerifyCode() == null : this.getVerifyCode().equals(other.getVerifyCode()))
                && (this.getVerifyTime() == null ? other.getVerifyTime() == null : this.getVerifyTime().equals(other.getVerifyTime()))
                && (this.getVerifyServiceId() == null ? other.getVerifyServiceId() == null : this.getVerifyServiceId().equals(other.getVerifyServiceId()))
                && (this.getTransactionId() == null ? other.getTransactionId() == null : this.getTransactionId().equals(other.getTransactionId()))
                && (this.getActivityType() == null ? other.getActivityType() == null : this.getActivityType().equals(other.getActivityType()))
                && (this.getOrderExtend() == null ? other.getOrderExtend() == null : this.getOrderExtend().equals(other.getOrderExtend()))
                && (this.getMerId() == null ? other.getMerId() == null : this.getMerId().equals(other.getMerId()))
                && (this.getReconciliationId() == null ? other.getReconciliationId() == null : this.getReconciliationId().equals(other.getReconciliationId()))
                && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
                && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
                && (this.getIsSystemDel() == null ? other.getIsSystemDel() == null : this.getIsSystemDel().equals(other.getIsSystemDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getMainId() == null) ? 0 : getMainId().hashCode());
        result = prime * result + ((getGroupOrderId() == null) ? 0 : getGroupOrderId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getSpreadUid() == null) ? 0 : getSpreadUid().hashCode());
        result = prime * result + ((getTopUid() == null) ? 0 : getTopUid().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getUserAddress() == null) ? 0 : getUserAddress().hashCode());
        result = prime * result + ((getCartId() == null) ? 0 : getCartId().hashCode());
        result = prime * result + ((getTotalNum() == null) ? 0 : getTotalNum().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getTotalPostage() == null) ? 0 : getTotalPostage().hashCode());
        result = prime * result + ((getPayPrice() == null) ? 0 : getPayPrice().hashCode());
        result = prime * result + ((getPayPostage() == null) ? 0 : getPayPostage().hashCode());
        result = prime * result + ((getIsSelfbuy() == null) ? 0 : getIsSelfbuy().hashCode());
        result = prime * result + ((getExtensionOne() == null) ? 0 : getExtensionOne().hashCode());
        result = prime * result + ((getExtensionTwo() == null) ? 0 : getExtensionTwo().hashCode());
        result = prime * result + ((getCommissionRate() == null) ? 0 : getCommissionRate().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getIntegralPrice() == null) ? 0 : getIntegralPrice().hashCode());
        result = prime * result + ((getGiveIntegral() == null) ? 0 : getGiveIntegral().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getCouponPrice() == null) ? 0 : getCouponPrice().hashCode());
        result = prime * result + ((getPlatformCouponPrice() == null) ? 0 : getPlatformCouponPrice().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getPaid() == null) ? 0 : getPaid().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeliveryType() == null) ? 0 : getDeliveryType().hashCode());
        result = prime * result + ((getIsVirtual() == null) ? 0 : getIsVirtual().hashCode());
        result = prime * result + ((getDeliveryName() == null) ? 0 : getDeliveryName().hashCode());
        result = prime * result + ((getDeliveryId() == null) ? 0 : getDeliveryId().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAdminMark() == null) ? 0 : getAdminMark().hashCode());
        result = prime * result + ((getVerifyCode() == null) ? 0 : getVerifyCode().hashCode());
        result = prime * result + ((getVerifyTime() == null) ? 0 : getVerifyTime().hashCode());
        result = prime * result + ((getVerifyServiceId() == null) ? 0 : getVerifyServiceId().hashCode());
        result = prime * result + ((getTransactionId() == null) ? 0 : getTransactionId().hashCode());
        result = prime * result + ((getActivityType() == null) ? 0 : getActivityType().hashCode());
        result = prime * result + ((getOrderExtend() == null) ? 0 : getOrderExtend().hashCode());
        result = prime * result + ((getMerId() == null) ? 0 : getMerId().hashCode());
        result = prime * result + ((getReconciliationId() == null) ? 0 : getReconciliationId().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getIsSystemDel() == null) ? 0 : getIsSystemDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", mainId=").append(mainId);
        sb.append(", groupOrderId=").append(groupOrderId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", uid=").append(uid);
        sb.append(", spreadUid=").append(spreadUid);
        sb.append(", topUid=").append(topUid);
        sb.append(", realName=").append(realName);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", cartId=").append(cartId);
        sb.append(", totalNum=").append(totalNum);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", totalPostage=").append(totalPostage);
        sb.append(", payPrice=").append(payPrice);
        sb.append(", payPostage=").append(payPostage);
        sb.append(", isSelfbuy=").append(isSelfbuy);
        sb.append(", extensionOne=").append(extensionOne);
        sb.append(", extensionTwo=").append(extensionTwo);
        sb.append(", commissionRate=").append(commissionRate);
        sb.append(", integral=").append(integral);
        sb.append(", integralPrice=").append(integralPrice);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", couponId=").append(couponId);
        sb.append(", couponPrice=").append(couponPrice);
        sb.append(", platformCouponPrice=").append(platformCouponPrice);
        sb.append(", orderType=").append(orderType);
        sb.append(", paid=").append(paid);
        sb.append(", payTime=").append(payTime);
        sb.append(", payType=").append(payType);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", deliveryType=").append(deliveryType);
        sb.append(", isVirtual=").append(isVirtual);
        sb.append(", deliveryName=").append(deliveryName);
        sb.append(", deliveryId=").append(deliveryId);
        sb.append(", mark=").append(mark);
        sb.append(", remark=").append(remark);
        sb.append(", adminMark=").append(adminMark);
        sb.append(", verifyCode=").append(verifyCode);
        sb.append(", verifyTime=").append(verifyTime);
        sb.append(", verifyServiceId=").append(verifyServiceId);
        sb.append(", transactionId=").append(transactionId);
        sb.append(", activityType=").append(activityType);
        sb.append(", orderExtend=").append(orderExtend);
        sb.append(", merId=").append(merId);
        sb.append(", reconciliationId=").append(reconciliationId);
        sb.append(", cost=").append(cost);
        sb.append(", isDel=").append(isDel);
        sb.append(", isSystemDel=").append(isSystemDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}