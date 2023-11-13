package com.hj.service.merchant;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.merchant.MerchantBo;
import com.hj.entity.merchant.Merchant;
import com.hj.util.PagedGridResult;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_merchant(商户表)】的数据库操作Service
 * @createDate 2023-11-08 14:40:08
 */
public interface MerchantService extends IService<Merchant> {

    /**
     * 获取商户信息分页显示
     *
     * @return
     */
    PagedGridResult getMerchantListPage(MerchantBo bo);

    /**
     * 获取所有商户名称（供商品管理页使用）
     *
     * @return
     */
    List<String> getMerchantName();

    /**
     * 新增商户
     *
     * @param merchant
     */
    void addMerchant(Merchant merchant);
}
