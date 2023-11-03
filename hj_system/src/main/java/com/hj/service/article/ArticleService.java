package com.hj.service.article;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.article.ArticleBo;
import com.hj.entity.article.Article;
import com.hj.util.PagedGridResult;
import com.hj.vo.article.ArticleVo;

/**
 * @author mayaoqi
 * @description 针对表【eb_article(文章管理表)】的数据库操作Service
 * @createDate 2023-11-02 22:42:03
 */
public interface ArticleService extends IService<Article> {

    /**
     * 获取所有文章分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getArticleList(String title, Integer page, Integer pageSize);

    /**
     * 添加文章
     *
     * @param bo
     */
    void insertArticle(ArticleBo bo);

    /**
     * 修改是否显示
     *
     * @param articleId
     */
    void updateIsShow(String articleId, Integer isShow);

    /**
     * 根据id获取文章详情
     *
     * @param articleId
     * @return
     */
    ArticleVo getArticleInfoById(String articleId);

    /**
     * 修改文章
     *
     * @param bo
     */
    void updateArticle(ArticleBo bo);

    /**
     * 删除文章
     *
     * @param articleId
     */
    void deleteArticle(String articleId);
}
