package com.hj.entity.store;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName eb_store_product_label
 */
@TableName(value = "eb_store_product_label")
@Data
public class StoreProductLabel implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long productLabelId;

    /**
     * 标签名
     */
    private String labelName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 说明
     */
    private String info;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 商户ID
     */
    private Integer merId;

    /**
     *
     */
    private Date createTime;

    /**
     * 逻辑删除
     */
    private Integer isDel;

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
        StoreProductLabel other = (StoreProductLabel) that;
        return (this.getProductLabelId() == null ? other.getProductLabelId() == null : this.getProductLabelId().equals(other.getProductLabelId()))
                && (this.getLabelName() == null ? other.getLabelName() == null : this.getLabelName().equals(other.getLabelName()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getMerId() == null ? other.getMerId() == null : this.getMerId().equals(other.getMerId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductLabelId() == null) ? 0 : getProductLabelId().hashCode());
        result = prime * result + ((getLabelName() == null) ? 0 : getLabelName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMerId() == null) ? 0 : getMerId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productLabelId=").append(productLabelId);
        sb.append(", labelName=").append(labelName);
        sb.append(", status=").append(status);
        sb.append(", info=").append(info);
        sb.append(", sort=").append(sort);
        sb.append(", type=").append(type);
        sb.append(", merId=").append(merId);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}