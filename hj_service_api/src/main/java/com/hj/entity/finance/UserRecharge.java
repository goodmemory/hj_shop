package com.hj.entity.finance;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户充值表
 *
 * @TableName eb_user_recharge
 */
@TableName(value = "eb_user_recharge")
@Data
public class UserRecharge implements Serializable {
    /**
     *
     */
    @TableId
    private Long rechargeId;

    /**
     * 充值用户UID
     */
    private Long uid;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 充值金额
     */
    private BigDecimal price;

    /**
     * 购买赠送金额
     */
    private BigDecimal givePrice;

    /**
     * 充值类型
     */
    private String rechargeType;

    /**
     * 是否充值
     */
    private Integer paid;

    /**
     * 充值支付时间
     */
    private Date payTime;

    /**
     * 充值时间
     */
    private Date createTime;

    /**
     * 退款金额
     */
    private BigDecimal refundPrice;

    @TableLogic
    private Integer status;

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
        UserRecharge other = (UserRecharge) that;
        return (this.getRechargeId() == null ? other.getRechargeId() == null : this.getRechargeId().equals(other.getRechargeId()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
                && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
                && (this.getGivePrice() == null ? other.getGivePrice() == null : this.getGivePrice().equals(other.getGivePrice()))
                && (this.getRechargeType() == null ? other.getRechargeType() == null : this.getRechargeType().equals(other.getRechargeType()))
                && (this.getPaid() == null ? other.getPaid() == null : this.getPaid().equals(other.getPaid()))
                && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getRefundPrice() == null ? other.getRefundPrice() == null : this.getRefundPrice().equals(other.getRefundPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRechargeId() == null) ? 0 : getRechargeId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getGivePrice() == null) ? 0 : getGivePrice().hashCode());
        result = prime * result + ((getRechargeType() == null) ? 0 : getRechargeType().hashCode());
        result = prime * result + ((getPaid() == null) ? 0 : getPaid().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRefundPrice() == null) ? 0 : getRefundPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rechargeId=").append(rechargeId);
        sb.append(", uid=").append(uid);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", price=").append(price);
        sb.append(", givePrice=").append(givePrice);
        sb.append(", rechargeType=").append(rechargeType);
        sb.append(", paid=").append(paid);
        sb.append(", payTime=").append(payTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", refundPrice=").append(refundPrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}