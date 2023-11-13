package com.hj.entity.store;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 保障服务选项
 *
 * @TableName eb_guarantee
 */
@TableName(value = "eb_guarantee")
@Data
public class Guarantee implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long guaranteeId;

    /**
     * 保障服务名称
     */
    private String guaranteeName;

    /**
     * 保障服务简介
     */
    private String guaranteeInfo;

    /**
     * 0.关闭，1开启
     */
    private Integer status;

    /**
     * 图标
     */
    private String image;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 使用的商户数
     */
    private Integer merCount;

    /**
     * 使用的商品数
     */
    private Integer productCout;

    /**
     *
     */
    private Integer isDel;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

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
        Guarantee other = (Guarantee) that;
        return (this.getGuaranteeId() == null ? other.getGuaranteeId() == null : this.getGuaranteeId().equals(other.getGuaranteeId()))
                && (this.getGuaranteeName() == null ? other.getGuaranteeName() == null : this.getGuaranteeName().equals(other.getGuaranteeName()))
                && (this.getGuaranteeInfo() == null ? other.getGuaranteeInfo() == null : this.getGuaranteeInfo().equals(other.getGuaranteeInfo()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getMerCount() == null ? other.getMerCount() == null : this.getMerCount().equals(other.getMerCount()))
                && (this.getProductCout() == null ? other.getProductCout() == null : this.getProductCout().equals(other.getProductCout()))
                && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuaranteeId() == null) ? 0 : getGuaranteeId().hashCode());
        result = prime * result + ((getGuaranteeName() == null) ? 0 : getGuaranteeName().hashCode());
        result = prime * result + ((getGuaranteeInfo() == null) ? 0 : getGuaranteeInfo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getMerCount() == null) ? 0 : getMerCount().hashCode());
        result = prime * result + ((getProductCout() == null) ? 0 : getProductCout().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guaranteeId=").append(guaranteeId);
        sb.append(", guaranteeName=").append(guaranteeName);
        sb.append(", guaranteeInfo=").append(guaranteeInfo);
        sb.append(", status=").append(status);
        sb.append(", image=").append(image);
        sb.append(", sort=").append(sort);
        sb.append(", merCount=").append(merCount);
        sb.append(", productCout=").append(productCout);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}