package com.hj.bo.store;

import lombok.Data;

import java.io.Serializable;

@Data
public class StoreBrandCategoryBo implements Serializable {
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
     * 排序
     */
    private Integer sort;

    /**
     * 是否显示
     */
    private Integer isShow;

}