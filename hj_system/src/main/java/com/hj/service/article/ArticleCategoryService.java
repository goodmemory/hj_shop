package com.hj.service.article;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.bo.article.ArticleCategoryBo;
import com.hj.entity.article.ArticleCategory;
import com.hj.vo.article.ArticleCategoryVo;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_article_category(文章分类表)】的数据库操作Service
 * @createDate 2023-11-04 08:26:58
 */
public interface ArticleCategoryService extends IService<ArticleCategory> {

    List<ArticleCategory> listArticleCategory();

    /**
     * 新增
     *
     * @param bo
     */
    void insertArticleCategory(ArticleCategoryBo bo);

    /**
     * 根据ID获取数据
     *
     * @param articleCategoryId
     * @return
     */
    ArticleCategoryVo getArticleCategoryById(Integer articleCategoryId);

    /**
     * 修改
     *
     * @param bo
     */
    void updateArticleCategory(ArticleCategoryBo bo);

    /**
     * 修改是否显示状态
     *
     * @param articleCategoryId
     */
    void updateIsShow(Integer articleCategoryId, Integer isShow);

    /**
     * 删除
     *
     * @param articleCategoryId
     */
    void deleteArticleCategory(Integer articleCategoryId);
}
