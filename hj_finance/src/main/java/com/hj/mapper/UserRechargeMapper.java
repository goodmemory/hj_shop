package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.finance.UserRecharge;
import com.hj.vo.finance.UserRechargeVo;

import java.util.HashMap;
import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_recharge(用户充值表)】的数据库操作Mapper
 * @createDate 2023-11-20 22:29:58
 * @Entity com.hj.UserRecharge
 */
public interface UserRechargeMapper extends BaseMapper<UserRecharge> {

    List<UserRechargeVo> getUserRechargeListPage(HashMap<String, Object> map);
}




