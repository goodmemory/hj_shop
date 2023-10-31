package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.FeedbackCategory;
import com.hj.vo.FeedbackCategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_feedback_category(用户反馈分类表)】的数据库操作Mapper
 * @createDate 2023-10-30 09:38:48
 * @Entity com.hj.FeedbackCategory
 */
@Mapper
public interface FeedbackCategoryMapper extends BaseMapper<FeedbackCategory> {

    List<FeedbackCategoryVo> getParentFeedbackCategory();
}




