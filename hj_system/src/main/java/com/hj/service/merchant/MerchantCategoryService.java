package com.hj.service.merchant;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.entity.merchant.MerchantCategory;
import com.hj.util.PagedGridResult;
import com.hj.vo.merchant.MerchantCategoryVo;

import java.math.BigDecimal;

/**
 * @author mayaoqi
 * @description 针对表【eb_merchant_category(商户分类表)】的数据库操作Service
 * @createDate 2023-11-04 14:55:32
 */
public interface MerchantCategoryService extends IService<MerchantCategory> {
    /**
     * 获取所有商户分类分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getMerchantCategoryList(Integer page, Integer pageSize);

    /**
     * 添加商户分类信息
     *
     * @param categoryName
     * @param commissionRate
     */
    void insertMerchantCategory(String categoryName, BigDecimal commissionRate);

    /**
     * 根据id获取商户分类信息
     *
     * @param merchantCategoryId
     * @return
     */
    MerchantCategoryVo getMerchantCategoryById(Integer merchantCategoryId);

    /**
     * 修改商户分类信息
     *
     * @param categoryName
     * @param commissionRate
     */
    void updateMerchantCategory(Integer merchantCategoryId, String categoryName, BigDecimal commissionRate);

    /**
     * 删除商户分类信息
     *
     * @param merchantCategoryId
     */
    void deleteMerchantCategory(Integer merchantCategoryId);
}
