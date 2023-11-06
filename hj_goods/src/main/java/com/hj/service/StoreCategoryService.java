package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.store.StoreCategoryBo;
import com.hj.entity.store.StoreCategory;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreCategoryOneVo;
import com.hj.vo.store.StoreCategoryTwoVo;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_category(商品分类表)】的数据库操作Service
 * @createDate 2023-11-06 11:26:27
 */
public interface StoreCategoryService extends IService<StoreCategory> {

    /**
     * 获取商品分类分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getStoreCategoryListPage(Integer page, Integer pageSize);

    /**
     * 获取所有商品分类
     *
     * @return
     */
    List<StoreCategoryOneVo> getStoreCategoryList();

    /**
     * 新增分类
     */
    void insertStoreCategory(StoreCategoryBo bo);

    /**
     * 修改分类
     */
    void updateStoreCategory(StoreCategoryBo bo);


    /**
     * 修改是否显示 1，是否推荐 2 ，发货前确认 3
     */
    void updateCategoryStatus(Integer type, String storeCategoryId, Integer params);

    /**
     * 删除
     *
     * @param storeCategoryId
     */
    void deleteStoreCategory(String storeCategoryId);

    /**
     * 根据id获取商品信息
     *
     * @param storeCategoryId
     * @return
     */
    StoreCategoryTwoVo getStoreCategoryById(String storeCategoryId);
}
