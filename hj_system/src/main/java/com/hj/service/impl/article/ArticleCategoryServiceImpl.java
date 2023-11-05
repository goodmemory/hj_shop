package com.hj.service.impl.article;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.bo.article.ArticleCategoryBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.article.ArticleCategory;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.article.ArticleCategoryMapper;
import com.hj.service.article.ArticleCategoryService;
import com.hj.util.DateUtil;
import com.hj.vo.article.ArticleCategoryVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_article_category(文章分类表)】的数据库操作Service实现
 * @createDate 2023-11-04 08:26:58
 */
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory>
        implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Override
    public List<ArticleCategory> listArticleCategory() {
        List<ArticleCategory> categoryList = articleCategoryMapper.selectList(new LambdaQueryWrapper<ArticleCategory>()
                .eq(ArticleCategory::getStatus, ConstantParams.COMMON_STATUS_1));
        return categoryList;
    }

    /**
     * 新增
     *
     * @param bo
     */
    @Override
    public void insertArticleCategory(ArticleCategoryBo bo) {
        if (StringUtils.isEmpty(bo.getTitle())) {
            log.error("ArticleCategoryServiceImpl===>insertArticleCategory:" + ResponseStatusEnum.ARTICLE_CATEGORY_TITLE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_CATEGORY_TITLE_NOT_NULL);
        }
        ArticleCategory category = new ArticleCategory();
        BeanUtils.copyProperties(bo, category);
        int index = articleCategoryMapper.insert(category);
        if (index == 0) {
            log.error("ArticleCategoryServiceImpl===>insertArticleCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据ID获取数据
     *
     * @param articleCategoryId
     * @return
     */
    @Override
    public ArticleCategoryVo getArticleCategoryById(Integer articleCategoryId) {
        if (articleCategoryId == null || articleCategoryId == 0) {
            log.error("ArticleCategoryServiceImpl===>getArticleCategoryById:" + ResponseStatusEnum.ARTICLE_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_CATEGORY_ID_NOT_NULL);
        }
        ArticleCategory articleCategory = articleCategoryMapper.selectOne(new LambdaQueryWrapper<ArticleCategory>()
                .eq(ArticleCategory::getArticleCategoryId, articleCategoryId)
                .eq(ArticleCategory::getStatus, ConstantParams.COMMON_STATUS_1));
        if (articleCategory == null) {
            log.error("ArticleCategoryServiceImpl===>getArticleCategoryById:" + ResponseStatusEnum.ARTICLE_CATEGORY_NOT_EXIST.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_CATEGORY_NOT_EXIST);
        }
        ArticleCategoryVo categoryVo = new ArticleCategoryVo();
        BeanUtils.copyProperties(articleCategory, categoryVo);
        return categoryVo;
    }

    /**
     * 修改
     *
     * @param bo
     */
    @Override
    public void updateArticleCategory(ArticleCategoryBo bo) {
        if (bo.getArticleCategoryId() == null || bo.getArticleCategoryId() == 0) {
            log.error("ArticleCategoryServiceImpl===>updateArticleCategory:" + ResponseStatusEnum.ARTICLE_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_CATEGORY_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getTitle())) {
            log.error("ArticleCategoryServiceImpl===>updateArticleCategory:" + ResponseStatusEnum.ARTICLE_CATEGORY_TITLE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_CATEGORY_TITLE_NOT_NULL);
        }
        ArticleCategory articleCategory = new ArticleCategory();
        BeanUtils.copyProperties(bo, articleCategory);
        articleCategory.setUpdateTime(DateUtil.getCurrentDateTime());
        int index = articleCategoryMapper.updateById(articleCategory);
        if (index == 0) {
            log.error("ArticleCategoryServiceImpl===>insertArticleCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改是否显示状态
     *
     * @param articleCategoryId
     */
    @Override
    public void updateIsShow(Integer articleCategoryId, Integer isShow) {
        if (articleCategoryId == null || articleCategoryId == 0) {
            log.error("ArticleCategoryServiceImpl===>getArticleCategoryById:" + ResponseStatusEnum.ARTICLE_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_CATEGORY_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<ArticleCategory>().set(ArticleCategory::getIsShow, isShow)
                .eq(ArticleCategory::getArticleCategoryId, articleCategoryId));
        if (!flag) {
            log.error("ArticleCategoryServiceImpl===>updateIsShow:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除
     *
     * @param articleCategoryId
     */
    @Override
    public void deleteArticleCategory(Integer articleCategoryId) {
        if (articleCategoryId == null || articleCategoryId == 0) {
            log.error("ArticleCategoryServiceImpl===>deleteArticleCategory:" + ResponseStatusEnum.ARTICLE_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_CATEGORY_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<ArticleCategory>().set(ArticleCategory::getStatus, ConstantParams.COMMON_STATUS_0)
                .eq(ArticleCategory::getArticleCategoryId, articleCategoryId));
        if (!flag) {
            log.error("ArticleCategoryServiceImpl===>updateIsShow:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




