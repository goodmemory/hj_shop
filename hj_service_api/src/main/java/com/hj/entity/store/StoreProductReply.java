package com.hj.entity.store;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品评论表
 *
 * @TableName eb_store_product_reply
 */
@TableName(value = "eb_store_product_reply")
@Data
public class StoreProductReply implements Serializable {
    /**
     * 评论ID
     */
    @TableId(type = IdType.AUTO)
    private Long replyId;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 商户 id
     */
    private Long merId;

    /**
     * 订单商品ID
     */
    private Long orderProductId;

    /**
     * 商品 sku
     */
    private String unique;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 0=普通商品
     */
    private Integer productType;

    /**
     * 商品分数
     */
    private Integer productScore;

    /**
     * 服务分数
     */
    private Integer serviceScore;

    /**
     * 物流分数
     */
    private Integer postageScore;

    /**
     * 平均值
     */
    private Double rate;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论图片
     */
    private String pics;

    /**
     * 评论时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 管理员回复内容
     */
    private String merchantReplyContent;

    /**
     * 管理员回复时间
     */
    private Date merchantReplyTime;

    /**
     * 商家排序
     */
    private Integer sort;

    /**
     * 0未删除1已删除
     */
    private Integer status;

    /**
     * 0未回复1已回复
     */
    private Integer isReply;

    /**
     * 0不是虚拟评价1是虚拟评价
     */
    private Integer isVirtual;

    /**
     * 用户名称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

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
        StoreProductReply other = (StoreProductReply) that;
        return (this.getReplyId() == null ? other.getReplyId() == null : this.getReplyId().equals(other.getReplyId()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getMerId() == null ? other.getMerId() == null : this.getMerId().equals(other.getMerId()))
                && (this.getOrderProductId() == null ? other.getOrderProductId() == null : this.getOrderProductId().equals(other.getOrderProductId()))
                && (this.getUnique() == null ? other.getUnique() == null : this.getUnique().equals(other.getUnique()))
                && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
                && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
                && (this.getProductScore() == null ? other.getProductScore() == null : this.getProductScore().equals(other.getProductScore()))
                && (this.getServiceScore() == null ? other.getServiceScore() == null : this.getServiceScore().equals(other.getServiceScore()))
                && (this.getPostageScore() == null ? other.getPostageScore() == null : this.getPostageScore().equals(other.getPostageScore()))
                && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
                && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
                && (this.getPics() == null ? other.getPics() == null : this.getPics().equals(other.getPics()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getMerchantReplyContent() == null ? other.getMerchantReplyContent() == null : this.getMerchantReplyContent().equals(other.getMerchantReplyContent()))
                && (this.getMerchantReplyTime() == null ? other.getMerchantReplyTime() == null : this.getMerchantReplyTime().equals(other.getMerchantReplyTime()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getIsReply() == null ? other.getIsReply() == null : this.getIsReply().equals(other.getIsReply()))
                && (this.getIsVirtual() == null ? other.getIsVirtual() == null : this.getIsVirtual().equals(other.getIsVirtual()))
                && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
                && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReplyId() == null) ? 0 : getReplyId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getMerId() == null) ? 0 : getMerId().hashCode());
        result = prime * result + ((getOrderProductId() == null) ? 0 : getOrderProductId().hashCode());
        result = prime * result + ((getUnique() == null) ? 0 : getUnique().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getProductScore() == null) ? 0 : getProductScore().hashCode());
        result = prime * result + ((getServiceScore() == null) ? 0 : getServiceScore().hashCode());
        result = prime * result + ((getPostageScore() == null) ? 0 : getPostageScore().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getPics() == null) ? 0 : getPics().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getMerchantReplyContent() == null) ? 0 : getMerchantReplyContent().hashCode());
        result = prime * result + ((getMerchantReplyTime() == null) ? 0 : getMerchantReplyTime().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsReply() == null) ? 0 : getIsReply().hashCode());
        result = prime * result + ((getIsVirtual() == null) ? 0 : getIsVirtual().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", replyId=").append(replyId);
        sb.append(", uid=").append(uid);
        sb.append(", merId=").append(merId);
        sb.append(", orderProductId=").append(orderProductId);
        sb.append(", unique=").append(unique);
        sb.append(", productId=").append(productId);
        sb.append(", productType=").append(productType);
        sb.append(", productScore=").append(productScore);
        sb.append(", serviceScore=").append(serviceScore);
        sb.append(", postageScore=").append(postageScore);
        sb.append(", rate=").append(rate);
        sb.append(", comment=").append(comment);
        sb.append(", pics=").append(pics);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", merchantReplyContent=").append(merchantReplyContent);
        sb.append(", merchantReplyTime=").append(merchantReplyTime);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", isReply=").append(isReply);
        sb.append(", isVirtual=").append(isVirtual);
        sb.append(", nickname=").append(nickname);
        sb.append(", avatar=").append(avatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}