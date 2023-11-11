package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.store.StoreProductReplyBo;
import com.hj.entity.store.StoreProductReply;
import com.hj.util.PagedGridResult;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_product_reply(商品评论表)】的数据库操作Service
 * @createDate 2023-11-07 14:19:15
 */
public interface StoreProductReplyService extends IService<StoreProductReply> {

    /**
     * 根据条件分页获取评价信息
     *
     * @param bo
     * @return
     */
    PagedGridResult getStoreProductReplyListPage(StoreProductReplyBo bo);

    /**
     * 添加虚拟评价
     *
     * @param bo
     */
    void insertStoreProductReply(StoreProductReplyBo bo);

    /**
     * 删除评论
     *
     * @param replyId
     */
    void deleteStoreProductReply(Long replyId);
}
