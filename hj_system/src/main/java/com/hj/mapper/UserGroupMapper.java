package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.UserGroup;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_group(用户分组表)】的数据库操作Mapper
 * @createDate 2023-10-23 16:49:35
 * @Entity com.hj.UserGroup
 */
@Mapper
public interface UserGroupMapper extends BaseMapper<UserGroup> {


}
