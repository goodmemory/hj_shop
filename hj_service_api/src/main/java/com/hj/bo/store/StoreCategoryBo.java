package com.hj.bo.store;

import lombok.Data;

@Data
public class StoreCategoryBo {
    /**
     * 商品分类表ID
     */
    private String storeCategoryId;

    /**
     * 父id
     */
    private String pid;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标
     */
    private String pic;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 是否发货确认
     */
    private Integer isDeliveryConfirm;

}
