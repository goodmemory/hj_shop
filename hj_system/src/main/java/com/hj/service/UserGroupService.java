package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.entity.UserGroup;
import com.hj.util.PagedGridResult;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_group(用户分组表)】的数据库操作Service
 * @createDate 2023-10-23 16:49:35
 */
public interface UserGroupService extends IService<UserGroup> {

    /**
     * 获取所有用户组分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getUserGroupList(Integer page, Integer pageSize);

    /**
     * 新增用户组
     *
     * @param groupName
     */
    Integer insertUserGroup(String groupName);
}
