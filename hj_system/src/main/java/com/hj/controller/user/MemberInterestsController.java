package com.hj.controller.user;

import com.hj.bo.user.MemberInterestsBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.user.MemberInterestsService;
import com.hj.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/memberinterests")
@Api(tags = "MemberInterestsController 会员权益接口模块")
@Slf4j
public class MemberInterestsController {

    @Autowired
    private MemberInterestsService memberInterestsService;

    /**
     * 获取所有会员权益数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "获取所有会员权益数据")
    public GraceJSONResult getMemberInterestsList(@RequestParam Integer page,
                                                  @RequestParam Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = memberInterestsService.getMemberInterestsList(page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 新增会员权益
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增会员权益")
    public GraceJSONResult insertMemberInterests(@RequestBody MemberInterestsBo bo) {
        memberInterestsService.insertMemberInterests(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 修改会员权益
     *
     * @param bo
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改会员权益")
    public GraceJSONResult updateMemberInterests(@RequestBody MemberInterestsBo bo) {
        memberInterestsService.updateMemberInterests(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 删除会员权益
     *
     * @param interestsId
     * @return
     */
    @PutMapping("/delete")
    @ApiOperation(value = "删除会员权益")
    public GraceJSONResult deleteMemberInterests(@RequestParam Integer interestsId) {
        memberInterestsService.deleteMemberInterests(interestsId);
        return GraceJSONResult.ok();
    }

}
