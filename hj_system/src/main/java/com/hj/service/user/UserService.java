package com.hj.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.user.UserBo;
import com.hj.bo.user.UserListBo;
import com.hj.entity.user.User;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.UserVo;

import java.math.BigDecimal;

/**
 * @author mayaoqi
 * @description 针对表【eb_user(用户表)】的数据库操作Service
 * @createDate 2023-11-01 14:36:01
 */
public interface UserService extends IService<User> {

    /**
     * 获取所有用户分页显示
     *
     * @param bo
     * @return
     */
    PagedGridResult getUserList(UserBo bo);

    /**
     * 新增用户
     *
     * @param bo
     */
    void insertUser(UserBo bo);

    /**
     * 编辑用户
     *
     * @param bo
     */
    void updateUser(UserBo bo);

    /**
     * 根据用户id获取用户信息
     *
     * @param uid
     * @return
     */
    UserVo getUserById(Long uid);

    /**
     * 设置红旌币
     *
     * @param uid
     * @param nowMoney
     * @param type
     */
    void setupMoney(Long uid, BigDecimal nowMoney, Integer type);

    /**
     * 设置积分
     *
     * @param uid
     * @param nowIntegral
     * @param type
     */
    void setupIntegral(Long uid, Integer nowIntegral, Integer type);

    /**
     * 设置用户组（批量）
     *
     * @param bo
     */
    void setupUserGroup(UserListBo bo);

    /**
     * 设置用户标签（批量）
     *
     * @param bo
     */
    void setupUserLabel(UserListBo bo);

    /**
     * 修改推荐人
     *
     * @param uid
     * @param spreadUid
     */
    void setupSpreadUser(Long uid, String spreadUid);

    /**
     * 修改密码
     *
     * @param pwd
     * @param pwd
     * @param rePwd
     */
    void updatePassword(String account, String pwd, String rePwd);

    /**
     * 编辑会员等级
     *
     * @param memberLevel
     */
    void setupMemberLevel(Long uid, Integer memberLevel);

    /**
     * 用户详情：红旌币变动
     *
     * @param uid
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getMoneyInfo(Long uid, Integer page, Integer pageSize);
}
