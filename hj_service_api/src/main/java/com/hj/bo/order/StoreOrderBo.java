package com.hj.bo.order;

import lombok.Data;

@Data
public class StoreOrderBo {

    private Integer page;
    private Integer pageSize;

    private Long orderId;

    /**
     * 订单状态（0：待发货；1：待收货；2：待评价；3：已完成； 9: 拼团中 10:  待付尾款 11:尾款超时未付 -1：已退款）
     */
    private Integer status;
    /**
     * 时间
     */
    private String date;
    /**
     * 总单单号
     */
    private String groupOrderNo;
    /**
     * 订单号、收货人、联系方式
     */
    private String keyword;
    /**
     * 商户类别
     */
    private Integer isTrader;
    /**
     * 商户id
     */
    private Integer merId;
    /**
     * 用户信息：用户昵称，手机号
     */
    private String username;
    /**
     * 商品名称
     */
    private String storeName;

    /**
     * 0:普通 1:秒杀 2:预售 3:助力 4:拼团 10:套餐
     */
    private Integer activityType;

    private String beginDate;
    private String endDate;

}
