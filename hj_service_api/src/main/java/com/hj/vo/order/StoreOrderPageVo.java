package com.hj.vo.order;

import com.hj.util.PagedGridResult;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StoreOrderPageVo {

    /**
     * 已支付订单数量
     */
    private Integer payOrderCount;
    /**
     * 实际支付总金额
     */
    private BigDecimal realPayMoney;
    /**
     * 已退款金额
     */
    private BigDecimal refundMoney;
    /**
     * 微信支付金额
     */
    private BigDecimal weChatPayMoney;
    /**
     * 支付宝支付金额
     */
    private BigDecimal aliPayMoney;
    /**
     * 余额支付金额
     */
    private BigDecimal balanceMoney;

    /**
     * 分页显示的订单详情
     */
    private PagedGridResult StoreOrderPage;
}
