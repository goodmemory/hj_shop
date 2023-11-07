package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.store.StoreCategory;
import com.hj.vo.store.StoreCategoryOneVo;
import com.hj.vo.store.StoreCategoryTwoVo;
import com.hj.vo.store.StoreCategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_category(商品分类表)】的数据库操作Mapper
 * @createDate 2023-11-06 11:26:27
 * @Entity com.hj.StoreCategory
 */
public interface StoreCategoryMapper extends BaseMapper<StoreCategory> {

    List<StoreCategoryVo> getStoreCategoryListAll(@Param("pid") Long pid);

    List<StoreCategoryOneVo> getStoreCategoryNotEqLevel2List(@Param("pid") Long pid);

    List<StoreCategoryTwoVo> getStoreCategoryById(@Param("id") Long storeCategoryId);
}




