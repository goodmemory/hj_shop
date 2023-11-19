package com.hj.entity.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户订单表
 *
 * @TableName eb_store_group_order
 */
@TableName(value = "eb_store_group_order")
@Data
public class StoreGroupOrder implements Serializable {
    /**
     *
     */
    @TableId
    private Long groupOrderId;

    /**
     * 订单号
     */
    private String groupOrderNo;

    /**
     * 用户 ID
     */
    private Long uid;

    /**
     * 邮费
     */
    private BigDecimal totalPostage;

    /**
     * 订单总额
     */
    private BigDecimal totalPrice;

    /**
     * 商品数
     */
    private Integer totalNum;

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
     * 优惠金额
     */
    private BigDecimal couponPrice;

    /**
     * 联系人
     */
    private String realName;

    /**
     * 联系电话
     */
    private String userPhone;

    /**
     * 收货地址
     */
    private String userAddress;

    /**
     * 支付金额
     */
    private BigDecimal payPrice;

    /**
     * 支付邮费
     */
    private BigDecimal payPostage;

    /**
     * 成本价
     */
    private BigDecimal cost;

    /**
     * 平台优惠券
     */
    private String couponId;

    /**
     * 赠送优惠券
     */
    private String giveCouponIds;

    /**
     * 是否支付
     */
    private Integer paid;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付方式 0=余额 1=微信 2=小程序 3=h5
     */
    private Integer payType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否提醒
     */
    private Integer isRemind;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 是否为合并支付
     */
    private Integer isCombine;

    /**
     * 邀请人id
     */
    private Long inviterId;

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
        StoreGroupOrder other = (StoreGroupOrder) that;
        return (this.getGroupOrderId() == null ? other.getGroupOrderId() == null : this.getGroupOrderId().equals(other.getGroupOrderId()))
                && (this.getGroupOrderNo() == null ? other.getGroupOrderNo() == null : this.getGroupOrderNo().equals(other.getGroupOrderNo()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getTotalPostage() == null ? other.getTotalPostage() == null : this.getTotalPostage().equals(other.getTotalPostage()))
                && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
                && (this.getTotalNum() == null ? other.getTotalNum() == null : this.getTotalNum().equals(other.getTotalNum()))
                && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
                && (this.getIntegralPrice() == null ? other.getIntegralPrice() == null : this.getIntegralPrice().equals(other.getIntegralPrice()))
                && (this.getGiveIntegral() == null ? other.getGiveIntegral() == null : this.getGiveIntegral().equals(other.getGiveIntegral()))
                && (this.getCouponPrice() == null ? other.getCouponPrice() == null : this.getCouponPrice().equals(other.getCouponPrice()))
                && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
                && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
                && (this.getUserAddress() == null ? other.getUserAddress() == null : this.getUserAddress().equals(other.getUserAddress()))
                && (this.getPayPrice() == null ? other.getPayPrice() == null : this.getPayPrice().equals(other.getPayPrice()))
                && (this.getPayPostage() == null ? other.getPayPostage() == null : this.getPayPostage().equals(other.getPayPostage()))
                && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
                && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
                && (this.getGiveCouponIds() == null ? other.getGiveCouponIds() == null : this.getGiveCouponIds().equals(other.getGiveCouponIds()))
                && (this.getPaid() == null ? other.getPaid() == null : this.getPaid().equals(other.getPaid()))
                && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
                && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
                && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
                && (this.getIsCombine() == null ? other.getIsCombine() == null : this.getIsCombine().equals(other.getIsCombine()))
                && (this.getInviterId() == null ? other.getInviterId() == null : this.getInviterId().equals(other.getInviterId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupOrderId() == null) ? 0 : getGroupOrderId().hashCode());
        result = prime * result + ((getGroupOrderNo() == null) ? 0 : getGroupOrderNo().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getTotalPostage() == null) ? 0 : getTotalPostage().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getTotalNum() == null) ? 0 : getTotalNum().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getIntegralPrice() == null) ? 0 : getIntegralPrice().hashCode());
        result = prime * result + ((getGiveIntegral() == null) ? 0 : getGiveIntegral().hashCode());
        result = prime * result + ((getCouponPrice() == null) ? 0 : getCouponPrice().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getUserAddress() == null) ? 0 : getUserAddress().hashCode());
        result = prime * result + ((getPayPrice() == null) ? 0 : getPayPrice().hashCode());
        result = prime * result + ((getPayPostage() == null) ? 0 : getPayPostage().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getGiveCouponIds() == null) ? 0 : getGiveCouponIds().hashCode());
        result = prime * result + ((getPaid() == null) ? 0 : getPaid().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getIsCombine() == null) ? 0 : getIsCombine().hashCode());
        result = prime * result + ((getInviterId() == null) ? 0 : getInviterId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", groupOrderId=").append(groupOrderId);
        sb.append(", groupOrderNo=").append(groupOrderNo);
        sb.append(", uid=").append(uid);
        sb.append(", totalPostage=").append(totalPostage);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", totalNum=").append(totalNum);
        sb.append(", integral=").append(integral);
        sb.append(", integralPrice=").append(integralPrice);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", couponPrice=").append(couponPrice);
        sb.append(", realName=").append(realName);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", payPrice=").append(payPrice);
        sb.append(", payPostage=").append(payPostage);
        sb.append(", cost=").append(cost);
        sb.append(", couponId=").append(couponId);
        sb.append(", giveCouponIds=").append(giveCouponIds);
        sb.append(", paid=").append(paid);
        sb.append(", payTime=").append(payTime);
        sb.append(", payType=").append(payType);
        sb.append(", createTime=").append(createTime);
        sb.append(", isRemind=").append(isRemind);
        sb.append(", isDel=").append(isDel);
        sb.append(", isCombine=").append(isCombine);
        sb.append(", inviterId=").append(inviterId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}