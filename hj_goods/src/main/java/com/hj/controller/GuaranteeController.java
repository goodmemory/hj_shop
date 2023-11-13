package com.hj.controller;

import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.entity.store.Guarantee;
import com.hj.service.GuaranteeService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/guarantee")
@Api(tags = "GuaranteeController 保障服务管理接口模块")
@Slf4j
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    /**
     * 分页查询保障服务列表
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("分页查询保障服务列表")
    public GraceJSONResult getGuaranteeListPage(@RequestParam(defaultValue = "") String date, @RequestParam(defaultValue = "") String guaranteeName,
                                                @RequestParam(defaultValue = "") Integer page, @RequestParam(defaultValue = "") Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = guaranteeService.getGuaranteeListPage(date, guaranteeName, page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 新增保障服务
     *
     * @param guarantee
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("新增保障服务")
    public GraceJSONResult insertGuarantee(@RequestBody Guarantee guarantee) {
        guaranteeService.insertGuarantee(guarantee);
        return GraceJSONResult.ok();
    }

    /**
     * 修改保障服务
     *
     * @param guarantee
     * @return
     */
    @PutMapping("/update")
    @ApiOperation("修改保障服务")
    public GraceJSONResult updateGuarantee(@RequestBody Guarantee guarantee) {
        guaranteeService.updateGuarantee(guarantee);
        return GraceJSONResult.ok();
    }

    /**
     * 删除保障服务
     *
     * @param guaranteeId
     * @return
     */
    @PutMapping("/delete/{guaranteeId}")
    @ApiOperation("删除保障服务")
    public GraceJSONResult deleteGuarantee(@PathVariable Long guaranteeId) {
        guaranteeService.deleteGuarantee(guaranteeId);
        return GraceJSONResult.ok();
    }

    /**
     * 修改是否显示状态
     *
     * @param guaranteeId
     * @return
     */
    @PutMapping("/updateStatus/{guaranteeId}")
    @ApiOperation("修改是否显示状态")
    public GraceJSONResult updateStatus(@PathVariable Long guaranteeId, @RequestParam Integer status) {
        guaranteeService.updateStatus(guaranteeId, status);
        return GraceJSONResult.ok();
    }

    /**
     * 根据id查询数据
     *
     * @param guaranteeId
     * @return
     */
    @GetMapping("/getGuaranteeById/{guaranteeId}")
    @ApiOperation("根据id查询数据")
    public GraceJSONResult getGuaranteeById(@PathVariable Long guaranteeId) {
        Guarantee guarantee = guaranteeService.getGuaranteeById(guaranteeId);
        return GraceJSONResult.ok(guarantee);
    }


}
