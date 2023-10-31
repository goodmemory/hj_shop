package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.FeedbackBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.Feedback;
import com.hj.entity.GraceJSONResult;
import com.hj.entity.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.FeedbackMapper;
import com.hj.service.FeedbackService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_feedback(用户反馈表)】的数据库操作Service实现
 * @createDate 2023-10-30 10:52:47
 */
@Service
@Slf4j
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback>
        implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 获取所有投诉分页显示
     *
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    @Override
    public PagedGridResult getFeedbackList(String keyword, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        LambdaQueryWrapper<Feedback> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Feedback::getIsDel, ConstantParams.COMMON_STATUS_1);
        if (StringUtils.isNotEmpty(keyword)) {
            queryWrapper.like(StringUtils.isNotEmpty(keyword), Feedback::getContact, keyword)
                    .or().like(StringUtils.isNotEmpty(keyword), Feedback::getRealname, keyword)
                    .or().like(StringUtils.isNotEmpty(keyword), Feedback::getContent, keyword);
        }

        List<Feedback> list = feedbackMapper.selectList(queryWrapper);
        log.info("获取所有投诉分页显示数据：" + list.toString());
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 回复消息
     *
     * @param bo
     * @return
     */
    @Override
    public void replayContent(FeedbackBo bo) {
        if (bo.getFeedbackId() == null) {
            log.error("FeedbackServiceImpl===>replayContent:" + ResponseStatusEnum.FEEDBACK_ID_ERROR);
            GraceException.display(ResponseStatusEnum.FEEDBACK_ID_ERROR);
        }
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(bo, feedback);
        feedback.setStatus(ConstantParams.COMMON_STATUS_1);
        feedback.setUpdateTime(DateUtil.getCurrentDateTime());
        boolean flag = this.updateById(feedback);
        if (!flag) {
            log.error("FeedbackServiceImpl===>replayContent:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
            GraceJSONResult.errorCustom(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除消息
     *
     * @param feedbackId
     * @return
     */
    @Override
    public void deleteContent(Integer feedbackId) {
        if (feedbackId == null) {
            log.error("FeedbackServiceImpl===>replayContent:" + ResponseStatusEnum.FEEDBACK_ID_ERROR);
            GraceException.display(ResponseStatusEnum.FEEDBACK_ID_ERROR);
        }
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(feedbackId);
        feedback.setIsDel(ConstantParams.COMMON_STATUS_0);
        feedback.setUpdateTime(DateUtil.getCurrentDateTime());
        boolean flag = this.updateById(feedback);
        if (!flag) {
            log.error("FeedbackServiceImpl===>replayContent:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
            GraceJSONResult.errorCustom(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




