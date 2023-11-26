package com.hj.controller;

import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.UserBillService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/userBill")
@Api(tags = "UserBillController 用户资金记录管理接口模块")
@Slf4j
public class UserBillController {

    @Autowired
    private UserBillService userBillService;

    /**
     * 分页查询订单列表
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("分页查询资金记录列表")
    public GraceJSONResult getUserBillListPage(@RequestParam(defaultValue = "") Integer page, @RequestParam(defaultValue = "") Integer pageSize,
                                               @RequestParam(defaultValue = "") String date, @RequestParam(defaultValue = "") String type,
                                               @RequestParam(defaultValue = "") String keyword) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult listPage = userBillService.getUserBillListPage(page, pageSize, date, type, keyword);
        return GraceJSONResult.ok(listPage);
    }

}
