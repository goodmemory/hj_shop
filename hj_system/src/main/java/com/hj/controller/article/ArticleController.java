package com.hj.controller.article;

import com.hj.bo.article.ArticleBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.GraceJSONResult;
import com.hj.service.article.ArticleService;
import com.hj.util.PagedGridResult;
import com.hj.vo.article.ArticleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
@Api(tags = "ArticleController 文章管理接口模块")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取所有文章列表数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/lst")
    @ApiOperation(value = "获取所有文章列表数据")
    public GraceJSONResult getMemberInterestsList(@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") Integer page,
                                                  @RequestParam(defaultValue = "") Integer pageSize) {
        if (page == null) {
            page = ConstantParams.COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = ConstantParams.COMMON_PAGE_SIZE;
        }
        PagedGridResult list = articleService.getArticleList(title, page, pageSize);
        return GraceJSONResult.ok(list);
    }

    /**
     * 新增文章
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增文章")
    public GraceJSONResult insertArticle(@RequestBody ArticleBo bo) {
        articleService.insertArticle(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 改变是否显示状态
     *
     * @param articleId
     * @param isShow
     * @return
     */
    @PutMapping("/updateIsShow/{articleId}")
    @ApiOperation(value = "改变是否显示状态")
    public GraceJSONResult updateIsShow(@PathVariable String articleId, Integer isShow) {
        articleService.updateIsShow(articleId, isShow);
        return GraceJSONResult.ok();
    }

    /**
     * 根据id获取文章详情
     *
     * @param articleId
     * @return
     */
    @GetMapping("getArticleInfoById/{articleId}")
    @ApiOperation(value = "根据id获取文章详情")
    public GraceJSONResult getArticleInfoById(@PathVariable String articleId) {
        ArticleVo articleVo = articleService.getArticleInfoById(articleId);
        return GraceJSONResult.ok(articleVo);
    }

    /**
     * 修改文章
     *
     * @param bo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改文章")
    public GraceJSONResult updateArticle(@RequestBody ArticleBo bo) {
        articleService.updateArticle(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除文章")
    public GraceJSONResult deleteArticle(@RequestParam String articleId) {
        articleService.deleteArticle(articleId);
        return GraceJSONResult.ok();
    }
}
