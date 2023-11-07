package com.hj.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.user.UserLabelBo;
import com.hj.entity.user.UserLabel;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.UserLabelVo;

/**
 * @author mayaoqi
 * @description 针对表【eb_user_label(用户标签表)】的数据库操作Service
 * @createDate 2023-10-24 22:23:14
 */
public interface UserLabelService extends IService<UserLabel> {

    /**
     * 获取所有用户标签分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getUserLabelList(Integer page, Integer pageSize);

    /**
     * 新增用户标签
     *
     * @param labelName
     */
    Integer insertUserLabel(String labelName);

    /**
     * 根据id获取用户标签信息
     *
     * @param labelId
     * @return
     */
    UserLabelVo getUserLabelInfoById(Long labelId);

    /**
     * 修改用户标签
     *
     * @param bo
     * @return
     */
    Boolean updateUserLabel(UserLabelBo bo);

    /**
     * 删除用户组
     *
     * @param labelId
     * @return
     */
    Boolean deleteUserLabelById(Long labelId);

}
