package com.hj.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.user.UserGroupBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.user.UserGroup;
import com.hj.mapper.user.UserGroupMapper;
import com.hj.service.user.UserGroupService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.UserGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_group(用户分组表)】的数据库操作Service实现
 * @createDate 2023-10-23 16:49:35
 */
@Service
@Slf4j
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup>
        implements UserGroupService {

    @Autowired
    private UserGroupMapper userGroupMapper;

    /**
     * 获取所有用户组分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getUserGroupList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<UserGroup> list = userGroupMapper.selectList(
                new LambdaQueryWrapper<UserGroup>().eq(UserGroup::getStatus, ConstantParams.COMMON_STATUS_1)
                        .orderByDesc(UserGroup::getCreateTime));
        log.info("获取所有用户组分页数据：" + list.toString());
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 新增用户组
     *
     * @param groupName
     */
    @Override
    public Integer insertUserGroup(String groupName) {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupName(groupName);
        return userGroupMapper.insert(userGroup);
    }

    /**
     * 根据id获取用户组信息
     *
     * @param groupId
     * @return
     */
    @Override
    public UserGroupVo getUserGroupInfoById(Integer groupId) {
        UserGroup userGroup = this.getById(groupId);
        UserGroupVo groupVo = new UserGroupVo();
        BeanUtils.copyProperties(userGroup, groupVo);
        return groupVo;
    }

    /**
     * 修改用户组
     *
     * @param bo
     * @return
     */
    @Override
    public Boolean updateUserGroup(UserGroupBo bo) {
        UserGroup userGroup = new UserGroup();
        BeanUtils.copyProperties(bo, userGroup);
        userGroup.setUpdateTime(DateUtil.getCurrentDateTime());
        return this.updateById(userGroup);
    }

    /**
     * 删除用户组
     *
     * @param groupId
     * @return
     */
    @Override
    public Boolean deleteUserGroupById(Integer groupId) {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupId(groupId);
        userGroup.setStatus(ConstantParams.COMMON_STATUS_0);
        userGroup.setUpdateTime(DateUtil.getCurrentDateTime());
        return this.updateById(userGroup);
    }
}
