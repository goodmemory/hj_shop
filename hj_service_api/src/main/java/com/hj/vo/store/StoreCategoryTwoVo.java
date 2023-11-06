package com.hj.vo.store;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用于显示分类名称和ID
 */
@Data
public class StoreCategoryTwoVo implements Serializable {
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
     * 图标
     */
    private String pic;
    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否发货确认
     */
    private Integer isDeliveryConfirm;
    /**
     * 子分类
     */
    List<StoreCategoryOneVo> storeCategoryList;
}