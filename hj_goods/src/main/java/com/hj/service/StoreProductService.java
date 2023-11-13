package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.store.StoreProductBo;
import com.hj.entity.store.StoreProduct;
import com.hj.util.PagedGridResult;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_product(商品表)】的数据库操作Service
 * @createDate 2023-11-11 14:54:31
 */
public interface StoreProductService extends IService<StoreProduct> {

    /**
     * 分页查询商品信息
     *
     * @param bo
     * @return
     */
    PagedGridResult getStoreProductListPage(StoreProductBo bo);

    /**
     * 修改是否显示状态
     *
     * @param productId
     * @param isUsed
     */
    void updateIsUsed(Long productId, Integer isUsed);

    /**
     * 编辑标签
     *
     * @param labelId
     */
    void updateLabel(Long productId, Long labelId);
}
