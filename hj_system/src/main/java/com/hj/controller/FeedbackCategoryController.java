package com.hj.controller;

import com.hj.bo.FeedbackCategoryBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.entity.Result;
import com.hj.entity.StatusCode;
import com.hj.service.FeedbackCategoryService;
import com.hj.util.PagedGridResult;
import com.hj.vo.FeedbackCategory1Vo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/feedbackcategory")
@Api(tags = "FeedbackCategoryController 用户投诉分类列表接口模块")
@Slf4j
public class FeedbackCategoryController {

    @Autowired
    private FeedbackCategoryService feedbackCategoryService;

    @GetMapping("/lst")
    @ApiOperation(value = "获取所有用户投诉分类列表数据")
    public Result getFeedbackList(@RequestParam Integer page,
                                  @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = feedbackCategoryService.getFeedbackCategoryList(page, pageSize);
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", list);
    }

    /**
     * 修改是否显示状态
     *
     * @param bo
     * @return
     */
    @PutMapping("/updateShow")
    @ApiOperation(value = "修改是否显示状态")
    public GraceJSONResult updateShowStatus(@RequestBody FeedbackCategoryBo bo) {
        feedbackCategoryService.updateShowStatus(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 根据id获取投诉分类信息
     *
     * @param feedbackCategoryId
     * @return
     */
    @GetMapping("/getFeedbackCategoryById")
    @ApiOperation(value = "根据id获取投诉分类信息")
    public GraceJSONResult getFeedbackCategoryById(@RequestParam Integer feedbackCategoryId) {
        FeedbackCategory1Vo category = feedbackCategoryService.getFeedbackCategoryById(feedbackCategoryId);
        return GraceJSONResult.ok(category);
    }

    /**
     * 获取所有投诉分类
     *
     * @return
     */
    @GetMapping("/listAll")
    @ApiOperation(value = "获取所有投诉分类信息")
    public Result getFeedbackCategoryList() {
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", feedbackCategoryService.getFeedbackCategoryList());
    }

    /**
     * 添加用户投诉分类
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加用户投诉分类")
    public GraceJSONResult insertFeedbackCategory(@RequestBody FeedbackCategoryBo bo) {
        feedbackCategoryService.insertFeedbackCategory(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 修改用户投诉分类
     *
     * @param bo
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "添加用户投诉分类")
    public GraceJSONResult updateFeedbackCategory(@RequestBody FeedbackCategoryBo bo) {
        feedbackCategoryService.updateFeedbackCategory(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 删除分类
     *
     * @param feedbackCategoryId
     * @return
     */
    @PutMapping("/delete")
    @ApiOperation(value = "删除用户投诉分类")
    public GraceJSONResult deleteFeedbackCategoryById(@RequestParam Integer feedbackCategoryId) {
        feedbackCategoryService.deleteFeedbackCategoryById(feedbackCategoryId);
        return GraceJSONResult.ok();
    }
}
