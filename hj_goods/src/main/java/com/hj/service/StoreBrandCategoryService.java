package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.store.StoreBrandCategoryBo;
import com.hj.entity.store.StoreBrandCategory;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreBrandCategoryOneVo;
import com.hj.vo.store.StoreBrandCategoryTwoVo;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_brand_category(品牌分类表)】的数据库操作Service
 * @createDate 2023-11-06 16:35:08
 */
public interface StoreBrandCategoryService extends IService<StoreBrandCategory> {

    /**
     * 分页获取品牌数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getStoreBrandCategoryPage(Integer page, Integer pageSize);

    /**
     * 获取所有品牌分类（树形）
     *
     * @return
     */
    List<StoreBrandCategoryOneVo> getStoreBrandCategoryAllList();

    /**
     * 新增品牌分类数据
     *
     * @param bo
     */
    void insertStoreBrandCategory(StoreBrandCategoryBo bo);

    /**
     * 修改品牌分类数据
     *
     * @param bo
     */
    void updateStoreBrandCategory(StoreBrandCategoryBo bo);

    /**
     * 修改是否显示状态
     *
     * @param storeBrandCategoryId
     */
    void updateIsShow(Long storeBrandCategoryId, Integer isShow);

    /**
     * 根据id获取数据
     *
     * @param storeBrandCategoryId
     * @return
     */
    StoreBrandCategoryTwoVo getStoreBrandCategoryById(Long storeBrandCategoryId);

    /**
     * 删除品牌分类数据
     *
     * @param storeBrandCategoryId
     */
    void deleteStoreBrandCategory(Long storeBrandCategoryId);
}
