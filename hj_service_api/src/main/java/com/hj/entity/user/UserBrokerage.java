package com.hj.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName eb_user_brokerage
 */
@TableName(value = "eb_user_brokerage")
@Data
public class UserBrokerage implements Serializable {
    /**
     *
     */
    @TableId
    private Long userBrokerageId;

    /**
     * 等级
     */
    private Integer brokerageLevel;

    /**
     * vip 名称
     */
    private String brokerageName;

    /**
     * vip 图标
     */
    private String brokerageIcon;

    /**
     * 升级规则
     */
    private String brokerageRule;

    /**
     * 背景图
     */
    private String image;

    /**
     * 所需成长值
     */
    private Integer value;

    /**
     * vip 人数
     */
    private Integer userNum;

    /**
     * 一级佣金
     */
    private BigDecimal extensionOne;

    /**
     * 二级佣金
     */
    private BigDecimal extensionTwo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 默认0分销会员等级，1 免费会员等级
     */
    private Integer type;

    /**
     * 积分倍率
     */
    private BigDecimal integralRatio;

    /**
     * 逻辑删除标志
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
        UserBrokerage other = (UserBrokerage) that;
        return (this.getUserBrokerageId() == null ? other.getUserBrokerageId() == null : this.getUserBrokerageId().equals(other.getUserBrokerageId()))
                && (this.getBrokerageLevel() == null ? other.getBrokerageLevel() == null : this.getBrokerageLevel().equals(other.getBrokerageLevel()))
                && (this.getBrokerageName() == null ? other.getBrokerageName() == null : this.getBrokerageName().equals(other.getBrokerageName()))
                && (this.getBrokerageIcon() == null ? other.getBrokerageIcon() == null : this.getBrokerageIcon().equals(other.getBrokerageIcon()))
                && (this.getBrokerageRule() == null ? other.getBrokerageRule() == null : this.getBrokerageRule().equals(other.getBrokerageRule()))
                && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
                && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
                && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
                && (this.getExtensionOne() == null ? other.getExtensionOne() == null : this.getExtensionOne().equals(other.getExtensionOne()))
                && (this.getExtensionTwo() == null ? other.getExtensionTwo() == null : this.getExtensionTwo().equals(other.getExtensionTwo()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getIntegralRatio() == null ? other.getIntegralRatio() == null : this.getIntegralRatio().equals(other.getIntegralRatio()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserBrokerageId() == null) ? 0 : getUserBrokerageId().hashCode());
        result = prime * result + ((getBrokerageLevel() == null) ? 0 : getBrokerageLevel().hashCode());
        result = prime * result + ((getBrokerageName() == null) ? 0 : getBrokerageName().hashCode());
        result = prime * result + ((getBrokerageIcon() == null) ? 0 : getBrokerageIcon().hashCode());
        result = prime * result + ((getBrokerageRule() == null) ? 0 : getBrokerageRule().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getExtensionOne() == null) ? 0 : getExtensionOne().hashCode());
        result = prime * result + ((getExtensionTwo() == null) ? 0 : getExtensionTwo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIntegralRatio() == null) ? 0 : getIntegralRatio().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userBrokerageId=").append(userBrokerageId);
        sb.append(", brokerageLevel=").append(brokerageLevel);
        sb.append(", brokerageName=").append(brokerageName);
        sb.append(", brokerageIcon=").append(brokerageIcon);
        sb.append(", brokerageRule=").append(brokerageRule);
        sb.append(", image=").append(image);
        sb.append(", value=").append(value);
        sb.append(", userNum=").append(userNum);
        sb.append(", extensionOne=").append(extensionOne);
        sb.append(", extensionTwo=").append(extensionTwo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", type=").append(type);
        sb.append(", integralRatio=").append(integralRatio);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}