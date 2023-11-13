package com.hj.controller;

import com.hj.bo.store.StoreProductBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.StoreProductService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/storeProduct")
@Api(tags = "StoreProductController 商品管理接口模块")
@Slf4j
public class StoreProductController {

    @Autowired
    private StoreProductService storeProductService;

    /**
     * 分页查询商品列表
     *
     * @param bo
     * @return
     */
    @PostMapping("/list")
    @ApiOperation("分页查询商品列表")
    public GraceJSONResult getStoreProductListPage(@RequestBody StoreProductBo bo) {
        if (bo.getPage() == null) {
            bo.setPage(ConstantParams.COMMON_START_PAGE);
        }
        if (bo.getPageSize() == null) {
            bo.setPageSize(ConstantParams.COMMON_PAGE_SIZE);
        }
        PagedGridResult page = storeProductService.getStoreProductListPage(bo);
        return GraceJSONResult.ok(page);
    }

    /**
     * 修改是否显示状态
     *
     * @param productId
     * @param isUsed
     * @return
     */
    @ApiOperation("修改是否显示状态")
    @PutMapping("/updateIsUsed/{productId}")
    public GraceJSONResult updateIsUsed(@PathVariable Long productId, Integer isUsed) {
        storeProductService.updateIsUsed(productId, isUsed);
        return GraceJSONResult.ok();
    }

    /**
     * 编辑标签
     *
     * @param productId
     * @param labelId
     * @return
     */
    @ApiOperation("编辑标签")
    @PutMapping("/updateLabel/{productId}")
    public GraceJSONResult updateLabel(@PathVariable Long productId, @RequestParam Long labelId) {
        storeProductService.updateLabel(productId, labelId);
        return GraceJSONResult.ok();
    }
}
