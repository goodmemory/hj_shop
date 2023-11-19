package com.hj.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum OrderStatusEnum implements IEnum<Integer> {

    //  0：待发货；1：待收货；2：待评价；3：已完成； 4 拼团中 5:  待付尾款 6:尾款超时未付 -1：已退款
    WAITING_SHIPMENT(0, "待发货"),
    WAITING_RECEIPT(1, "待收货"),
    WAITING_EVALUATION(2, "待评价"),
    COMPLETED(3, "已完成"),
    IN_GROUP(4, "拼团中"),
    WAITING_FINAL_PAY(5, "待付尾款"),
    FINAL_PAY_TIMEOUT(6, "尾款超时未付"),
    REFUND(-1, "已退款");

    private final Integer value;
    private final String name;

    OrderStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
