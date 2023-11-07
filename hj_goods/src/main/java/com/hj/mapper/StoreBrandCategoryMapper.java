package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.store.StoreBrandCategory;
import com.hj.vo.store.StoreBrandCategoryOneVo;
import com.hj.vo.store.StoreBrandCategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_brand_category(品牌分类表)】的数据库操作Mapper
 * @createDate 2023-11-06 16:35:08
 * @Entity com.hj.StoreBrandCategory
 */
public interface StoreBrandCategoryMapper extends BaseMapper<StoreBrandCategory> {

    List<StoreBrandCategoryVo> getStoreBrandCategoryPage(@Param("pid") Long pid);

    List<StoreBrandCategoryOneVo> getStoreBrandCategoryAllList(@Param("pid") Long pid);
}




