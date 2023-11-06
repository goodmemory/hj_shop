package com.hj.controller;

import com.hj.bo.store.StoreBrandCategoryBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.StoreBrandCategoryService;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreBrandCategoryOneVo;
import com.hj.vo.store.StoreBrandCategoryTwoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/storeBrandCategory")
@Api(tags = "StoreBrandCategoryController 商品品牌分类管理接口模块")
@Slf4j
public class StoreBrandCategoryController {

    @Autowired
    private StoreBrandCategoryService storeBrandCategoryService;

    /**
     * 获取所有品牌分类列表数据分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "获取所有品牌分类列表数据分页显示")
    public GraceJSONResult getStoreBrandCategoryPage(@RequestParam(defaultValue = "") Integer page,
                                                     @RequestParam(defaultValue = "") Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = storeBrandCategoryService.getStoreBrandCategoryPage(page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 获取所有品牌分类列表数据
     *
     * @return
     */
    @GetMapping("/listAll")
    @ApiOperation(value = "获取所有品牌分类列表数据")
    public GraceJSONResult getStoreBrandCategoryList() {
        List<StoreBrandCategoryOneVo> list = storeBrandCategoryService.getStoreBrandCategoryAllList();
        return GraceJSONResult.ok(list);
    }

    /**
     * 新增品牌分类数据
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增品牌分类数据")
    public GraceJSONResult insertStoreBrandCategory(@RequestBody StoreBrandCategoryBo bo) {
        storeBrandCategoryService.insertStoreBrandCategory(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 修改是否显示状态
     *
     * @return
     */
    @PutMapping("/updateIsShow/{storeBrandCategoryId}")
    @ApiOperation(value = "修改是否显示状态")
    public GraceJSONResult updateIsShow(@PathVariable String storeBrandCategoryId, @RequestParam Integer isShow) {
        storeBrandCategoryService.updateIsShow(storeBrandCategoryId, isShow);
        return GraceJSONResult.ok();
    }

    /**
     * 根据id获取品牌分类信息
     *
     * @param storeBrandCategoryId
     * @return
     */
    @GetMapping("/getStoreBrandById")
    @ApiOperation(value = "根据id获取品牌分类信息")
    public GraceJSONResult getStoreBrandCategoryById(@PathVariable String storeBrandCategoryId) {
        StoreBrandCategoryTwoVo category = storeBrandCategoryService.getStoreBrandCategoryById(storeBrandCategoryId);
        return GraceJSONResult.ok(category);
    }

    /**
     * 修改品牌分类数据
     *
     * @param bo
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改品牌分类数据")
    public GraceJSONResult updateStoreBrandCategory(@RequestBody StoreBrandCategoryBo bo) {
        storeBrandCategoryService.updateStoreBrandCategory(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 删除品牌分类数据
     *
     * @return
     */
    @PutMapping("/update/{storeBrandCategoryId}")
    @ApiOperation(value = "删除品牌分类数据")
    public GraceJSONResult deleteStoreBrandCategory(@PathVariable String storeBrandCategoryId) {
        storeBrandCategoryService.deleteStoreBrandCategory(storeBrandCategoryId);
        return GraceJSONResult.ok();
    }
}
