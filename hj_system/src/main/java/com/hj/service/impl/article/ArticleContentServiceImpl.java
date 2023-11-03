package com.hj.service.impl.article;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.entity.article.ArticleContent;
import com.hj.mapper.article.ArticleContentMapper;
import com.hj.service.article.ArticleContentService;
import org.springframework.stereotype.Service;

/**
 * @author mayaoqi
 * @description 针对表【eb_article_content(文章内容表)】的数据库操作Service实现
 * @createDate 2023-11-02 22:44:37
 */
@Service
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentMapper, ArticleContent>
        implements ArticleContentService {

}




