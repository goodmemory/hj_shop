package com.hj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.entity.User;
import com.hj.service.UserService;
import com.hj.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author mayaoqi
 * @description 针对表【eb_user(用户表)】的数据库操作Service实现
 * @createDate 2023-10-23 16:44:01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
