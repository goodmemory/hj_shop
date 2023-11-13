package com.hj.vo.store;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StoreProductVo {
    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商户Id
     */
    private Long merId;

    /**
     * 商品名称
     */
    private String storeName;

    /**
     * 商户名称
     */
    private String merName;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 商户类别 1：自营 0：非自营
     */
    private Integer isTrader;

    /**
     * 最低价格（商品售价）
     */
    private BigDecimal price;

    /**
     * 销量
     */
    private Integer sales;
    /**
     * 商品状态
     */
    private Integer status;
    /**
     * 总库存
     */
    private Integer stock;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 显示/隐藏
     */
    private Integer isUsed;

    /**
     * 添加时间
     */
    private Date createTime;

}
