package com.hj.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.user.FeedbackBo;
import com.hj.entity.user.Feedback;
import com.hj.util.PagedGridResult;

/**
 * @author mayaoqi
 * @description 针对表【eb_feedback(用户反馈表)】的数据库操作Service
 * @createDate 2023-10-30 10:52:47
 */
public interface FeedbackService extends IService<Feedback> {

    /**
     * 获取所有投诉分类分页显示
     *
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    PagedGridResult getFeedbackList(String keyword, Integer page, Integer pageSize);

    /**
     * 回复消息
     *
     * @param bo
     * @return
     */
    void replayContent(FeedbackBo bo);

    /**
     * 删除消息
     *
     * @param feedbackId
     * @return
     */
    void deleteContent(Integer feedbackId);

}
