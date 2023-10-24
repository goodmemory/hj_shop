package com.hj.controller;

import com.hj.constant.ConstantParams;
import com.hj.entity.Result;
import com.hj.entity.StatusCode;
import com.hj.service.UserGroupService;
import com.hj.service.UserService;
import com.hj.util.PagedGridResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private UserGroupService userGroupService;

    /**
     * @param userId
     */
    @GetMapping("/getById")
    public Result getById(@RequestParam(value = "userId") Long userId) {
        return new Result(true, StatusCode.OK, "操作成功", userService.getById(userId));
    }

    /**
     * 获取所有用户组数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/group/lst")
    public Result getUserGroupList(@RequestParam Integer page,
                                   @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult userGroupList = userGroupService.getUserGroupList(page, pageSize);
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", userGroupList);
    }

    @GetMapping("/group/form")
    public Result getById(@RequestParam String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.GROUP_NAME_NOT_ALLOW_NULL);
        }
        Integer index = userGroupService.insertUserGroup(groupName);
        if (index == 0) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.SERVER_ERROR);
        }
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", null);
    }
}
