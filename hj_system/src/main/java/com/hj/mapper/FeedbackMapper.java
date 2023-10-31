package com.hj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mayaoqi
 * @description 针对表【eb_feedback(用户反馈表)】的数据库操作Mapper
 * @createDate 2023-10-30 10:52:47
 * @Entity com.hj.Feedback
 */
@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback> {

}




