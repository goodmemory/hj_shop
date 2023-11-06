package com.hj.vo.store;

import lombok.Data;

import java.util.List;

@Data
public class StoreBrandCategoryOneVo {
    /**
     * 品牌分类表ID
     */
    private String storeBrandCategoryId;

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
    List<StoreBrandCategoryOneVo> childList;
}
