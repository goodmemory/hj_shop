package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.bo.order.StoreOrderBo;
import com.hj.entity.order.StoreOrder;
import com.hj.vo.order.StoreOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_order(订单表)】的数据库操作Mapper
 * @createDate 2023-11-14 10:25:36
 * @Entity com.hj.StoreOrder
 */
public interface StoreOrderMapper extends BaseMapper<StoreOrder> {

    List<StoreOrderVo> getStoreOrderList(@Param("bo") StoreOrderBo bo);


    StoreOrderVo getStoreOrderInfoByOrderNo(String orderNo);
}




