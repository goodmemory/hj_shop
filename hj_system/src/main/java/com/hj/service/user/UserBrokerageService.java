package com.hj.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.user.UserBrokerageBo;
import com.hj.entity.user.UserBrokerage;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.UserBrokerageVo;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_brokerage】的数据库操作Service
 * @createDate 2023-11-01 10:58:09
 */
public interface UserBrokerageService extends IService<UserBrokerage> {

    /**
     * 获取所有会员等级分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getUserBrokerageList(Integer page, Integer pageSize);

    /**
     * 新增会员等级
     *
     * @param bo
     */
    void insertUserBrokerage(UserBrokerageBo bo);

    /**
     * 根据id获取会员等级信息
     *
     * @param userBrokerageId
     * @return
     */
    UserBrokerageVo getUserBrokerageById(Long userBrokerageId);

    /**
     * 修改会员等级
     *
     * @param bo
     */
    void updateUserBrokerage(UserBrokerageBo bo);

    /**
     * 删除会员等级
     *
     * @param userBrokerageId
     */
    void deleteUserBrokerage(Long userBrokerageId);
}
