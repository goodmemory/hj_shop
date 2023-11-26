package com.hj.controller;

import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.UserRechargeService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/recharge")
@Api(tags = "UserRechargeController 用户充值记录管理接口模块")
@Slf4j
public class UserRechargeController {

    @Autowired
    private UserRechargeService userRechargeService;

    /**
     * 分页查询订单列表
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("分页查询充值记录列表")
    public GraceJSONResult getUserRechargeListPage(@RequestParam(defaultValue = "") Integer page, @RequestParam(defaultValue = "") Integer pageSize,
                                                   @RequestParam(defaultValue = "") String date, @RequestParam(defaultValue = "") Integer paid,
                                                   @RequestParam(defaultValue = "") String keyword) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = userRechargeService.getUserRechargeListPage(page, pageSize, date, paid, keyword);
        return GraceJSONResult.ok(list);
    }

    /**
     * 金额汇总
     *
     * @param date
     * @param paid
     * @param keyword
     * @return
     */
    @GetMapping("/total")
    @ApiOperation("金额汇总")
    public GraceJSONResult getMoneyAll(@RequestParam(defaultValue = "") String date, @RequestParam(defaultValue = "") Integer paid,
                                       @RequestParam(defaultValue = "") String keyword) {
        Map<String, BigDecimal> map = userRechargeService.getMoneyAll(date, paid, keyword);
        return GraceJSONResult.ok(map);
    }
}
