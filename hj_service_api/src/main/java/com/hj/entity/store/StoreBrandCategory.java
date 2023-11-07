package com.hj.entity.store;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 品牌分类表
 *
 * @TableName eb_store_brand_category
 */
@TableName(value = "eb_store_brand_category")
@Data
public class StoreBrandCategory implements Serializable {
    /**
     * 品牌分类表ID
     */
    @TableId
    private Long storeBrandCategoryId;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 路径
     */
    private String path;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 逻辑删除标识
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
        StoreBrandCategory other = (StoreBrandCategory) that;
        return (this.getStoreBrandCategoryId() == null ? other.getStoreBrandCategoryId() == null : this.getStoreBrandCategoryId().equals(other.getStoreBrandCategoryId()))
                && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
                && (this.getCateName() == null ? other.getCateName() == null : this.getCateName().equals(other.getCateName()))
                && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
                && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStoreBrandCategoryId() == null) ? 0 : getStoreBrandCategoryId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getCateName() == null) ? 0 : getCateName().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", storeBrandCategoryId=").append(storeBrandCategoryId);
        sb.append(", pid=").append(pid);
        sb.append(", cateName=").append(cateName);
        sb.append(", path=").append(path);
        sb.append(", sort=").append(sort);
        sb.append(", isShow=").append(isShow);
        sb.append(", level=").append(level);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}