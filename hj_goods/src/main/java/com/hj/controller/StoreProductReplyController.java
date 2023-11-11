package com.hj.controller;

import com.hj.bo.store.StoreProductReplyBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.StoreProductReplyService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/storeProductReply")
@Api(tags = "StoreProductReplyController 商品评论管理接口模块")
@Slf4j
public class StoreProductReplyController {

    @Autowired
    private StoreProductReplyService storeProductReplyService;

    /**
     * 获取所有商品评论列表数据分页显示
     *
     * @param bo
     * @return
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取所有商品评论列表数据分页显示")
    public GraceJSONResult getStoreProductReplyListPage(@RequestBody StoreProductReplyBo bo) {
        if (bo.getPage() == null) {
            bo.setPage(ConstantParams.COMMON_START_PAGE);
        }
        if (bo.getPageSize() == null) {
            bo.setPageSize(ConstantParams.COMMON_PAGE_SIZE);
        }
        PagedGridResult page = storeProductReplyService.getStoreProductReplyListPage(bo);
        return GraceJSONResult.ok(page);
    }

    /**
     * 新增虚拟评论
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增虚拟评论")
    public GraceJSONResult insertStoreProductReply(@RequestBody StoreProductReplyBo bo) {
        storeProductReplyService.insertStoreProductReply(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 删除评论
     *
     * @param replyId
     * @return
     */
    @PutMapping("/delete")
    @ApiOperation(value = "删除评论")
    public GraceJSONResult deleteStoreProductReply(@PathVariable Long replyId) {
        storeProductReplyService.deleteStoreProductReply(replyId);
        return GraceJSONResult.ok();
    }
}
