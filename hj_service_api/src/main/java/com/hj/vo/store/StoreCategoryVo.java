package com.hj.vo.store;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品分类表
 *
 * @TableName eb_store_category
 */
@Data
public class StoreCategoryVo implements Serializable {
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
     * 路径
     */
    private String path;

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
     * 等级
     */
    private Integer level;

    /**
     * 商户id
     */
    private Integer merId;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否推荐
     */
    private Integer isHot;

    /**
     * 是否发货确认
     */
    private Integer isDeliveryConfirm;

    /**
     * 逻辑删除
     */
    private Integer status;

    /**
     * 子分类
     */
    List<StoreCategoryVo> storeCategoryList;
}