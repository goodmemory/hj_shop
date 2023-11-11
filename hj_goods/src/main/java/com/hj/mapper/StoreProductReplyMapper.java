package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.bo.store.StoreProductReplyBo;
import com.hj.entity.store.StoreProductReply;
import com.hj.vo.store.StoreProductReplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_product_reply(商品评论表)】的数据库操作Mapper
 * @createDate 2023-11-07 14:19:15
 * @Entity com.hj.StoreProductReply
 */
public interface StoreProductReplyMapper extends BaseMapper<StoreProductReply> {


    /**
     * 根据条件分页查询评价信息
     *
     * @param bo
     * @return
     */
    List<StoreProductReplyVo> getStoreProductReplyListPage(@Param("bo") StoreProductReplyBo bo);

}




