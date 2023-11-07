package com.hj.bo.store;

import lombok.Data;

import java.io.Serializable;

@Data
public class StoreBrandBo implements Serializable {
    /**
     * 商品品牌表ID
     */
    private Long brandId;

    /**
     * 品牌类别id
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
     * 是否显示
     */
    private Integer isShow;

}