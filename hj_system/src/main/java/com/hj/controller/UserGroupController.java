package com.hj.controller;

import com.hj.bo.UserGroupBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.Result;
import com.hj.entity.StatusCode;
import com.hj.service.UserGroupService;
import com.hj.util.PagedGridResult;
import com.hj.vo.UserGroupVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user/group")
@Api(tags = "UserGroupController 用户组接口模块")
@Slf4j
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    /**
     * 获取所有用户组数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/lst")
    @ApiOperation(value = "获取所有用户组数据")
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

    /**
     * 添加用户组
     *
     * @param groupName
     * @return
     */
    @GetMapping("/add")
    @ApiOperation(value = "添加用户组")
    public Result insertUserGroup(@RequestParam String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.GROUP_NAME_NOT_ALLOW_NULL);
        }
        Integer index = userGroupService.insertUserGroup(groupName);
        if (index == 0) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.SERVER_ERROR);
        }
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", null);
    }

    /**
     * 根据id查询用户组数据
     *
     * @param groupId
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询用户组数据")
    public Result getUserGroupInfoById(@PathVariable Integer groupId) {
        if (groupId == null) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.GROUP_ID_NOT_ALLOW_NULL);
        }
        UserGroupVo groupVo = userGroupService.getUserGroupInfoById(groupId);
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", groupVo);
    }

    /**
     * 修改用户组
     *
     * @param bo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改用户组")
    public Result updateUserGroup(@RequestBody UserGroupBo bo) {
        if (bo.getGroupId() == null) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.GROUP_ID_NOT_ALLOW_NULL);
        }
        Boolean flag = userGroupService.updateUserGroup(bo);
        if (!flag) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.SERVER_ERROR);
        }
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", null);

    }

    /**
     * 删除用户组
     *
     * @param groupId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除用户组")
    public Result deleteUserGroupById(@RequestParam Integer groupId) {
        if (groupId == null) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.GROUP_ID_NOT_ALLOW_NULL);
        }
        Boolean flag = userGroupService.deleteUserGroupById(groupId);
        if (!flag) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.SERVER_ERROR);
        }
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", null);
    }
}
