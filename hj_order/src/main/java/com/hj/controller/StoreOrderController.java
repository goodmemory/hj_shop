package com.hj.controller;

import com.hj.bo.order.StoreOrderBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.StoreOrderService;
import com.hj.vo.order.StoreOrderPageVo;
import com.hj.vo.order.StoreOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(tags = "StoreOrderController 订单管理接口模块")
@Slf4j
public class StoreOrderController {

    @Autowired
    private StoreOrderService storeOrderService;

    /**
     * 分页查询订单列表
     *
     * @return
     */
    @PostMapping("/list")
    @ApiOperation("分页查询订单列表")
    public GraceJSONResult getGuaranteeListPage(StoreOrderBo bo) {
        if (bo.getPage() == null) {
            bo.setPage(ConstantParams.COMMON_START_PAGE);
        }
        if (bo.getPageSize() == null) {
            bo.setPageSize(ConstantParams.COMMON_PAGE_SIZE);
        }
        StoreOrderPageVo list = storeOrderService.getReturnStoreOrderList(bo);
        return GraceJSONResult.ok(list);
    }

    /**
     * 根据订单号查询订单详情
     *
     * @return
     */
    @GetMapping("/getOrderInfoByNo")
    @ApiOperation("根据订单号查询订单详情")
    public GraceJSONResult getStoreOrderInfoByOrderNo(@RequestParam(defaultValue = "") String orderNo) {
        StoreOrderVo info = storeOrderService.getStoreOrderInfoByOrderNo(orderNo);
        return GraceJSONResult.ok(info);
    }
}
