package com.hj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.entity.user.UserBill;
import com.hj.mapper.UserBillMapper;
import com.hj.service.UserBillService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import com.hj.vo.finance.UserBillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_bill(用户账单表)】的数据库操作Service实现
 * @createDate 2023-11-21 23:07:54
 */
@Service
public class UserBillServiceImpl extends ServiceImpl<UserBillMapper, UserBill>
        implements UserBillService {

    @Autowired
    private UserBillMapper userBillMapper;

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
    @Override
    public PagedGridResult getUserBillListPage(Integer page, Integer pageSize, String date, String type, String keyword) {
        PageHelper.startPage(page, pageSize);
        HashMap<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(date)) {
            if (date.contains("-")) {
                String[] split = date.split("-");
                String beginDate = DateUtil.parsFormatDate(split[0]);
                String endDate = DateUtil.parsFormatDate(split[1]);
                map.put("beginDate", beginDate);
                map.put("endDate", endDate);
            }
            map.put("date", date);
        }
        if (!StringUtils.isEmpty(type)) {
            map.put("type", type);
        }
        if (!StringUtils.isEmpty(keyword)) {
            map.put("keyword", keyword);
        }
        List<UserBillVo> listPage = userBillMapper.getUserBillListPage(map);
        return PagedGridResult.setterPagedGrid(listPage, page);
    }
}




