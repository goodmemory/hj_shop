package com.hj.controller.user;

import com.hj.bo.user.UserBo;
import com.hj.bo.user.UserListBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.user.UserService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(tags = "UserController 用户信息接口模块")
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 分页获取用户信息
     */
    @PostMapping("/list")
    @ApiOperation(value = "分页获取用户信息")
    public GraceJSONResult getUserList(@RequestBody UserBo bo) {
        if (bo.getPage() == 0) {
            bo.setPage(ConstantParams.COMMON_START_PAGE);
        }
        if (bo.getPageSize() == 0) {
            bo.setPageSize(ConstantParams.COMMON_PAGE_SIZE);
        }
        PagedGridResult userList = userService.getUserList(bo);
        return GraceJSONResult.ok(userList);
    }

    /**
     * 新增用户
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增用户")
    public GraceJSONResult insertUser(@RequestBody UserBo bo) {
        userService.insertUser(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 根据用户id获取用户信息
     */
    @GetMapping("/getUserById")
    @ApiOperation(value = "根据用户id获取用户信息")
    public GraceJSONResult getUserById(@RequestParam String uid) {
        return GraceJSONResult.ok(userService.getUserById(uid));
    }

    /**
     * 编辑用户
     *
     * @param bo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "编辑用户")
    public GraceJSONResult updateUser(@RequestBody UserBo bo) {
        userService.updateUser(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 设置红旌币
     *
     * @param uid
     * @param nowMoney
     * @param type
     * @return
     */
    @PutMapping("/setupMoney/{uid}")
    @ApiOperation(value = "设置红旌币")
    public GraceJSONResult setupMoney(@PathVariable String uid, @RequestParam BigDecimal nowMoney,
                                      @RequestParam Integer type) {
        userService.setupMoney(uid, nowMoney, type);
        return GraceJSONResult.ok();
    }

    /**
     * 设置积分
     *
     * @param uid
     * @param nowIntegral
     * @param type
     * @return
     */
    @PutMapping("/setupIntegral/{uid}")
    @ApiOperation(value = "设置积分")
    public GraceJSONResult setupIntegral(@PathVariable String uid, @RequestParam Integer nowIntegral,
                                         @RequestParam Integer type) {
        userService.setupIntegral(uid, nowIntegral, type);
        return GraceJSONResult.ok();
    }

    /**
     * 设置用户组(批量)
     *
     * @param bo
     * @return
     */
    @PostMapping("/setupUserGroup")
    @ApiOperation(value = "设置用户组(批量)")
    public GraceJSONResult setupUserGroup(@RequestBody UserListBo bo) {
        userService.setupUserGroup(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 设置用户标签(批量)
     *
     * @param bo
     * @return
     */
    @PutMapping("/setupUserLabel")
    @ApiOperation(value = "设置用户标签(批量)")
    public GraceJSONResult setupUserLabel(@RequestBody UserListBo bo) {
        userService.setupUserLabel(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 修改推荐人
     *
     * @param uid
     * @param spreadUid
     * @return
     */
    @PutMapping("/spreadUser/{uid}")
    @ApiOperation(value = "修改推荐人")
    public GraceJSONResult setupSpreadUser(@PathVariable String uid, @RequestParam String spreadUid) {
        userService.setupSpreadUser(uid, spreadUid);
        return GraceJSONResult.ok();
    }

    /**
     * 编辑会员等级
     *
     * @param uid
     * @param memberLevel
     * @return
     */
    @PutMapping("/setupMemberLevel/{uid}")
    @ApiOperation(value = "编辑会员等级")
    public GraceJSONResult setupMemberLevel(@PathVariable String uid, @RequestParam Integer memberLevel) {
        userService.setupMemberLevel(uid, memberLevel);
        return GraceJSONResult.ok();
    }

    /**
     * 修改密码
     *
     * @param account
     * @param pwd
     * @param rePwd
     * @return
     */
    @PutMapping("/updatePwd")
    @ApiOperation(value = "修改密码")
    public GraceJSONResult updatePassword(@RequestParam String account, @RequestParam String pwd, @RequestParam String rePwd) {
        userService.updatePassword(account, pwd, rePwd);
        return GraceJSONResult.ok();
    }

    /**
     * 用户详情：红旌币变动
     *
     * @param uid
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "修改密码")
    @GetMapping("/getMoneyInfo/{uid}")
    public GraceJSONResult getMoneyInfo(@PathVariable String uid, @RequestParam Integer page,
                                        @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult result = userService.getMoneyInfo(uid, page, pageSize);
        return GraceJSONResult.ok(result);
    }
}
