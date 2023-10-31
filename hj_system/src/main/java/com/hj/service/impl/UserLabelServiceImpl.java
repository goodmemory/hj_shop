package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.UserLabelBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.UserLabel;
import com.hj.mapper.UserLabelMapper;
import com.hj.service.UserLabelService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import com.hj.vo.UserLabelVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_label(用户标签表)】的数据库操作Service实现
 * @createDate 2023-10-24 22:23:14
 */
@Service
public class UserLabelServiceImpl extends ServiceImpl<UserLabelMapper, UserLabel>
        implements UserLabelService {

    @Autowired
    private UserLabelMapper userLabelMapper;

    /**
     * 获取所有用户标签分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getUserLabelList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<UserLabel> list = userLabelMapper.selectList(
                new LambdaQueryWrapper<UserLabel>().eq(UserLabel::getStatus, ConstantParams.COMMON_STATUS_1)
                        .orderByDesc(UserLabel::getCreateTime));
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 新增用户标签
     *
     * @param labelName
     */
    @Override
    public Integer insertUserLabel(String labelName) {
        UserLabel userLabel = new UserLabel();
        userLabel.setLabelName(labelName);
        return userLabelMapper.insert(userLabel);
    }

    /**
     * 根据id获取用户标签信息
     *
     * @param labelId
     * @return
     */
    @Override
    public UserLabelVo getUserLabelInfoById(Integer labelId) {
        UserLabel userLabel = this.getById(labelId);
        UserLabelVo userLabelVo = new UserLabelVo();
        BeanUtils.copyProperties(userLabel, userLabelVo);
        return userLabelVo;
    }

    /**
     * 修改用户标签
     *
     * @param bo
     * @return
     */
    @Override
    public Boolean updateUserLabel(UserLabelBo bo) {
        UserLabel userLabel = new UserLabel();
        BeanUtils.copyProperties(bo, userLabel);
        userLabel.setUpdateTime(DateUtil.getCurrentDateTime());
        return this.updateById(userLabel);
    }

    /**
     * 删除用户组
     *
     * @param labelId
     * @return
     */
    @Override
    public Boolean deleteUserLabelById(Integer labelId) {
        UserLabel userLabel = new UserLabel();
        userLabel.setLabelId(labelId);
        userLabel.setStatus(ConstantParams.COMMON_STATUS_0);
        userLabel.setUpdateTime(DateUtil.getCurrentDateTime());
        return this.updateById(userLabel);
    }
}




