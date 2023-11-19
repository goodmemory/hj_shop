package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.order.StoreOrderBo;
import com.hj.entity.order.StoreOrder;
import com.hj.util.PagedGridResult;
import com.hj.vo.order.StoreOrderPageVo;
import com.hj.vo.order.StoreOrderVo;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_order(订单表)】的数据库操作Service
 * @createDate 2023-11-14 10:25:36
 */
public interface StoreOrderService extends IService<StoreOrder> {

    /**
     * 分页查询订单列表信息
     *
     * @param bo
     * @return
     */
    PagedGridResult getStoreOrderListPage(StoreOrderBo bo);

    /**
     * 组装页面所有数据返回
     *
     * @param bo
     * @return
     */
    StoreOrderPageVo getReturnStoreOrderList(StoreOrderBo bo);

    /**
     * 根据订单编号获取订单详情
     *
     * @param orderNo
     * @return
     */
    StoreOrderVo getStoreOrderInfoByOrderNo(String orderNo);
}
