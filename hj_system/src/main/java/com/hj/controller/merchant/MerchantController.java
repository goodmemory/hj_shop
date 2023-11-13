package com.hj.controller.merchant;

import com.hj.bo.merchant.MerchantBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.merchant.MerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merchant")
@Api(tags = "MerchantController 商户列表接口模块")
@Slf4j
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    /**
     * 获取所有商户分类分页显示
     *
     * @return
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取所有商户分页显示")
    public GraceJSONResult getMerchantListPage(@RequestBody MerchantBo bo) {
        if (bo.getPage() == null) {
            bo.setPage(ConstantParams.COMMON_START_PAGE);
        }
        if (bo.getPageSize() == null) {
            bo.setPageSize(ConstantParams.COMMON_PAGE_SIZE);
        }
        return GraceJSONResult.ok(merchantService.getMerchantListPage(bo));
    }

    /**
     * 获取所有商户名称（供商品管理页使用）
     *
     * @return
     */
    @GetMapping("/getMerchantName")
    @ApiOperation(value = "获取所有商户名称（供商品管理页使用）")
    public GraceJSONResult getMerchantName() {
        List<String> list = merchantService.getMerchantName();
        return GraceJSONResult.ok(list);
    }
}
