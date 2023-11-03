package com.hj.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.bo.user.UserListBo;
import com.hj.entity.user.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author mayaoqi
 * @description 针对表【eb_user(用户表)】的数据库操作Mapper
 * @createDate 2023-11-01 14:36:01
 * @Entity com.hj.User
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 批量修改用户组
     *
     * @param bo
     * @return
     */
    Integer updateBatchGroupId(@Param("bo") UserListBo bo);

    /**
     * 批量修改用户标签
     *
     * @param bo
     * @return
     */
    Integer updateBatchLabelId(@Param("bo") UserListBo bo);
}




