package com.hj.controller;

import com.hj.bo.UserGroupBo;
import com.hj.bo.UserLabelBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.Result;
import com.hj.entity.StatusCode;
import com.hj.service.UserGroupService;
import com.hj.service.UserLabelService;
import com.hj.service.UserService;
import com.hj.util.PagedGridResult;
import com.hj.vo.UserGroupVo;
import com.hj.vo.UserLabelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(tags = "UserController 用户信息接口模块")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private UserGroupService userGroupService;
    @Autowired
    private UserLabelService userLabelService;

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
    @GetMapping("/group/add")
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
    @GetMapping("/group/{id}")
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
    @PostMapping("/group/update")
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
    @GetMapping("/group/delete")
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

    /**
     * 获取所有用户标签数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/label/lst")
    @ApiOperation(value = "获取所有用户标签数据")
    public Result getUserLabelList(@RequestParam Integer page,
                                   @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult userLabelList = userLabelService.getUserLabelList(page, pageSize);
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", userLabelList);
    }

    /**
     * 添加用户标签
     *
     * @param labelName
     * @return
     */
    @GetMapping("/label/add")
    @ApiOperation(value = "添加用户标签")
    public Result insertUserLabel(@RequestParam String labelName) {
        if (StringUtils.isEmpty(labelName)) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.LABEL_NAME_NOT_ALLOW_NULL);
        }
        Integer index = userLabelService.insertUserLabel(labelName);
        if (index == 0) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.SERVER_ERROR);
        }
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", null);
    }

    /**
     * 根据id查询用户标签数据
     *
     * @param labelId
     * @return
     */
    @GetMapping("/label/{labelId}")
    @ApiOperation(value = "根据id查询用户标签数据")
    public Result getUserLabelInfoById(@PathVariable Integer labelId) {
        if (labelId == null) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.LABEL_ID_NOT_ALLOW_NULL);
        }
        UserLabelVo labelVo = userLabelService.getUserLabelInfoById(labelId);
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", labelVo);
    }

    /**
     * 修改用户标签
     *
     * @param bo
     * @return
     */
    @PostMapping("/label/update")
    @ApiOperation(value = "修改用户标签")
    public Result updateUserLabel(@RequestBody UserLabelBo bo) {
        if (bo.getLabelId() == null) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.LABEL_ID_NOT_ALLOW_NULL);
        }
        Boolean flag = userLabelService.updateUserLabel(bo);
        if (!flag) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.SERVER_ERROR);
        }
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", null);

    }

    /**
     * 删除用户标签
     *
     * @param labelId
     * @return
     */
    @GetMapping("/label/delete")
    @ApiOperation(value = "删除用户标签")
    public Result deleteUserLabelById(@RequestParam Integer labelId) {
        if (labelId == null) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.LABEL_ID_NOT_ALLOW_NULL);
        }
        Boolean flag = userLabelService.deleteUserLabelById(labelId);
        if (!flag) {
            return new Result(Boolean.FALSE, StatusCode.ERROR, "操作失败", ConstantParams.SERVER_ERROR);
        }
        return new Result(Boolean.TRUE, StatusCode.OK, "操作成功", null);
    }
}
