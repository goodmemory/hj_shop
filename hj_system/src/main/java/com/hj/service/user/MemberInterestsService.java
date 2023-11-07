package com.hj.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.user.MemberInterestsBo;
import com.hj.entity.user.MemberInterests;
import com.hj.util.PagedGridResult;

/**
 * @author mayaoqi
 * @description 针对表【eb_member_interests】的数据库操作Service
 * @createDate 2023-10-31 14:36:29
 */
public interface MemberInterestsService extends IService<MemberInterests> {

    /**
     * 获取所有会员权益分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getMemberInterestsList(Integer page, Integer pageSize);

    /**
     * 新增会员权益
     *
     * @param bo
     */
    void insertMemberInterests(MemberInterestsBo bo);

    /**
     * 修改会员权益
     *
     * @param bo
     */
    void updateMemberInterests(MemberInterestsBo bo);

    /**
     * 删除会员权益
     *
     * @param interestsId
     */
    void deleteMemberInterests(Long interestsId);
}
