package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.bo.store.StoreProductBo;
import com.hj.entity.store.StoreProduct;
import com.hj.vo.store.StoreProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_product(商品表)】的数据库操作Mapper
 * @createDate 2023-11-11 14:54:31
 * @Entity com.hj.StoreProduct
 */
public interface StoreProductMapper extends BaseMapper<StoreProduct> {

    List<StoreProductVo> getStoreProductListPage(@Param("bo") StoreProductBo bo);
}




