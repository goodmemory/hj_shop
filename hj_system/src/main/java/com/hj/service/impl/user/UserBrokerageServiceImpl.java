package com.hj.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.user.UserBrokerageBo;
import com.hj.constant.ConstantParams;
import com.hj.enums.ResponseStatusEnum;
import com.hj.entity.user.UserBrokerage;
import com.hj.exceptions.GraceException;
import com.hj.mapper.user.UserBrokerageMapper;
import com.hj.service.user.UserBrokerageService;
import com.hj.util.DateUtil;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.UserBrokerageVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_brokerage】的数据库操作Service实现
 * @createDate 2023-11-01 10:58:09
 */
@Service
@Slf4j
public class UserBrokerageServiceImpl extends ServiceImpl<UserBrokerageMapper, UserBrokerage>
        implements UserBrokerageService {

    @Autowired
    private UserBrokerageMapper userBrokerageMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 获取所有会员权益分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getUserBrokerageList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<UserBrokerage> list = userBrokerageMapper.selectList(new LambdaQueryWrapper<UserBrokerage>()
                .eq(UserBrokerage::getStatus, ConstantParams.COMMON_STATUS_1)
                .eq(UserBrokerage::getType, ConstantParams.COMMON_STATUS_1)
                .orderByDesc(UserBrokerage::getBrokerageLevel));
        log.info("获取所有用户组分页数据：" + list.toString());
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 新增会员等级
     *
     * @param bo
     */
    @Override
    public void insertUserBrokerage(UserBrokerageBo bo) {
        UserBrokerage userBrokerage = validateUserBrokerage(bo);
        //会员等级不能重复
        UserBrokerage brokerage = userBrokerageMapper.selectOne(new LambdaQueryWrapper<UserBrokerage>()
                .eq(UserBrokerage::getBrokerageLevel, bo.getBrokerageLevel())
                .eq(UserBrokerage::getStatus, ConstantParams.COMMON_STATUS_1));
        if (brokerage != null && brokerage.getBrokerageLevel() == bo.getBrokerageLevel()) {
            log.error("UserBrokerageServiceImpl===>insertUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_NOT_SAME.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_NOT_SAME);
        }
        userBrokerage.setUserBrokerageId(idWorker.nextId());
        int index = userBrokerageMapper.insert(userBrokerage);
        if (index == 0) {
            log.error("UserBrokerageServiceImpl===>insertUserBrokerage:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 校验字段是否为空
     *
     * @param bo
     * @return
     */
    private UserBrokerage validateUserBrokerage(UserBrokerageBo bo) {
        if (StringUtils.isEmpty(bo.getBrokerageName())) {
            log.error("UserBrokerageServiceImpl===>insertUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_NAME_NOT_NULL);
        }
        if (bo.getBrokerageLevel() == null) {
            log.error("UserBrokerageServiceImpl===>insertUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getBrokerageIcon())) {
            log.error("UserBrokerageServiceImpl===>insertUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_ICON_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_ICON_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getImage())) {
            log.error("UserBrokerageServiceImpl===>insertUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_IMAGE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_IMAGE_NOT_NULL);
        }
        if (bo.getValue() == null) {
            log.error("UserBrokerageServiceImpl===>insertUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_VALUE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_VALUE_NOT_NULL);
        }
        if (bo.getIntegralRatio() == null) {
            log.error("UserBrokerageServiceImpl===>insertUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_RATIO_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_RATIO_NOT_NULL);
        }
        UserBrokerage userBrokerage = new UserBrokerage();
        BeanUtils.copyProperties(bo, userBrokerage);
        return userBrokerage;
    }

    /**
     * 根据id获取会员等级信息
     *
     * @param userBrokerageId
     * @return
     */
    @Override
    public UserBrokerageVo getUserBrokerageById(Long userBrokerageId) {
        if (userBrokerageId == null) {
            log.error("UserBrokerageServiceImpl===>getUserBrokerageById:" + ResponseStatusEnum.MEMBER_LEVEL_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_ID_NOT_NULL);
        }
        UserBrokerage brokerage = userBrokerageMapper.selectOne(new LambdaQueryWrapper<UserBrokerage>()
                .eq(UserBrokerage::getUserBrokerageId, userBrokerageId)
                .eq(UserBrokerage::getStatus, ConstantParams.COMMON_STATUS_1));
        UserBrokerageVo userBrokerageVo = new UserBrokerageVo();
        BeanUtils.copyProperties(brokerage, userBrokerageVo);
        return userBrokerageVo;
    }

    /**
     * 修改会员等级
     *
     * @param bo
     */
    @Override
    public void updateUserBrokerage(UserBrokerageBo bo) {
        UserBrokerage userBrokerage = validateUserBrokerage(bo);
        if (userBrokerage.getUserBrokerageId() == null) {
            log.error("UserBrokerageServiceImpl===>updateUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_ID_NOT_NULL);
        }
        userBrokerage.setUpdateTime(DateUtil.getCurrentDateTime());
        int index = userBrokerageMapper.updateById(userBrokerage);
        if (index == 0) {
            log.error("UserBrokerageServiceImpl===>updateUserBrokerage:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除会员等级
     *
     * @param userBrokerageId
     */
    @Override
    public void deleteUserBrokerage(Long userBrokerageId) {
        if (userBrokerageId == null) {
            log.error("UserBrokerageServiceImpl===>deleteUserBrokerage:" + ResponseStatusEnum.MEMBER_LEVEL_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MEMBER_LEVEL_ID_NOT_NULL);
        }
        UserBrokerage userBrokerage = new UserBrokerage();
        userBrokerage.setUserBrokerageId(userBrokerageId);
        userBrokerage.setStatus(ConstantParams.COMMON_STATUS_0);
        userBrokerage.setUpdateTime(DateUtil.getCurrentDateTime());
        boolean flag = this.updateById(userBrokerage);
        if (!flag) {
            log.error("UserBrokerageServiceImpl===>deleteUserBrokerage:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




