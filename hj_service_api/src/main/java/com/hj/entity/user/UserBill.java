package com.hj.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户账单表
 * @TableName eb_user_bill
 */
@TableName(value = "eb_user_bill")
@Data
public class UserBill implements Serializable {
    /**
     * 用户账单id
     */
    @TableId(value = "bill_id")
    private Long billId;

    /**
     * 用户uid
     */
    @TableField(value = "uid")
    private Long uid;

    /**
     * 关联id
     */
    @TableField(value = "link_id")
    private Long linkId;

    /**
     * 0 = 支出 1 = 获得
     */
    @TableField(value = "pm")
    private Integer pm;

    /**
     * 账单标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 明细种类
     */
    @TableField(value = "category")
    private String category;

    /**
     * 明细类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 明细数字
     */
    @TableField(value = "number")
    private BigDecimal number;

    /**
     * 剩余
     */
    @TableField(value = "balance")
    private BigDecimal balance;

    /**
     * 备注
     */
    @TableField(value = "mark")
    private String mark;

    /**
     * 商户 id
     */
    @TableField(value = "mer_id")
    private Long merId;

    /**
     * 添加时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 逻辑删除标识 1：未删除  0：已删除
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}