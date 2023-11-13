package com.hj.bo.store;

import lombok.Data;

@Data
public class StoreProductBo {

    private Integer page;
    private Integer pageSize;

    /**
     * 商品分类
     */
    private Long cateId;

    /**
     * 商户id
     */
    private Long merId;
    /**
     * 商户标签
     */
    private Long labelId;
    /**
     * 商户类别
     */
    private Integer isTrader;
    /**
     * 商品状态 0：未上架 1：上架 2:平台关闭
     */
    private Integer isShow;

    /**
     * 商品状态
     */
    private Integer status;

    /**
     * 关键字 ：商品名称，产品编号
     */
    private String keyword;

    /**
     * 出售中商品，仓库中商品 ，待审核商品，审核未通过商品
     */
    private Integer type;
}
