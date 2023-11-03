package com.hj.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户账单表
 *
 * @TableName eb_user_bill
 */
@TableName(value = "eb_user_bill")
@Data
public class UserBill implements Serializable {
    /**
     * 用户账单id
     */
    @TableId
    private String billId;

    /**
     * 用户uid
     */
    private String uid;

    /**
     * 关联id
     */
    private String linkId;

    /**
     * 0 = 支出 1 = 获得
     */
    private Integer pm;

    /**
     * 账单标题
     */
    private String title;

    /**
     * 明细种类
     */
    private String category;

    /**
     * 明细类型
     */
    private String type;

    /**
     * 明细数字
     */
    private BigDecimal number;

    /**
     * 剩余
     */
    private BigDecimal balance;

    /**
     * 备注
     */
    private String mark;

    /**
     * 商户 id
     */
    private Integer merId;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 0 = 待确定 1 = 有效 -1 = 无效
     */
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
        UserBill other = (UserBill) that;
        return (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getLinkId() == null ? other.getLinkId() == null : this.getLinkId().equals(other.getLinkId()))
                && (this.getPm() == null ? other.getPm() == null : this.getPm().equals(other.getPm()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
                && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
                && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()))
                && (this.getMerId() == null ? other.getMerId() == null : this.getMerId().equals(other.getMerId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getLinkId() == null) ? 0 : getLinkId().hashCode());
        result = prime * result + ((getPm() == null) ? 0 : getPm().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        result = prime * result + ((getMerId() == null) ? 0 : getMerId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billId=").append(billId);
        sb.append(", uid=").append(uid);
        sb.append(", linkId=").append(linkId);
        sb.append(", pm=").append(pm);
        sb.append(", title=").append(title);
        sb.append(", category=").append(category);
        sb.append(", type=").append(type);
        sb.append(", number=").append(number);
        sb.append(", balance=").append(balance);
        sb.append(", mark=").append(mark);
        sb.append(", merId=").append(merId);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}