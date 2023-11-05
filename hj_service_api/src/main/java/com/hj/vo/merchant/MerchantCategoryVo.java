package com.hj.vo.merchant;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商户分类表
 *
 * @TableName eb_merchant_category
 */
@Data
public class MerchantCategoryVo implements Serializable {
    /**
     * 商户分类 id
     */
    private Integer merchantCategoryId;

    /**
     * 手续费
     */
    private BigDecimal commissionRate;

    /**
     * 商户分类名称
     */
    private String categoryName;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    private Integer status;

}