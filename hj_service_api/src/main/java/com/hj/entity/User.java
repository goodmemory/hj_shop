package com.hj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName eb_user
 */
@TableName(value = "eb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private Integer wechatUserId;

    private String account;

    private String pwd;

    private String realName;

    private Integer sex;

    private Date birthday;

    private String cardId;

    private String mark;

    private String labelId;

    private Integer groupId;

    private String nickname;

    private String avatar;

    private String phone;

    private String addres;

    private Date cancelTime;

    private Date createTime;

    private Date lastTime;

    private String lastIp;

    private BigDecimal nowMoney;

    private BigDecimal brokeragePrice;

    private Integer status;

    private Integer spreadUid;

    private Date spreadTime;

    private Date spreadLimit;

    private Integer brokerageLevel;

    private String userType;

    private Date promoterTime;

    private Integer isPromoter;

    private Integer mainUid;

    private Integer payCount;

    private BigDecimal payPrice;

    private Integer spreadCount;

    private Integer spreadPayCount;

    private BigDecimal spreadPayPrice;

    private Integer integral;

    private Integer memberLevel;

    private Integer memberValue;

    private Integer countStart;

    private Integer countFans;

    private Integer inviterId;

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
        User other = (User) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getWechatUserId() == null ? other.getWechatUserId() == null : this.getWechatUserId().equals(other.getWechatUserId()))
                && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
                && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
                && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
                && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
                && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
                && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
                && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()))
                && (this.getLabelId() == null ? other.getLabelId() == null : this.getLabelId().equals(other.getLabelId()))
                && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
                && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
                && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getAddres() == null ? other.getAddres() == null : this.getAddres().equals(other.getAddres()))
                && (this.getCancelTime() == null ? other.getCancelTime() == null : this.getCancelTime().equals(other.getCancelTime()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastTime() == null ? other.getLastTime() == null : this.getLastTime().equals(other.getLastTime()))
                && (this.getLastIp() == null ? other.getLastIp() == null : this.getLastIp().equals(other.getLastIp()))
                && (this.getNowMoney() == null ? other.getNowMoney() == null : this.getNowMoney().equals(other.getNowMoney()))
                && (this.getBrokeragePrice() == null ? other.getBrokeragePrice() == null : this.getBrokeragePrice().equals(other.getBrokeragePrice()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getSpreadUid() == null ? other.getSpreadUid() == null : this.getSpreadUid().equals(other.getSpreadUid()))
                && (this.getSpreadTime() == null ? other.getSpreadTime() == null : this.getSpreadTime().equals(other.getSpreadTime()))
                && (this.getSpreadLimit() == null ? other.getSpreadLimit() == null : this.getSpreadLimit().equals(other.getSpreadLimit()))
                && (this.getBrokerageLevel() == null ? other.getBrokerageLevel() == null : this.getBrokerageLevel().equals(other.getBrokerageLevel()))
                && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
                && (this.getPromoterTime() == null ? other.getPromoterTime() == null : this.getPromoterTime().equals(other.getPromoterTime()))
                && (this.getIsPromoter() == null ? other.getIsPromoter() == null : this.getIsPromoter().equals(other.getIsPromoter()))
                && (this.getMainUid() == null ? other.getMainUid() == null : this.getMainUid().equals(other.getMainUid()))
                && (this.getPayCount() == null ? other.getPayCount() == null : this.getPayCount().equals(other.getPayCount()))
                && (this.getPayPrice() == null ? other.getPayPrice() == null : this.getPayPrice().equals(other.getPayPrice()))
                && (this.getSpreadCount() == null ? other.getSpreadCount() == null : this.getSpreadCount().equals(other.getSpreadCount()))
                && (this.getSpreadPayCount() == null ? other.getSpreadPayCount() == null : this.getSpreadPayCount().equals(other.getSpreadPayCount()))
                && (this.getSpreadPayPrice() == null ? other.getSpreadPayPrice() == null : this.getSpreadPayPrice().equals(other.getSpreadPayPrice()))
                && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
                && (this.getMemberLevel() == null ? other.getMemberLevel() == null : this.getMemberLevel().equals(other.getMemberLevel()))
                && (this.getMemberValue() == null ? other.getMemberValue() == null : this.getMemberValue().equals(other.getMemberValue()))
                && (this.getCountStart() == null ? other.getCountStart() == null : this.getCountStart().equals(other.getCountStart()))
                && (this.getCountFans() == null ? other.getCountFans() == null : this.getCountFans().equals(other.getCountFans()))
                && (this.getInviterId() == null ? other.getInviterId() == null : this.getInviterId().equals(other.getInviterId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getWechatUserId() == null) ? 0 : getWechatUserId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        result = prime * result + ((getLabelId() == null) ? 0 : getLabelId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAddres() == null) ? 0 : getAddres().hashCode());
        result = prime * result + ((getCancelTime() == null) ? 0 : getCancelTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastTime() == null) ? 0 : getLastTime().hashCode());
        result = prime * result + ((getLastIp() == null) ? 0 : getLastIp().hashCode());
        result = prime * result + ((getNowMoney() == null) ? 0 : getNowMoney().hashCode());
        result = prime * result + ((getBrokeragePrice() == null) ? 0 : getBrokeragePrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSpreadUid() == null) ? 0 : getSpreadUid().hashCode());
        result = prime * result + ((getSpreadTime() == null) ? 0 : getSpreadTime().hashCode());
        result = prime * result + ((getSpreadLimit() == null) ? 0 : getSpreadLimit().hashCode());
        result = prime * result + ((getBrokerageLevel() == null) ? 0 : getBrokerageLevel().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getPromoterTime() == null) ? 0 : getPromoterTime().hashCode());
        result = prime * result + ((getIsPromoter() == null) ? 0 : getIsPromoter().hashCode());
        result = prime * result + ((getMainUid() == null) ? 0 : getMainUid().hashCode());
        result = prime * result + ((getPayCount() == null) ? 0 : getPayCount().hashCode());
        result = prime * result + ((getPayPrice() == null) ? 0 : getPayPrice().hashCode());
        result = prime * result + ((getSpreadCount() == null) ? 0 : getSpreadCount().hashCode());
        result = prime * result + ((getSpreadPayCount() == null) ? 0 : getSpreadPayCount().hashCode());
        result = prime * result + ((getSpreadPayPrice() == null) ? 0 : getSpreadPayPrice().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getMemberLevel() == null) ? 0 : getMemberLevel().hashCode());
        result = prime * result + ((getMemberValue() == null) ? 0 : getMemberValue().hashCode());
        result = prime * result + ((getCountStart() == null) ? 0 : getCountStart().hashCode());
        result = prime * result + ((getCountFans() == null) ? 0 : getCountFans().hashCode());
        result = prime * result + ((getInviterId() == null) ? 0 : getInviterId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", wechatUserId=").append(wechatUserId);
        sb.append(", account=").append(account);
        sb.append(", pwd=").append(pwd);
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", cardId=").append(cardId);
        sb.append(", mark=").append(mark);
        sb.append(", labelId=").append(labelId);
        sb.append(", groupId=").append(groupId);
        sb.append(", nickname=").append(nickname);
        sb.append(", avatar=").append(avatar);
        sb.append(", phone=").append(phone);
        sb.append(", addres=").append(addres);
        sb.append(", cancelTime=").append(cancelTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", nowMoney=").append(nowMoney);
        sb.append(", brokeragePrice=").append(brokeragePrice);
        sb.append(", status=").append(status);
        sb.append(", spreadUid=").append(spreadUid);
        sb.append(", spreadTime=").append(spreadTime);
        sb.append(", spreadLimit=").append(spreadLimit);
        sb.append(", brokerageLevel=").append(brokerageLevel);
        sb.append(", userType=").append(userType);
        sb.append(", promoterTime=").append(promoterTime);
        sb.append(", isPromoter=").append(isPromoter);
        sb.append(", mainUid=").append(mainUid);
        sb.append(", payCount=").append(payCount);
        sb.append(", payPrice=").append(payPrice);
        sb.append(", spreadCount=").append(spreadCount);
        sb.append(", spreadPayCount=").append(spreadPayCount);
        sb.append(", spreadPayPrice=").append(spreadPayPrice);
        sb.append(", integral=").append(integral);
        sb.append(", memberLevel=").append(memberLevel);
        sb.append(", memberValue=").append(memberValue);
        sb.append(", countStart=").append(countStart);
        sb.append(", countFans=").append(countFans);
        sb.append(", inviterId=").append(inviterId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}