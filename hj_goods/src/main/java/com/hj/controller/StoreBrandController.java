package com.hj.controller;

import com.hj.bo.store.StoreBrandBo;
import com.hj.entity.GraceJSONResult;
import com.hj.service.StoreBrandService;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreBrandVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/storeBrand")
@Api(tags = "StoreBrandController 商品品牌管理接口模块")
@Slf4j
public class StoreBrandController {

    @Autowired
    private StoreBrandService storeBrandService;

    /**
     * 获取所有商品品牌列表数据分页显示
     *
     * @param brandCategoryId
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("list")
    @ApiOperation(value = "获取所有商品品牌列表数据分页显示")
    public GraceJSONResult getStoreBrandListPage(@RequestParam Long brandCategoryId,
                                                 @RequestParam Integer page,
                                                 @RequestParam Integer pageSize) {
        PagedGridResult list = storeBrandService.getStoreBrandListPage(brandCategoryId, page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 根据id获取品牌数据
     *
     * @param brandId
     * @return
     */
    @GetMapping("/getStoreBrandById")
    @ApiOperation(value = "根据id获取品牌数据")
    public GraceJSONResult getStoreBrandById(@PathVariable Long brandId) {
        StoreBrandVo brand = storeBrandService.getStoreBrandById(brandId);
        return GraceJSONResult.ok(brand);
    }

    /**
     * 新增品牌数据
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增品牌数据")
    public GraceJSONResult insertStoreBrand(@RequestBody StoreBrandBo bo) {
        storeBrandService.insertStoreBrand(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 修改品牌数据
     *
     * @param bo
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改品牌数据")
    public GraceJSONResult updateStoreBrand(@RequestBody StoreBrandBo bo) {
        storeBrandService.updateStoreBrand(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 删除品牌数据
     *
     * @param brandId
     * @return
     */
    @PutMapping("/delete/{brandId}")
    @ApiOperation(value = "修改品牌数据")
    public GraceJSONResult deleteStoreBrand(@PathVariable Long brandId) {
        storeBrandService.deleteStoreBrand(brandId);
        return GraceJSONResult.ok();
    }

    /**
     * 修改是否显示状态
     *
     * @param brandId
     * @return
     */
    @PutMapping("/updateIsShow/{brandId}")
    @ApiOperation(value = "修改是否显示状态")
    public GraceJSONResult updateIsShow(@PathVariable Long brandId, @RequestParam Integer isShow) {
        storeBrandService.updateIsShow(brandId, isShow);
        return GraceJSONResult.ok();
    }

}
