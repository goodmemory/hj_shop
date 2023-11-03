package com.hj.service.impl.user;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdcardUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.user.UserBo;
import com.hj.bo.user.UserListBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.user.User;
import com.hj.entity.user.UserBill;
import com.hj.entity.user.UserGroup;
import com.hj.entity.user.UserLabel;
import com.hj.enums.ResponseStatusEnum;
import com.hj.enums.UserEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.user.UserBillMapper;
import com.hj.mapper.user.UserGroupMapper;
import com.hj.mapper.user.UserLabelMapper;
import com.hj.mapper.user.UserMapper;
import com.hj.service.user.UserService;
import com.hj.util.AESUtil;
import com.hj.util.DateUtil;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_user(用户表)】的数据库操作Service实现
 * @createDate 2023-11-01 14:36:01
 */
@Service
@Slf4j
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UserLabelMapper userLabelMapper;
    @Autowired
    private UserGroupMapper userGroupMapper;
    @Autowired
    private UserBillMapper userBillMapper;

    /**
     * 获取所有用户分页显示
     *
     * @param bo
     * @return
     */
    @Override
    public PagedGridResult getUserList(UserBo bo) {
        PageHelper.startPage(bo.getPage(), bo.getPageSize());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(bo.getUserType())) {
            wrapper.eq(User::getUserType, bo.getUserType());
        }
        if (StringUtils.isNotEmpty(bo.getNickname())) {
            wrapper.eq(User::getNickname, bo.getNickname());
        }
        if (StringUtils.isNotEmpty(bo.getPhone())) {
            wrapper.eq(User::getPhone, bo.getPhone());
        }
        if (bo.getGroupId() != ConstantParams.COMMON_STATUS_0) {
            wrapper.eq(User::getGroupId, bo.getGroupId());
        }
        if (bo.getLabelId() != ConstantParams.COMMON_STATUS_0) {
            wrapper.eq(User::getLabelId, bo.getLabelId());
        }
        if (bo.getSex() != null) {
            wrapper.eq(User::getSex, bo.getSex());
        }
        //身份：推广员，普通会员
        if (bo.getIsPromoter() != null) {
            wrapper.eq(User::getIsPromoter, bo.getIsPromoter());
        }
        //消费情况（付费次数）
        if (bo.getPayCount() != null) {
            wrapper.le(User::getPayCount, bo.getPayCount());
        }
        //访问情况+访问时间的条件筛选
        //todo

        wrapper.eq(User::getStatus, ConstantParams.COMMON_STATUS_1);
        List<User> list = userMapper.selectList(wrapper);
        log.info("UserServiceImpl====>getUserList" + list.toString());
        return PagedGridResult.setterPagedGrid(list, bo.getPage());
    }

    /**
     * 新增用户
     *
     * @param bo
     */
    @Override
    public void insertUser(UserBo bo) {
        validateUserInfo(bo);
        //判断当前账号是否已存在
        User user1 = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getAccount, bo.getAccount())
                .eq(User::getStatus, ConstantParams.COMMON_STATUS_1));
        if (user1 != null && user1.getAccount().equals(bo.getAccount())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_ACCOUNT_EXIST.msg());
            GraceException.display(ResponseStatusEnum.USER_ACCOUNT_EXIST);
        }
        User user = new User();
        BeanUtils.copyProperties(bo, user);
        user.setUid("u" + idWorker.nextId());
        user.setUserType(UserEnum.USER_HJ.tag());
        user.setPwd(AESUtil.encryptAES(bo.getPwd()));
        int index = userMapper.insert(user);
        if (index == 0) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 编辑用户
     *
     * @param bo
     */
    @Override
    public void updateUser(UserBo bo) {
        validateUserInfo(bo);
        if (StringUtils.isEmpty(bo.getUid())) {
            log.error("UserServiceImpl===>getUserById:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        User user = new User();
        BeanUtils.copyProperties(bo, user);
        user.setUpdateTime(DateUtil.getCurrentDateTime());
        int index = userMapper.updateById(user);
        if (index == 0) {
            log.error("UserServiceImpl===>updateUser:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 用户信息校验
     *
     * @param bo
     */
    private void validateUserInfo(UserBo bo) {
        if (StringUtils.isEmpty(bo.getAccount())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_ACCOUNT_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ACCOUNT_NOT_NULL);
        }
        if (!Validator.isMobile(bo.getAccount())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_ACCOUNT_INVALID.msg());
            GraceException.display(ResponseStatusEnum.USER_ACCOUNT_INVALID);
        }
        if (StringUtils.isEmpty(bo.getPwd())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_PSW_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_PSW_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getConfirmPwd())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_CONFIRM_PSW_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_CONFIRM_PSW_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getNickname())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_NICKNAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_NICKNAME_NOT_NULL);
        }
        if (StringUtils.isNotEmpty(bo.getPhone()) && !Validator.isMobile(bo.getPhone())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_PHONE_INVALID.msg());
            GraceException.display(ResponseStatusEnum.USER_PHONE_INVALID);
        }
        if (StringUtils.isNotEmpty(bo.getCardId()) && !IdcardUtil.isValidCard(bo.getCardId())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_CARDID_INVALID.msg());
            GraceException.display(ResponseStatusEnum.USER_CARDID_INVALID);
        }
        if (!bo.getPwd().equals(bo.getConfirmPwd())) {
            log.error("UserServiceImpl===>insertUser:" + ResponseStatusEnum.USER_CONFIRM_PSW_NO_SAME.msg());
            GraceException.display(ResponseStatusEnum.USER_CONFIRM_PSW_NO_SAME);
        }
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param uid
     * @return
     */
    @Override
    public UserVo getUserById(String uid) {
        if (StringUtils.isEmpty(uid)) {
            log.error("UserServiceImpl===>getUserById:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUid, uid));
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);

        List<UserGroup> userGroupList = userGroupMapper.selectList(new LambdaQueryWrapper<UserGroup>()
                .eq(UserGroup::getStatus, ConstantParams.COMMON_STATUS_1));
        userVo.setGroupList(userGroupList);

        List<UserLabel> userLabelList = userLabelMapper.selectList(new LambdaQueryWrapper<UserLabel>()
                .eq(UserLabel::getStatus, ConstantParams.COMMON_STATUS_1));
        userVo.setLabelList(userLabelList);
        return userVo;
    }

    /**
     * 设置红旌币
     *
     * @param uid
     * @param nowMoney
     * @param type     0：红旌币减少 1:红旌币增加
     */
    @Override
    public void setupMoney(String uid, BigDecimal nowMoney, Integer type) {
        if (StringUtils.isEmpty(uid)) {
            log.error("UserServiceImpl===>setupMoney:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUid, uid)
                .eq(User::getStatus, ConstantParams.COMMON_STATUS_1));
        //将操作数据存入账单表
        UserBill userBill = new UserBill();
        userBill.setUid(uid);
        userBill.setPm(type);
        userBill.setBillId("b" + idWorker.nextId());
        userBill.setCategory("now_money");
        userBill.setType("sys_inc_money");

        BigDecimal money = null;
        if (type == ConstantParams.COMMON_STATUS_0) {
            money = user.getNowMoney().subtract(nowMoney);
            if (money.compareTo(BigDecimal.ZERO) == -1) {
                log.error("UserServiceImpl===>setupMoney:" + ResponseStatusEnum.USER_MONEY_NOT_NEGATIVE.msg());
                GraceException.display(ResponseStatusEnum.USER_MONEY_NOT_NEGATIVE);
            }
            userBill.setNumber(nowMoney);
            userBill.setBalance(money);
            userBill.setTitle("系统减少余额");
            userBill.setMark("系统减少了" + nowMoney + "余额");
        } else if (type == ConstantParams.COMMON_STATUS_1) {
            money = user.getNowMoney().add(nowMoney);
            userBill.setNumber(nowMoney);
            userBill.setBalance(money);
            userBill.setTitle("系统增加余额");
            userBill.setMark("系统增加了" + nowMoney + "余额");
        }
        boolean flag = this.update(new LambdaUpdateWrapper<User>().set(User::getNowMoney, money).eq(User::getUid, uid));
        if (!flag) {
            log.error("UserServiceImpl===>setupMoney:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
        userBillMapper.insert(userBill);
    }

    /**
     * 设置积分
     *
     * @param uid
     * @param nowIntegral
     * @param type
     */
    @Override
    public void setupIntegral(String uid, Integer nowIntegral, Integer type) {
        if (StringUtils.isEmpty(uid)) {
            log.error("UserServiceImpl===>setupMoney:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUid, uid)
                .eq(User::getStatus, ConstantParams.COMMON_STATUS_1));
        Integer integral = null;
        if (type == ConstantParams.COMMON_STATUS_0) {
            integral = user.getIntegral() - nowIntegral;
            if (integral < 0) {
                log.error("UserServiceImpl===>setupIntegral:" + ResponseStatusEnum.USER_INTEGRAL_NOT_NEGATIVE.msg());
                GraceException.display(ResponseStatusEnum.USER_INTEGRAL_NOT_NEGATIVE);
            }
        } else if (type == ConstantParams.COMMON_STATUS_1) {
            integral = user.getIntegral() + nowIntegral;
        }
        boolean flag = this.update(new LambdaUpdateWrapper<User>().set(User::getIntegral, integral).eq(User::getUid, uid));
        if (!flag) {
            log.error("UserServiceImpl===>setupIntegral:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 设置用户组
     *
     * @param bo
     */
    @Override
    public void setupUserGroup(UserListBo bo) {
        if (CollectionUtils.isEmpty(bo.getUids())) {
            log.error("UserServiceImpl===>setupUserGroup:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        Integer index = userMapper.updateBatchGroupId(bo);
        if (index == 0) {
            log.error("UserServiceImpl===>setupUserGroup:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 设置用户标签
     *
     * @param bo
     */
    @Override
    public void setupUserLabel(UserListBo bo) {
        if (CollectionUtils.isEmpty(bo.getUids())) {
            log.error("UserServiceImpl===>setupUserLabel:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        Integer index = userMapper.updateBatchGroupId(bo);
        if (index == 0) {
            log.error("UserServiceImpl===>setupUserLabel:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改推荐人
     *
     * @param uid
     * @param spreadUid
     */
    @Override
    public void setupSpreadUser(String uid, String spreadUid) {
        if (StringUtils.isEmpty(uid)) {
            log.error("UserServiceImpl===>setupSpreadUser:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<User>().set(User::getSpreadUid, spreadUid).eq(User::getUid, uid));
        if (!flag) {
            log.error("UserServiceImpl===>setupSpreadUser:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改密码
     *
     * @param account
     * @param pwd
     * @param rePwd
     */
    @Override
    public void updatePassword(String account, String pwd, String rePwd) {
        if (StringUtils.isEmpty(account)) {
            log.error("UserServiceImpl===>updatePassword:" + ResponseStatusEnum.USER_ACCOUNT_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ACCOUNT_NOT_NULL);
        }
        if (StringUtils.isEmpty(pwd)) {
            log.error("UserServiceImpl===>updatePassword:" + ResponseStatusEnum.USER_PSW_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_PSW_NOT_NULL);
        }
        if (StringUtils.isEmpty(rePwd)) {
            log.error("UserServiceImpl===>updatePassword:" + ResponseStatusEnum.USER_CONFIRM_PSW_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_CONFIRM_PSW_NOT_NULL);
        }
        if (!pwd.equals(rePwd)) {
            log.error("UserServiceImpl===>updatePassword:" + ResponseStatusEnum.USER_CONFIRM_PSW_NO_SAME.msg());
            GraceException.display(ResponseStatusEnum.USER_CONFIRM_PSW_NO_SAME);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<User>().set(User::getPwd, AESUtil.encryptAES(pwd)).eq(User::getAccount, account));
        if (!flag) {
            log.error("UserServiceImpl===>setupUserLabel:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 编辑会员等级
     *
     * @param uid
     * @param memberLevel
     */
    @Override
    public void setupMemberLevel(String uid, Integer memberLevel) {
        if (StringUtils.isEmpty(uid)) {
            log.error("UserServiceImpl===>setupMemberLevel:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<User>().set(User::getMemberLevel, memberLevel).eq(User::getUid, uid));
        if (!flag) {
            log.error("UserServiceImpl===>setupMemberLevel:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 用户详情：红旌币变动
     *
     * @param uid
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getMoneyInfo(String uid, Integer page, Integer pageSize) {
        if (StringUtils.isEmpty(uid)) {
            log.error("UserServiceImpl===>setupMemberLevel:" + ResponseStatusEnum.USER_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_ID_NOT_NULL);
        }
        PageHelper.startPage(page, pageSize);
        List<UserBill> billList = userBillMapper.selectList(new LambdaQueryWrapper<UserBill>()
                .eq(UserBill::getUid, uid).orderByDesc(UserBill::getCreateTime));
        return PagedGridResult.setterPagedGrid(billList, page);
    }

}




