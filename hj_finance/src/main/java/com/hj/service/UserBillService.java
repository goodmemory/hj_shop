package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.entity.user.UserBill;
import com.hj.util.PagedGridResult;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_bill(用户账单表)】的数据库操作Service
 * @createDate 2023-11-21 23:07:54
 */
public interface UserBillService extends IService<UserBill> {

    /**
     * 根据条件获取所有账单信息
     *
     * @param page
     * @param pageSize
     * @param date
     * @param type
     * @param keyword
     * @return
     */
    PagedGridResult getUserBillListPage(Integer page, Integer pageSize, String date, String type, String keyword);

}
