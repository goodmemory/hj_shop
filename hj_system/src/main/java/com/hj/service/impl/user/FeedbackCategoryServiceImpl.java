package com.hj.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.user.FeedbackCategoryBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.user.FeedbackCategory;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.user.FeedbackCategoryMapper;
import com.hj.service.user.FeedbackCategoryService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import com.hj.vo.user.FeedbackCategory1Vo;
import com.hj.vo.user.FeedbackCategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_feedback_category(用户反馈分类表)】的数据库操作Service实现
 * @createDate 2023-10-30 09:38:48
 */
@Service
@Slf4j
public class FeedbackCategoryServiceImpl extends ServiceImpl<FeedbackCategoryMapper, FeedbackCategory>
        implements FeedbackCategoryService {

    @Autowired
    private FeedbackCategoryMapper feedbackCategoryMapper;

    /**
     * 获取所有投诉分类分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getFeedbackCategoryList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<FeedbackCategoryVo> categoryVos = getFeedbackCategoryList();
        return PagedGridResult.setterPagedGrid(categoryVos, page);
    }

    /**
     * 获取所有投诉分类
     *
     * @return
     */
    public List<FeedbackCategoryVo> getFeedbackCategoryList() {
        List<FeedbackCategoryVo> categoryVos = feedbackCategoryMapper.getParentFeedbackCategory();
        for (FeedbackCategoryVo categoryVo : categoryVos) {
            List<FeedbackCategory> list = feedbackCategoryMapper.selectList(
                    new LambdaQueryWrapper<FeedbackCategory>()
                            .eq(FeedbackCategory::getStatus, ConstantParams.COMMON_STATUS_1)
                            .eq(FeedbackCategory::getPid, categoryVo.getFeedbackCategoryId())
                            .orderByDesc(FeedbackCategory::getSort));
            categoryVo.setFeedbackCategoryList(list);
        }
        return categoryVos;
    }

    /**
     * 新增投诉分类
     *
     * @param bo
     */
    @Override
    public void insertFeedbackCategory(FeedbackCategoryBo bo) {
        if (bo.getPid() == null) {
            log.error("FeedbackCategoryServiceImpl===>insertFeedbackCategory:" + ResponseStatusEnum.FEEDBACK_CATEGORY_PARENT_LABEL_ERROR.msg());
            GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_PARENT_LABEL_ERROR);
        }
        if (bo.getCateName() == null) {
            log.error("FeedbackCategoryServiceImpl===>insertFeedbackCategory:" + ResponseStatusEnum.FEEDBACK_CATEGORY_NAME_ERROR.msg());
            GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_NAME_ERROR);
        }
        FeedbackCategory feedbackCategory = new FeedbackCategory();
        if (bo.getPid() != 0) {
            FeedbackCategory category = this.getById(bo.getPid());
            if (category.getPid() != 0) {
                log.error("FeedbackCategoryServiceImpl===>insertFeedbackCategory:" + ResponseStatusEnum.FEEDBACK_CATEGORY_ERROR.msg());
                GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_ERROR);
            } else {
                feedbackCategory.setPath("/" + bo.getPid() + "/");
            }
        } else {
            feedbackCategory.setPath("/");
        }
        BeanUtils.copyProperties(bo, feedbackCategory);
        int index = feedbackCategoryMapper.insert(feedbackCategory);
        if (index == 0) {
            log.error("FeedbackCategoryServiceImpl===>insertFeedbackCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据id获取投诉分类信息
     *
     * @param feedbackCategoryId
     * @return
     */
    @Override
    public FeedbackCategory1Vo getFeedbackCategoryById(Integer feedbackCategoryId) {
        if (feedbackCategoryId == null) {
            log.error("FeedbackCategoryServiceImpl===>getFeedbackCategoryById:" + ResponseStatusEnum.FEEDBACK_CATEGORY_ID_ERROR.msg());
            GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_ID_ERROR);
        }
        FeedbackCategory1Vo category1Vo = new FeedbackCategory1Vo();
        List<FeedbackCategoryVo> categoryVos = getFeedbackCategoryList();
        FeedbackCategory feedbackCategory = this.getById(feedbackCategoryId);
        BeanUtils.copyProperties(feedbackCategory, category1Vo);
        category1Vo.setFeedbackCategoryVoList(categoryVos);
        log.info("根据id获取投诉分类信息:" + category1Vo.toString());
        return category1Vo;
    }

    /**
     * 修改投诉分类
     *
     * @param bo
     * @return
     */
    @Override
    public void updateFeedbackCategory(FeedbackCategoryBo bo) {
        if (bo.getFeedbackCategoryId() == null) {
            log.error("FeedbackCategoryServiceImpl===>updateFeedbackCategory:" + ResponseStatusEnum.FEEDBACK_CATEGORY_ID_ERROR.msg());
            GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_ID_ERROR);
        }
        if (bo.getPid() == null) {
            log.error("FeedbackCategoryServiceImpl===>updateFeedbackCategory:" + ResponseStatusEnum.FEEDBACK_CATEGORY_PARENT_LABEL_ERROR.msg());
            GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_PARENT_LABEL_ERROR);
        }
        if (bo.getCateName() == null) {
            log.error("FeedbackCategoryServiceImpl===>updateFeedbackCategory:" + ResponseStatusEnum.FEEDBACK_CATEGORY_NAME_ERROR.msg());
            GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_NAME_ERROR);
        }
        FeedbackCategory feedbackCategory = new FeedbackCategory();
        if (bo.getPid() != 0) {
            FeedbackCategory category = this.getById(bo.getPid());
            if (category.getPid() != 0) {
                log.error("FeedbackCategoryServiceImpl===>updateFeedbackCategory:" + ResponseStatusEnum.FEEDBACK_CATEGORY_ERROR.msg());
                GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_ERROR);
            } else {
                feedbackCategory.setPath("/" + bo.getPid() + "/");
            }
        } else {
            feedbackCategory.setPath("/");
        }
        BeanUtils.copyProperties(bo, feedbackCategory);
        feedbackCategory.setUpdateTime(DateUtil.getCurrentDateTime());
        boolean flag = this.updateById(feedbackCategory);
        if (!flag) {
            log.error("FeedbackCategoryServiceImpl===>updateFeedbackCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除投诉分类
     *
     * @param feedbackCategoryId
     * @return
     */
    @Override
    public void deleteFeedbackCategoryById(Integer feedbackCategoryId) {
        if (feedbackCategoryId == null) {
            log.error("FeedbackCategoryServiceImpl===>deleteFeedbackCategoryById:" + ResponseStatusEnum.FEEDBACK_CATEGORY_ID_ERROR.msg());
            GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_ID_ERROR);
        }
        FeedbackCategory feedbackCategory = new FeedbackCategory();
        feedbackCategory.setFeedbackCategoryId(feedbackCategoryId);
        feedbackCategory.setStatus(ConstantParams.COMMON_STATUS_0);
        feedbackCategory.setUpdateTime(DateUtil.getCurrentDateTime());
        boolean flag = this.updateById(feedbackCategory);
        if (!flag) {
            log.error("FeedbackCategoryServiceImpl===>deleteFeedbackCategoryById:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改分类显示状态
     *
     * @param bo
     * @return
     */
    @Override
    public void updateShowStatus(FeedbackCategoryBo bo) {
        if (bo.getFeedbackCategoryId() == null) {
            log.error("FeedbackCategoryServiceImpl===>updateShowStatus:" + ResponseStatusEnum.FEEDBACK_CATEGORY_ID_ERROR);
            GraceException.display(ResponseStatusEnum.FEEDBACK_CATEGORY_ID_ERROR);
        }
        FeedbackCategory feedbackCategory = new FeedbackCategory();
        BeanUtils.copyProperties(bo, feedbackCategory);
        boolean flag = this.updateById(feedbackCategory);
        if (!flag) {
            log.error("FeedbackCategoryServiceImpl===>updateShowStatus:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




