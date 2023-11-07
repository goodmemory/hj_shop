package com.hj.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.user.MemberInterestsBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.user.MemberInterests;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.user.MemberInterestsMapper;
import com.hj.service.user.MemberInterestsService;
import com.hj.util.DateUtil;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_member_interests】的数据库操作Service实现
 * @createDate 2023-10-31 14:36:29
 */
@Service
@Slf4j
public class MemberInterestsServiceImpl extends ServiceImpl<MemberInterestsMapper, MemberInterests>
        implements MemberInterestsService {

    @Autowired
    private MemberInterestsMapper memberInterestsMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 获取所有会员权益分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getMemberInterestsList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<MemberInterests> list = memberInterestsMapper.selectList(new LambdaQueryWrapper<MemberInterests>()
                .eq(MemberInterests::getStatus, ConstantParams.COMMON_STATUS_1));
        log.info("获取所有用户组分页数据：" + list.toString());
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 新增会员权益
     *
     * @param bo
     */
    @Override
    public void insertMemberInterests(MemberInterestsBo bo) {
        if (StringUtils.isEmpty(bo.getName())) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.MEMBER_INTERESTS_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_INTERESTS_NAME_NOT_NULL);
        }
        MemberInterests interests = this.getOne(new LambdaQueryWrapper<MemberInterests>()
                .eq(MemberInterests::getName, bo.getName())
                .eq(MemberInterests::getStatus, ConstantParams.COMMON_STATUS_1));
        if (interests != null && interests.getName().equals(bo.getName())) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.MEMBER_INTERESTS_NAME_SAME.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_INTERESTS_NAME_SAME);
        }
        if (StringUtils.isEmpty(bo.getInfo())) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.MEMBER_INTERESTS_INFO_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_INTERESTS_INFO_NOT_NULL);
        }
        MemberInterests memberInterests = new MemberInterests();
        BeanUtils.copyProperties(bo, memberInterests);
        memberInterests.setInterestsId(idWorker.nextId());
        int index = memberInterestsMapper.insert(memberInterests);
        if (index == 0) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改会员权益
     *
     * @param bo
     */
    @Override
    public void updateMemberInterests(MemberInterestsBo bo) {
        if (bo.getInterestsId() == null) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.MEMBER_INTERESTS_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_INTERESTS_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getName())) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.MEMBER_INTERESTS_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_INTERESTS_NAME_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getInfo())) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.MEMBER_INTERESTS_INFO_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_INTERESTS_INFO_NOT_NULL);
        }
        MemberInterests memberInterests = new MemberInterests();
        BeanUtils.copyProperties(bo, memberInterests);
        memberInterests.setUpdateTime(DateUtil.getCurrentDateTime());
        int index = memberInterestsMapper.updateById(memberInterests);
        if (index == 0) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除会员权益
     *
     * @param interestsId
     */
    @Override
    public void deleteMemberInterests(Long interestsId) {
        if (interestsId == null) {
            log.error("MemberInterestsServiceImpl===>deleteMemberInterests:" + ResponseStatusEnum.MEMBER_INTERESTS_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_INTERESTS_ID_NOT_NULL);
        }
        MemberInterests memberInterests = new MemberInterests();
        memberInterests.setInterestsId(interestsId);
        memberInterests.setStatus(ConstantParams.COMMON_STATUS_0);
        memberInterests.setUpdateTime(DateUtil.getCurrentDateTime());
        int index = memberInterestsMapper.updateById(memberInterests);
        if (index == 0) {
            log.error("MemberInterestsServiceImpl===>insertMemberInterests:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




