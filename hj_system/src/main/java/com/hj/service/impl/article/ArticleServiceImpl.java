package com.hj.service.impl.article;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.article.ArticleBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.article.Article;
import com.hj.entity.article.ArticleContent;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.article.ArticleContentMapper;
import com.hj.mapper.article.ArticleMapper;
import com.hj.service.article.ArticleContentService;
import com.hj.service.article.ArticleService;
import com.hj.util.DateUtil;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import com.hj.vo.article.ArticleVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_article(文章管理表)】的数据库操作Service实现
 * @createDate 2023-11-02 22:42:03
 */
@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
        implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Autowired
    private ArticleContentService articleContentService;
    @Autowired
    private IdWorker idWorker;

    /**
     * 获取所有文章分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getArticleList(String title, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ArticleVo> list = articleMapper.getArticleList(title);
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 添加文章
     *
     * @param bo
     */
    @Override
    @Transactional
    public void insertArticle(ArticleBo bo) {
        validateArticle(bo);
        Article article = new Article();
        BeanUtils.copyProperties(bo, article);
        article.setArticleId("a" + idWorker.nextId());
        int index = articleMapper.insert(article);
        if (index == 0) {
            log.error("ArticleServiceImpl===>insertArticle:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        } else {
            //添加文章内容到内容表
            ArticleContent content = new ArticleContent();
            content.setArticleContentId("ac" + idWorker.nextId());
            content.setArticleId(article.getArticleId());
            content.setContent(bo.getContent());
            int index1 = articleContentMapper.insert(content);
            if (index1 == 0) {
                log.error("ArticleServiceImpl===>insertArticle:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
                GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
            }
        }

    }

    private void validateArticle(ArticleBo bo) {
        if (StringUtils.isEmpty(bo.getTitle())) {
            log.error("ArticleServiceImpl===>insertArticle:" + ResponseStatusEnum.ARTICLE_TITLE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_TITLE_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getAuthor())) {
            log.error("ArticleServiceImpl===>insertArticle:" + ResponseStatusEnum.ARTICLE_AUTHOR_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_AUTHOR_NOT_NULL);
        }
        if (bo.getCid() == null) {
            log.error("ArticleServiceImpl===>insertArticle:" + ResponseStatusEnum.ARTICLE_CATEGORY_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_CATEGORY_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getImageInput())) {
            log.error("ArticleServiceImpl===>insertArticle:" + ResponseStatusEnum.ARTICLE_IMAGE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_IMAGE_NOT_NULL);
        }
    }

    /**
     * 修改是否显示
     *
     * @param articleId
     */
    @Override
    public void updateIsShow(String articleId, Integer isShow) {
        if (StringUtils.isEmpty(articleId)) {
            log.error("ArticleServiceImpl===>updateIsShow:" + ResponseStatusEnum.ARTICLE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<Article>()
                .set(Article::getIsShow, isShow)
                .eq(Article::getArticleId, articleId));
        if (!flag) {
            log.error("ArticleServiceImpl===>insertArticle:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据id获取文章详情
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleVo getArticleInfoById(String articleId) {
        if (StringUtils.isEmpty(articleId)) {
            log.error("ArticleServiceImpl===>getArticleInfoById:" + ResponseStatusEnum.ARTICLE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_ID_NOT_NULL);
        }
        ArticleVo articleVo = new ArticleVo();
        Article article = articleMapper.selectOne(new LambdaQueryWrapper<Article>()
                .eq(Article::getArticleId, articleId).
                        eq(Article::getStatus, ConstantParams.COMMON_STATUS_1));
        if (article == null) {
            log.error("ArticleServiceImpl===>getArticleInfoById:" + ResponseStatusEnum.ARTICLE_NOT_EXIST.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_NOT_EXIST);
        }
        BeanUtils.copyProperties(article, articleVo);

        ArticleContent articleContent = articleContentMapper.selectOne(new LambdaQueryWrapper<ArticleContent>()
                .eq(ArticleContent::getArticleId, articleId)
                .eq(ArticleContent::getStatus, ConstantParams.COMMON_STATUS_1));
        articleVo.setContent(articleContent.getContent());

        return articleVo;
    }

    /**
     * 修改文章
     *
     * @param bo
     */
    @Override
    @Transactional
    public void updateArticle(ArticleBo bo) {
        if (StringUtils.isEmpty(bo.getArticleId())) {
            log.error("updateArticle===>updateArticle:" + ResponseStatusEnum.ARTICLE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_ID_NOT_NULL);
        }
        validateArticle(bo);
        Article article = new Article();
        article.setUpdateTime(DateUtil.getCurrentDateTime());
        int index = articleMapper.updateById(article);
        if (index == 0) {
            log.error("ArticleServiceImpl===>updateArticle:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        } else {
            //修改文章内容到内容表
            boolean flag = articleContentService.update(new LambdaUpdateWrapper<ArticleContent>()
                    .set(ArticleContent::getContent, bo.getContent())
                    .set(ArticleContent::getUpdateTime, DateUtil.getCurrentDate())
                    .eq(ArticleContent::getArticleId, bo.getArticleId()));
            if (!flag) {
                log.error("ArticleServiceImpl===>updateArticle:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
                GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
            }
        }
    }

    /**
     * 删除文章
     *
     * @param articleId
     */
    @Override
    public void deleteArticle(String articleId) {
        if (StringUtils.isEmpty(articleId)) {
            log.error("ArticleServiceImpl===>deleteArticle:" + ResponseStatusEnum.ARTICLE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.ARTICLE_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<Article>()
                .set(Article::getStatus, ConstantParams.COMMON_STATUS_0)
                .set(Article::getUpdateTime, DateUtil.getCurrentDate())
                .eq(Article::getArticleId, articleId));
        if (!flag) {
            log.error("ArticleServiceImpl===>deleteArticle:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        } else {
            //修改文章内容到内容表
            boolean flag1 = articleContentService.update(new LambdaUpdateWrapper<ArticleContent>()
                    .set(ArticleContent::getStatus, ConstantParams.COMMON_STATUS_0)
                    .set(ArticleContent::getUpdateTime, DateUtil.getCurrentDate())
                    .eq(ArticleContent::getArticleId, articleId));
            if (!flag1) {
                log.error("ArticleServiceImpl===>updateArticle:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
                GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
            }
        }
    }
}




