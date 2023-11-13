package com.hj.controller;

import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.entity.store.StoreProductLabel;
import com.hj.service.StoreProductLabelService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/storeProductLabel")
@Api(tags = "StoreProductLabelController 商品标签管理接口模块")
@Slf4j
public class StoreProductLabelController {

    @Autowired
    private StoreProductLabelService storeProductLabelService;

    /**
     * 分页查询商品标签列表
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("分页查询商品标签列表")
    public GraceJSONResult getStoreProductLabelListPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = storeProductLabelService.getStoreProductLabelListPage(page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 新增商品标签
     *
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("新增商品标签")
    public GraceJSONResult insertStoreProductLabel(@RequestBody StoreProductLabel label) {
        storeProductLabelService.insertStoreProductLabel(label);
        return GraceJSONResult.ok();
    }

    /**
     * 修改商品标签
     *
     * @return
     */
    @PutMapping("/update")
    @ApiOperation("修改商品标签")
    public GraceJSONResult updateStoreProductLabel(@RequestBody StoreProductLabel label) {
        storeProductLabelService.updateStoreProductLabel(label);
        return GraceJSONResult.ok();
    }

    /**
     * 删除商品标签
     *
     * @return
     */
    @PutMapping("/delete/{productLabelId}")
    @ApiOperation("删除商品标签")
    public GraceJSONResult updateStoreProductLabel(@PathVariable Long productLabelId) {
        storeProductLabelService.deleteStoreProductLabel(productLabelId);
        return GraceJSONResult.ok();
    }

    /**
     * 修改商品标签显示状态
     *
     * @return
     */
    @PutMapping("/updateStatus/{productLabelId}")
    @ApiOperation("修改商品标签显示状态")
    public GraceJSONResult updateStatus(@PathVariable Long productLabelId, Integer status) {
        storeProductLabelService.updateStatus(productLabelId, status);
        return GraceJSONResult.ok();
    }

    /**
     * 根据id获取数据
     *
     * @return
     */
    @GetMapping("/getStoreProductLabelById/{productLabelId}")
    @ApiOperation("根据id获取数据")
    public GraceJSONResult getStoreProductLabelById(@PathVariable Long productLabelId) {
        StoreProductLabel label = storeProductLabelService.getStoreProductLabelById(productLabelId);
        return GraceJSONResult.ok(label);
    }
}
