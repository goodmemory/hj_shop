package com.hj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.entity.finance.UserRecharge;
import com.hj.mapper.UserRechargeMapper;
import com.hj.service.UserRechargeService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import com.hj.vo.finance.UserRechargeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_recharge(用户充值表)】的数据库操作Service实现
 * @createDate 2023-11-20 22:29:58
 */
@Service
public class UserRechargeServiceImpl extends ServiceImpl<UserRechargeMapper, UserRecharge>
        implements UserRechargeService {

    @Autowired
    private UserRechargeMapper userRechargeMapper;

    /**
     * 分页显示用户充值列表
     *
     * @param date
     * @param paid
     * @param keyword
     * @return
     */
    @Override
    public PagedGridResult getUserRechargeListPage(Integer page, Integer pageSize, String date, Integer paid, String keyword) {
        PageHelper.startPage(page, pageSize);
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", date);
        map.put("paid", paid);
        map.put("keyword", keyword);
        if (date.contains("-")) {
            String[] split = date.split("-");
            String begin = split[0];
            String end = split[1];
            String beginDate = DateUtil.parsFormatDate(begin);
            map.put("beginDate", beginDate);
            String endDate = DateUtil.parsFormatDate(end);
            map.put("endDate", endDate);
        }
        List<UserRechargeVo> list = userRechargeMapper.getUserRechargeListPage(map);
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 金额汇总
     *
     * @param date
     * @param paid
     * @param keyword
     * @return
     */
    @Override
    public Map<String, BigDecimal> getMoneyAll(String date, Integer paid, String keyword) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", date);
        map.put("paid", paid);
        map.put("keyword", keyword);
        if (date.contains("-")) {
            String[] split = date.split("-");
            String begin = split[0];
            String end = split[1];
            String beginDate = DateUtil.parsFormatDate(begin);
            map.put("beginDate", beginDate);
            String endDate = DateUtil.parsFormatDate(end);
            map.put("endDate", endDate);
        }
        List<UserRechargeVo> list = userRechargeMapper.getUserRechargeListPage(map);
        //前端返回显示
        Map<String, BigDecimal> result = new HashMap<>();
        BigDecimal totalPayPrice = list.stream().map(UserRechargeVo::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        result.put("totalPayPrice", totalPayPrice);
        BigDecimal totalRefundPrice = list.stream().map(UserRechargeVo::getRefundPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        result.put("totalRefundPrice", totalRefundPrice);
        //todo 小程序充值金额
        //todo 公众号充值金额
        return result;
    }
}




