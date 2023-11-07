package com.hj.entity.article;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章分类表
 *
 * @TableName eb_article_category
 */
@TableName(value = "eb_article_category")
@Data
public class ArticleCategory implements Serializable {
    /**
     * 文章分类id
     */
    @TableId
    private Long articleCategoryId;

    /**
     * 父级ID
     */
    private Long pid;

    /**
     * 商户 id
     */
    private Long merId;

    /**
     * 文章分类标题
     */
    private String title;

    /**
     * 文章分类简介
     */
    private String info;

    /**
     * 文章分类图片
     */
    private String image;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 逻辑删除标志 0：删除 1：未删除
     */
    private Integer status;

    /**
     * 是否隐藏 0：隐藏 1：显示
     */
    private Integer isShow;

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
        ArticleCategory other = (ArticleCategory) that;
        return (this.getArticleCategoryId() == null ? other.getArticleCategoryId() == null : this.getArticleCategoryId().equals(other.getArticleCategoryId()))
                && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
                && (this.getMerId() == null ? other.getMerId() == null : this.getMerId().equals(other.getMerId()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
                && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArticleCategoryId() == null) ? 0 : getArticleCategoryId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getMerId() == null) ? 0 : getMerId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleCategoryId=").append(articleCategoryId);
        sb.append(", pid=").append(pid);
        sb.append(", merId=").append(merId);
        sb.append(", title=").append(title);
        sb.append(", info=").append(info);
        sb.append(", image=").append(image);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", isShow=").append(isShow);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}