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
 * 商户类型表
 *
 * @TableName eb_merchant_type
 */
@TableName(value = "eb_merchant_type")
@Data
public class MerchantType implements Serializable {
    /**
     * 商户类型 id
     */
    @TableId(type = IdType.AUTO)
    private Long merTypeId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型要求
     */
    private String typeInfo;

    /**
     * 类型说明
     */
    private String description;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 保证金
     */
    private BigDecimal margin;

    /**
     * 是否有保证金（0无，1有）
     */
    private Integer isMargin;

    /**
     * 备注
     */
    private String mark;

    /**
     * 逻辑删除
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
        MerchantType other = (MerchantType) that;
        return (this.getMerTypeId() == null ? other.getMerTypeId() == null : this.getMerTypeId().equals(other.getMerTypeId()))
                && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
                && (this.getTypeInfo() == null ? other.getTypeInfo() == null : this.getTypeInfo().equals(other.getTypeInfo()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getMargin() == null ? other.getMargin() == null : this.getMargin().equals(other.getMargin()))
                && (this.getIsMargin() == null ? other.getIsMargin() == null : this.getIsMargin().equals(other.getIsMargin()))
                && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMerTypeId() == null) ? 0 : getMerTypeId().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getTypeInfo() == null) ? 0 : getTypeInfo().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getMargin() == null) ? 0 : getMargin().hashCode());
        result = prime * result + ((getIsMargin() == null) ? 0 : getIsMargin().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", merTypeId=").append(merTypeId);
        sb.append(", typeName=").append(typeName);
        sb.append(", typeInfo=").append(typeInfo);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", margin=").append(margin);
        sb.append(", isMargin=").append(isMargin);
        sb.append(", mark=").append(mark);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}