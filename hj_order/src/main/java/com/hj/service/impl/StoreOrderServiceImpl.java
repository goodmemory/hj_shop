package com.hj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.order.StoreOrderBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.order.StoreOrder;
import com.hj.enums.OrderStatusEnum;
import com.hj.enums.PayTypeEnum;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.StoreOrderMapper;
import com.hj.service.StoreOrderService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import com.hj.vo.order.StoreOrderPageVo;
import com.hj.vo.order.StoreOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_order(订单表)】的数据库操作Service实现
 * @createDate 2023-11-14 10:25:36
 */
@Service
public class StoreOrderServiceImpl extends ServiceImpl<StoreOrderMapper, StoreOrder>
        implements StoreOrderService {

    @Autowired
    private StoreOrderMapper storeOrderMapper;

    /**
     * 分页查询订单列表信息
     *
     * @param bo
     * @return
     */
    @Override
    public PagedGridResult getStoreOrderListPage(StoreOrderBo bo) {
        PageHelper.startPage(bo.getPage(), bo.getPageSize());
        if (!StringUtils.isEmpty(bo.getDate()) && bo.getDate().contains("-")) {
            String[] split = bo.getDate().split("-");
            String beginDate = DateUtil.parsFormatDate(split[0]);
            String endDate = DateUtil.parsFormatDate(split[1]);
            bo.setBeginDate(beginDate);
            bo.setEndDate(endDate);
        }
        List<StoreOrderVo> list = storeOrderMapper.getStoreOrderList(bo);
        return PagedGridResult.setterPagedGrid(list, bo.getPage());
    }

    /**
     * 组装页面所有数据返回
     *
     * @param bo
     * @return
     */
    @Override
    public StoreOrderPageVo getReturnStoreOrderList(StoreOrderBo bo) {
        StoreOrderPageVo pageVo = new StoreOrderPageVo();
        pageVo.setStoreOrderPage(getStoreOrderListPage(bo));

        if (!StringUtils.isEmpty(bo.getDate()) && bo.getDate().contains("-")) {
            String[] split = bo.getDate().split("-");
            String beginDate = DateUtil.parsFormatDate(split[0]);
            String endDate = DateUtil.parsFormatDate(split[1]);
            bo.setBeginDate(beginDate);
            bo.setEndDate(endDate);
        }
        List<StoreOrderVo> list = storeOrderMapper.getStoreOrderList(bo);
        //余额支付总金额
        BigDecimal balanceCount = list.stream().filter(storeOrderVo -> storeOrderVo.getPayType() == PayTypeEnum.BALANCE_PAY.getValue())
                .map(StoreOrderVo::getPayPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        pageVo.setBalanceMoney(balanceCount);
        //已支付订单数量
        Integer payCount = list.stream().filter(storeOrderVo -> storeOrderVo.getPaid() == ConstantParams.COMMON_STATUS_1).collect(Collectors.toList()).size();
        pageVo.setPayOrderCount(payCount);
        //实际支付总金额
        BigDecimal payMoneyCount = list.stream().map(StoreOrderVo::getPayPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        pageVo.setRealPayMoney(payMoneyCount);
        //已退款总金额
        BigDecimal refundCount = list.stream().filter(storeOrderVo -> storeOrderVo.getStatus() == OrderStatusEnum.REFUND.getValue())
                .map(StoreOrderVo::getPayPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        pageVo.setRefundMoney(refundCount);
        //微信支付总金额
        BigDecimal wechatPayCount = list.stream().filter(storeOrderVo ->
                (storeOrderVo.getPayType() == PayTypeEnum.WECHAT_PAY.getValue() || storeOrderVo.getPayType() == PayTypeEnum.WECHAT_CODE_PAY.getValue()))
                .map(StoreOrderVo::getPayPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        pageVo.setWeChatPayMoney(wechatPayCount);
        //阿里支付总金额
        BigDecimal aliPayCount = list.stream().filter(storeOrderVo ->
                (storeOrderVo.getPayType() == PayTypeEnum.ALI_PAY.getValue() || storeOrderVo.getPayType() == PayTypeEnum.ALI_CODE_PAY.getValue()))
                .map(StoreOrderVo::getPayPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        pageVo.setAliPayMoney(aliPayCount);
        return pageVo;
    }

    /**
     * 根据订单编号获取订单详情
     *
     * @param orderNo
     * @return
     */
    @Override
    public StoreOrderVo getStoreOrderInfoByOrderNo(String orderNo) {
        if (StringUtils.isEmpty(orderNo)) {
            log.error("StoreOrderServiceImpl===>getStoreOrderInfoByOrderNo:" + ResponseStatusEnum.ORDER_NO_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ORDER_NO_NOT_NULL);
        }
        StoreOrderVo info = storeOrderMapper.getStoreOrderInfoByOrderNo(orderNo);
        if (StringUtils.isEmpty(info)) {
            log.error("StoreOrderServiceImpl===>getStoreOrderInfoByOrderNo:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
        return info;
    }

}




