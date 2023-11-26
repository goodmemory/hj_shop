package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.entity.finance.UserRecharge;
import com.hj.util.PagedGridResult;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_recharge(用户充值表)】的数据库操作Service
 * @createDate 2023-11-20 22:29:58
 */
public interface UserRechargeService extends IService<UserRecharge> {

    /**
     * 分页显示用户充值列表
     *
     * @param date
     * @param paid
     * @param keyword
     * @return
     */
    PagedGridResult getUserRechargeListPage(Integer page, Integer pageSize, String date, Integer paid, String keyword);

    /**
     * 金额汇总
     *
     * @param date
     * @param paid
     * @param keyword
     * @return
     */
    Map<String, BigDecimal> getMoneyAll(String date, Integer paid, String keyword);
}
