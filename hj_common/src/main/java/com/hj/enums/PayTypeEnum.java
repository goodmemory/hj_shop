package com.hj.enums;

/**
 * 支付方式
 */
public enum PayTypeEnum {
    BALANCE_PAY(0, "余额"),
    WECHAT_PAY(1, "微信"),
    APPLET_PAY(2, "小程序"),
    H5_PAY(3, "H5"),
    ALI_PAY(4, "支付宝"),
    ALI_CODE_PAY(5, "支付宝扫码"),
    WECHAT_CODE_PAY(6, "微信扫码");

    private final Integer payType;
    private final String payTypeName;

    PayTypeEnum(Integer payType, String payTypeName) {
        this.payType = payType;
        this.payTypeName = payTypeName;
    }

    public Integer getValue() {
        return payType;
    }

    public String getName() {
        return payTypeName;
    }
}
