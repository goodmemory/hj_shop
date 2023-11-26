package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.user.UserBill;
import com.hj.vo.finance.UserBillVo;

import java.util.HashMap;
import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_bill(用户账单表)】的数据库操作Mapper
 * @createDate 2023-11-21 23:07:54
 * @Entity com.hj.UserBill
 */
public interface UserBillMapper extends BaseMapper<UserBill> {

    /**
     * 根据条件获取所有账单信息 date,type,keyword
     *
     * @param map
     * @return
     */
    List<UserBillVo> getUserBillListPage(HashMap<String, Object> map);

}




