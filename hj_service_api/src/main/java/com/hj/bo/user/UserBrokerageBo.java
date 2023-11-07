package com.hj.bo.user;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserBrokerageBo {

    private Long userBrokerageId;

    /**
     * 等级
     */
    private Integer brokerageLevel;

    /**
     * vip 名称
     */
    private String brokerageName;

    /**
     * vip 图标
     */
    private String brokerageIcon;

    /**
     * 升级规则
     */
    private String brokerageRule;

    /**
     * 背景图
     */
    private String image;

    /**
     * 所需成长值
     */
    private Integer value;

    /**
     * vip 人数
     */
    private Integer userNum;

    /**
     * 一级佣金
     */
    private BigDecimal extensionOne;

    /**
     * 二级佣金
     */
    private BigDecimal extensionTwo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 默认0分销会员等级，1 免费会员等级
     */
    private Integer type;

    /**
     * 积分倍率
     */
    private BigDecimal integralRatio;


}