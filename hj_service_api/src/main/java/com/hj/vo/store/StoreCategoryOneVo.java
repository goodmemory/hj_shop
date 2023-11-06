package com.hj.vo.store;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用于显示分类名称和ID
 */
@Data
public class StoreCategoryOneVo implements Serializable {
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
     * 子分类
     */
    List<StoreCategoryOneVo> storeCategoryList;
}