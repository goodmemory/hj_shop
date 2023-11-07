package com.hj.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户反馈表
 *
 * @TableName eb_feedback
 */
@TableName(value = "eb_feedback")
@Data
public class Feedback implements Serializable {
    /**
     *
     */
    @TableId
    private Long feedbackId;

    /**
     *
     */
    private Long uid;

    /**
     *
     */
    private String type;

    /**
     *
     */
    private String content;

    /**
     * 反馈图片
     */
    private String images;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 联系方式
     */
    private String contact;

    /**
     *
     */
    private Date createTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 回复，最终给用户的回复内容
     */
    private String reply;

    /**
     * 备注，后台人员自己查看用
     */
    private String remake;

    /**
     * 逻辑删除 1:未删除，0：已删除
     */
    private Integer isDel;

    /**
     * 回复时间
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
        Feedback other = (Feedback) that;
        return (this.getFeedbackId() == null ? other.getFeedbackId() == null : this.getFeedbackId().equals(other.getFeedbackId()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
                && (this.getImages() == null ? other.getImages() == null : this.getImages().equals(other.getImages()))
                && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
                && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getReply() == null ? other.getReply() == null : this.getReply().equals(other.getReply()))
                && (this.getRemake() == null ? other.getRemake() == null : this.getRemake().equals(other.getRemake()))
                && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFeedbackId() == null) ? 0 : getFeedbackId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getImages() == null) ? 0 : getImages().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReply() == null) ? 0 : getReply().hashCode());
        result = prime * result + ((getRemake() == null) ? 0 : getRemake().hashCode());
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
        sb.append(", feedbackId=").append(feedbackId);
        sb.append(", uid=").append(uid);
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", images=").append(images);
        sb.append(", realname=").append(realname);
        sb.append(", contact=").append(contact);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", reply=").append(reply);
        sb.append(", remake=").append(remake);
        sb.append(", isDel=").append(isDel);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}