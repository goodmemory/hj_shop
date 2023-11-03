package com.hj.controller.user;

import com.hj.bo.user.FeedbackBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.user.FeedbackService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
@Api(tags = "FeedbackController 用户投诉数据列表接口模块")
@Slf4j
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    /**
     * 获取所有用户投诉列表数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/lst")
    @ApiOperation(value = "获取所有用户投诉列表数据")
    public GraceJSONResult getFeedbackList(@RequestParam(defaultValue = "") String keyword, @RequestParam Integer page,
                                           @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult feedbackList = feedbackService.getFeedbackList(keyword, page, pageSize);
        return GraceJSONResult.ok(feedbackList);
    }

    /**
     * 回复消息
     *
     * @param bo
     * @return
     */
    @PutMapping("/replay")
    @ApiOperation(value = "回复用户投诉")
    public GraceJSONResult replayContent(@RequestBody FeedbackBo bo) {
        feedbackService.replayContent(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 删除消息
     *
     * @param feedbackId
     * @return
     */
    @PutMapping("/delete")
    @ApiOperation(value = "删除用户投诉")
    public GraceJSONResult deleteContent(@RequestParam Integer feedbackId) {
        feedbackService.deleteContent(feedbackId);
        return GraceJSONResult.ok();
    }
}
