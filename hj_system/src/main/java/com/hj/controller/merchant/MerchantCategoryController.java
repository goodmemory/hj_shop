package com.hj.controller.merchant;

import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.merchant.MerchantCategoryService;
import com.hj.util.PagedGridResult;
import com.hj.vo.merchant.MerchantCategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin
@RequestMapping("/merchantCategory")
@Api(tags = "MerchantCategoryController 商户分类列表接口模块")
@Slf4j
public class MerchantCategoryController {

    @Autowired
    private MerchantCategoryService merchantCategoryService;

    /**
     * 获取所有商户分类分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "获取所有商户分类分页显示")
    public GraceJSONResult getMerchantCategoryList(@RequestParam Integer page,
                                                   @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = merchantCategoryService.getMerchantCategoryList(page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 新增商户分类
     *
     * @param categoryName
     * @param commissionRate
     * @return
     */
    @GetMapping("/add")
    @ApiOperation(value = "新增商户分类")
    public GraceJSONResult insertMerchantCategory(@RequestParam String categoryName, @RequestParam BigDecimal commissionRate) {
        merchantCategoryService.insertMerchantCategory(categoryName, commissionRate);
        return GraceJSONResult.ok();
    }

    @GetMapping("/getMerchantCategoryById")
    public GraceJSONResult getMerchantCategoryById(@PathVariable Integer merchantCategoryId) {
        MerchantCategoryVo category = merchantCategoryService.getMerchantCategoryById(merchantCategoryId);
        return GraceJSONResult.ok(category);
    }

    /**
     * 修改商户分类
     *
     * @param categoryName
     * @param commissionRate
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "修改商户分类")
    public GraceJSONResult updateMerchantCategory(@RequestParam Integer merchantCategoryId, @RequestParam String categoryName, @RequestParam BigDecimal commissionRate) {
        merchantCategoryService.updateMerchantCategory(merchantCategoryId, categoryName, commissionRate);
        return GraceJSONResult.ok();
    }
}
