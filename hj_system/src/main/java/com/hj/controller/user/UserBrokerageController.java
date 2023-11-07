package com.hj.controller.user;

import com.hj.bo.user.UserBrokerageBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.user.UserBrokerageService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/userbrokerage")
@Api(tags = "UserBrokerageController 会员等级接口模块")
@Slf4j
public class UserBrokerageController {

    @Autowired
    private UserBrokerageService userBrokerageService;

    /**
     * 获取所有会员等级数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "获取所有会员等级数据")
    public GraceJSONResult getMemberInterestsList(@RequestParam Integer page,
                                                  @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = userBrokerageService.getUserBrokerageList(page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 新增会员等级
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增会员等级")
    public GraceJSONResult insertUserBrokerage(@RequestBody UserBrokerageBo bo) {
        userBrokerageService.insertUserBrokerage(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 根军id获取会员等级信息
     *
     * @param userBrokerageId
     * @return
     */
    @GetMapping("/getInfo")
    @ApiOperation(value = "根军id获取会员等级信息")
    public GraceJSONResult getUserBrokerageById(@RequestParam Long userBrokerageId) {
        return GraceJSONResult.ok(userBrokerageService.getUserBrokerageById(userBrokerageId));
    }

    /**
     * 修改会员等级
     *
     * @param bo
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改会员等级")
    public GraceJSONResult updateUserBrokerage(@RequestBody UserBrokerageBo bo) {
        userBrokerageService.updateUserBrokerage(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 删除会员等级
     *
     * @param userBrokerageId
     * @return
     */
    @PutMapping("/delete/{userBrokerageId}")
    @ApiOperation(value = "删除会员等级")
    public GraceJSONResult deleteUserBrokerage(@PathVariable Long userBrokerageId) {
        userBrokerageService.deleteUserBrokerage(userBrokerageId);
        return GraceJSONResult.ok();
    }
}
