package com.hj.entity.article;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章管理表
 *
 * @TableName eb_article
 */
@TableName(value = "eb_article")
@Data
public class Article implements Serializable {
    /**
     * 文章管理ID
     */
    @TableId
    private Long articleId;

    /**
     * 分类id
     */
    private Long cid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章图片
     */
    private String imageInput;

    /**
     * 文章简介
     */
    private String synopsis;

    /**
     * 浏览次数
     */
    private String visit;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 原文链接
     */
    private String url;

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 商户id
     */
    private Integer merId;

    /**
     * 是否热门(小程序)
     */
    private Integer isHot;

    /**
     * 是否轮播图(小程序)
     */
    private Integer isBanner;

    /**
     * 是否显示 0：隐藏 1：显示
     */
    private Integer isShow;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 微信图文id
     */
    private Integer wechatNewsId;

    /**
     * 删除状态 0：删除 1：未删除
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
        Article other = (Article) that;
        return (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
                && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
                && (this.getImageInput() == null ? other.getImageInput() == null : this.getImageInput().equals(other.getImageInput()))
                && (this.getSynopsis() == null ? other.getSynopsis() == null : this.getSynopsis().equals(other.getSynopsis()))
                && (this.getVisit() == null ? other.getVisit() == null : this.getVisit().equals(other.getVisit()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
                && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
                && (this.getMerId() == null ? other.getMerId() == null : this.getMerId().equals(other.getMerId()))
                && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
                && (this.getIsBanner() == null ? other.getIsBanner() == null : this.getIsBanner().equals(other.getIsBanner()))
                && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getWechatNewsId() == null ? other.getWechatNewsId() == null : this.getWechatNewsId().equals(other.getWechatNewsId()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getImageInput() == null) ? 0 : getImageInput().hashCode());
        result = prime * result + ((getSynopsis() == null) ? 0 : getSynopsis().hashCode());
        result = prime * result + ((getVisit() == null) ? 0 : getVisit().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getMerId() == null) ? 0 : getMerId().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getIsBanner() == null) ? 0 : getIsBanner().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getWechatNewsId() == null) ? 0 : getWechatNewsId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", cid=").append(cid);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", imageInput=").append(imageInput);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", visit=").append(visit);
        sb.append(", sort=").append(sort);
        sb.append(", url=").append(url);
        sb.append(", adminId=").append(adminId);
        sb.append(", merId=").append(merId);
        sb.append(", isHot=").append(isHot);
        sb.append(", isBanner=").append(isBanner);
        sb.append(", isShow=").append(isShow);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", wechatNewsId=").append(wechatNewsId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}