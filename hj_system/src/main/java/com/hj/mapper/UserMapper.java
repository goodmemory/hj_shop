package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mayaoqi
 * @description 针对表【eb_user(用户表)】的数据库操作Mapper
 * @createDate 2023-10-23 16:44:01
 * @Entity generator.com.hj.entity.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
