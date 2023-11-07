package com.hj.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.user.UserGroupBo;
import com.hj.entity.user.UserGroup;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.UserGroupVo;

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

    /**
     * 根据id获取用户组信息
     *
     * @param groupId
     * @return
     */
    UserGroupVo getUserGroupInfoById(Long groupId);

    /**
     * 修改用户组
     *
     * @param bo
     * @return
     */
    Boolean updateUserGroup(UserGroupBo bo);

    /**
     * 删除用户组
     *
     * @param groupId
     * @return
     */
    Boolean deleteUserGroupById(Long groupId);
}
