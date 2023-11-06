package com.hj.vo.store;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StoreBrandCategoryVo implements Serializable {
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
     * 路径
     */
    private String path;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 子分类
     */
    List<StoreBrandCategoryVo> childList;


}