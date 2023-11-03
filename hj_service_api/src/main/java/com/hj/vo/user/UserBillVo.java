package com.hj.vo.user;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserBillVo {
    /**
     * 用户账单id
     */
    private String billId;

    /**
     * 用户uid
     */
    private String uid;

    /**
     * 关联id
     */
    private String linkId;

    /**
     * 0 = 支出 1 = 获得
     */
    private Integer pm;

    /**
     * 账单标题
     */
    private String title;

    /**
     * 明细种类
     */
    private String category;

    /**
     * 明细类型
     */
    private String type;

    /**
     * 明细数字
     */
    private BigDecimal number;

    /**
     * 剩余
     */
    private BigDecimal balance;

    /**
     * 备注
     */
    private String mark;

    /**
     * 商户 id
     */
    private Integer merId;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 0 = 待确定 1 = 有效 -1 = 无效
     */
    private Integer status;
}