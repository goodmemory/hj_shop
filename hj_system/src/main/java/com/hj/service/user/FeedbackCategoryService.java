package com.hj.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.user.FeedbackCategoryBo;
import com.hj.entity.user.FeedbackCategory;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.FeedbackCategory1Vo;
import com.hj.vo.user.FeedbackCategoryVo;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_feedback_category(用户反馈分类表)】的数据库操作Service
 * @createDate 2023-10-30 09:38:48
 */
public interface FeedbackCategoryService extends IService<FeedbackCategory> {

    /**
     * 获取所有投诉分类分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getFeedbackCategoryList(Integer page, Integer pageSize);

    /**
     * 获取所有投诉分类
     *
     * @return
     */
    List<FeedbackCategoryVo> getFeedbackCategoryList();

    /**
     * 新增投诉分类
     *
     * @param bo
     */
    void insertFeedbackCategory(FeedbackCategoryBo bo);

    /**
     * 根据id获取投诉分类信息
     *
     * @param feedbackCategoryId
     * @return
     */
    FeedbackCategory1Vo getFeedbackCategoryById(Integer feedbackCategoryId);

    /**
     * 修改投诉分类
     *
     * @param bo
     * @return
     */
    void updateFeedbackCategory(FeedbackCategoryBo bo);

    /**
     * 删除投诉分类
     *
     * @param feedbackCategoryId
     * @return
     */
    void deleteFeedbackCategoryById(Integer feedbackCategoryId);

    /**
     * 修改分类显示状态
     *
     * @param bo
     * @return
     */
    void updateShowStatus(FeedbackCategoryBo bo);
}
