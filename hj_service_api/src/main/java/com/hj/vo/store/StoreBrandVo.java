package com.hj.vo.store;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StoreBrandVo implements Serializable {
    /**
     * 商品品牌表ID
     */
    private Long brandId;

    /**
     * 父id
     */
    private Long brandCategoryId;

    /**
     * 品牌名称
     */
    private String brandName;

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
     * 品牌类别
     */
    List<StoreBrandCategoryOneVo> categoryOneVoList;
}