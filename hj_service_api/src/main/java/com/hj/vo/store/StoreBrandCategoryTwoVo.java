package com.hj.vo.store;

import lombok.Data;

import java.util.List;

@Data
public class StoreBrandCategoryTwoVo {
    /**
     * 品牌分类表ID
     */
    private Long storeBrandCategoryId;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 是否显示
     */
    private Integer isShow;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 子分类
     */
    List<StoreBrandCategoryOneVo> childList;
}
