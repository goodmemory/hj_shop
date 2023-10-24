package com.hj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.entity.UserGroup;
import com.hj.mapper.UserGroupMapper;
import com.hj.service.UserGroupService;
import com.hj.util.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_group(用户分组表)】的数据库操作Service实现
 * @createDate 2023-10-23 16:49:35
 */
@Service
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
        List<UserGroup> list = userGroupMapper.selectList(null);
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
}
