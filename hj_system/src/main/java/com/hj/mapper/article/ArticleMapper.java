package com.hj.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.entity.article.Article;
import com.hj.vo.article.ArticleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_article(文章管理表)】的数据库操作Mapper
 * @createDate 2023-11-02 22:42:03
 * @Entity com.hj.Article
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 获取所有文章
     *
     * @param title
     * @return
     */
    List<ArticleVo> getArticleList(@Param("title") String title);
}




