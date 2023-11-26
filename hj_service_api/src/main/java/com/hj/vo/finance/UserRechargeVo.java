package com.hj.vo.finance;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserRechargeVo {

    private Long rechargeId;

    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 充值金额
     */
    private BigDecimal price;

    /**
     * 购买赠送金额
     */
    private BigDecimal givePrice;

    /**
     * 充值类型
     */
    private String rechargeType;

    /**
     * 是否充值
     */
    private Integer paid;
    /**
     * 充值支付时间
     */
    private Date payTime;
    /**
     * 退款金额
     */
    private BigDecimal refundPrice;

    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String avatar;
}
