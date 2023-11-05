package com.hj.controller.article;

import com.hj.bo.article.ArticleCategoryBo;
import com.hj.entity.GraceJSONResult;
import com.hj.entity.article.ArticleCategory;
import com.hj.service.article.ArticleCategoryService;
import com.hj.vo.article.ArticleCategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/articleCategory")
@Api(tags = "ArticleCategoryController 文章分类管理接口模块")
@Slf4j
public class ArticleCategoryController {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    /**
     * 获取所有文章分类数据
     *
     * @return
     */
    @GetMapping("list")
    @ApiOperation(value = "获取所有文章分类数据")
    public GraceJSONResult list() {
        List<ArticleCategory> articleCategories = articleCategoryService.listArticleCategory();
        return GraceJSONResult.ok(articleCategories);
    }

    /**
     * 新增文章分类数据
     *
     * @param bo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增文章分类数据")
    public GraceJSONResult insertArticleCategory(@RequestBody ArticleCategoryBo bo) {
        articleCategoryService.insertArticleCategory(bo);
        return GraceJSONResult.ok();
    }

    /**
     * @return
     */
    @GetMapping("/getArticleCategoryById/{articleCategoryId}")
    @ApiOperation(value = "根据ID获取文章分类数据")
    public GraceJSONResult getArticleCategoryById(@PathVariable Integer articleCategoryId) {
        ArticleCategoryVo category = articleCategoryService.getArticleCategoryById(articleCategoryId);
        return GraceJSONResult.ok(category);
    }

    /**
     * 修改文章分类数据
     *
     * @param bo
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改文章分类数据")
    public GraceJSONResult updateArticleCategory(@RequestBody ArticleCategoryBo bo) {
        articleCategoryService.updateArticleCategory(bo);
        return GraceJSONResult.ok();
    }

    /**
     * 修改是否显示状态
     *
     * @param articleCategoryId
     * @return
     */
    @PutMapping("/updateIsShow/{articleCategoryId}")
    @ApiOperation(value = "修改是否显示状态")
    public GraceJSONResult updateIsShow(@PathVariable Integer articleCategoryId, Integer isShow) {
        articleCategoryService.updateIsShow(articleCategoryId, isShow);
        return GraceJSONResult.ok();
    }

    /**
     * 删除是否显示状态
     *
     * @param articleCategoryId
     * @return
     */
    @DeleteMapping("/delete/{articleCategoryId}")
    @ApiOperation(value = "删除文章分类数据")
    public GraceJSONResult deleteArticleCategory(@PathVariable Integer articleCategoryId) {
        articleCategoryService.deleteArticleCategory(articleCategoryId);
        return GraceJSONResult.ok();
    }

}
