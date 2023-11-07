package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.store.StoreBrandBo;
import com.hj.entity.store.StoreBrand;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreBrandVo;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_brand(商品品牌表)】的数据库操作Service
 * @createDate 2023-11-06 23:14:58
 */
public interface StoreBrandService extends IService<StoreBrand> {

    /**
     * 获取商品分类分页显示
     *
     * @param brandCategoryId
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getStoreBrandListPage(Long brandCategoryId, Integer page, Integer pageSize);

    /**
     * 新增品牌
     *
     * @param bo
     */
    void insertStoreBrand(StoreBrandBo bo);

    /**
     * 修改品牌
     *
     * @param bo
     */
    void updateStoreBrand(StoreBrandBo bo);

    /**
     * 删除品牌
     *
     * @param brandId
     */
    void deleteStoreBrand(Long brandId);

    /**
     * 根据id获取数据
     *
     * @param brandId
     * @return
     */
    StoreBrandVo getStoreBrandById(Long brandId);

    /**
     * 修改是否显示状态
     *
     * @param brandId
     * @param isShow
     */
    void updateIsShow(Long brandId, Integer isShow);
}
