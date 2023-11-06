package com.hj.controller;

import com.hj.bo.store.StoreCategoryBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.StoreCategoryService;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreCategoryOneVo;
import com.hj.vo.store.StoreCategoryTwoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/storeCategory")
@Api(tags = "StoreCategoryController 商品类别管理接口模块")
@Slf4j
public class StoreCategoryController {

    @Autowired
    private StoreCategoryService storeCategoryService;

    /**
     * 获取所有商品分类列表数据分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "获取所有商品分类列表数据分页显示")
    public GraceJSONResult getStoreCategoryListPage(@RequestParam(defaultValue = "") Integer page,
                                                    @RequestParam(defaultValue = "") Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = storeCategoryService.getStoreCategoryListPage(page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 获取所有商品分类列表数据
     *
     * @return
     */
    @GetMapping("/listStoreCategory")
    @ApiOperation(value = "获取所有商品分类列表数据")
    public GraceJSONResult getStoreCategoryList() {
        List<StoreCategoryOneVo> list = storeCategoryService.getStoreCategoryList();
        return GraceJSONResult.ok(list);
    }

    /**
     * 新增商品分类数据
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增商品分类数据")
    public GraceJSONResult insertStoreCategory(@RequestBody StoreCategoryBo bo) {
        storeCategoryService.insertStoreCategory(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 修改商品分类数据
     *
     * @param bo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改商品分类数据")
    public GraceJSONResult updateStoreCategory(@RequestBody StoreCategoryBo bo) {
        storeCategoryService.updateStoreCategory(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 修改商品分类状态包括：是否显示，是否推荐，发货前确认
     *
     * @param storeCategoryId
     * @param type
     * @param params
     * @return
     */
    @PutMapping("/updateStatus/{storeCategoryId}")
    @ApiOperation(value = "修改商品分类状态包括：是否显示，是否推荐，发货前确认")
    public GraceJSONResult updateCategoryStatus(@PathVariable String storeCategoryId,
                                                @RequestParam Integer type,
                                                @RequestParam Integer params) {
        storeCategoryService.updateCategoryStatus(type, storeCategoryId, params);
        return GraceJSONResult.ok();
    }

    @PutMapping("/delete/{storeCategoryId}")
    @ApiOperation(value = "删除商品分类")
    public GraceJSONResult deleteStoreCategory(@PathVariable String storeCategoryId) {
        storeCategoryService.deleteStoreCategory(storeCategoryId);
        return GraceJSONResult.ok();
    }

    /**
     * 根据id获取商品详情
     *
     * @param storeCategoryId
     * @return
     */
    @GetMapping("/getStoreCategoryById")
    @ApiOperation(value = "根据id获取商品详情")
    public GraceJSONResult getStoreCategoryById(@RequestParam String storeCategoryId) {
        StoreCategoryTwoVo category = storeCategoryService.getStoreCategoryById(storeCategoryId);
        return GraceJSONResult.ok(category);
    }

}
