package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.entity.store.StoreProductLabel;
import com.hj.util.PagedGridResult;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_product_label】的数据库操作Service
 * @createDate 2023-11-12 14:15:40
 */
public interface StoreProductLabelService extends IService<StoreProductLabel> {

    /**
     * 分页显示商品标签列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getStoreProductLabelListPage(Integer page, Integer pageSize);

    /**
     * 新增商品标签
     *
     * @param label
     */
    void insertStoreProductLabel(StoreProductLabel label);

    /**
     * 修改商品标签
     *
     * @param label
     */
    void updateStoreProductLabel(StoreProductLabel label);

    /**
     * 删除商品标签
     *
     * @param productLabelId
     */
    void deleteStoreProductLabel(Long productLabelId);

    /**
     * 修改商品标签显示状态
     *
     * @param productLabelId
     */
    void updateStatus(Long productLabelId, Integer status);

    /**
     * 根据id获取数据
     *
     * @param productLabelId
     * @return
     */
    StoreProductLabel getStoreProductLabelById(Long productLabelId);
}
