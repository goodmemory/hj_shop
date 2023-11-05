package com.hj.controller.user;

import com.hj.bo.user.UserLabelBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.Result;
import com.hj.entity.StatusCode;
import com.hj.service.user.UserLabelService;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.UserLabelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user/label")
@Api(tags = "UserLabelController 用户标签接口模块")
@Slf4j
public class UserLabelController {

    @Autowired
    private UserLabelService userLabelService;

    /**
     * 获取所有用户标签数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
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
    @GetMapping("/add")
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
    @GetMapping("/{labelId}")
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
    @PostMapping("/update")
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
    @GetMapping("/delete")
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
