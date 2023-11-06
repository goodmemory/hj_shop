package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.store.StoreBrandCategoryBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.store.StoreBrandCategory;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.StoreBrandCategoryMapper;
import com.hj.service.StoreBrandCategoryService;
import com.hj.util.DateUtil;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreBrandCategoryOneVo;
import com.hj.vo.store.StoreBrandCategoryTwoVo;
import com.hj.vo.store.StoreBrandCategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_brand_category(品牌分类表)】的数据库操作Service实现
 * @createDate 2023-11-06 16:35:08
 */
@Service
public class StoreBrandCategoryServiceImpl extends ServiceImpl<StoreBrandCategoryMapper, StoreBrandCategory>
        implements StoreBrandCategoryService {

    @Autowired
    private StoreBrandCategoryMapper storeBrandCategoryMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 分页获取品牌数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getStoreBrandCategoryPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<StoreBrandCategoryVo> categoryPage = storeBrandCategoryMapper.getStoreBrandCategoryPage(ConstantParams.COMMON_STATUS_STR0);
        if (!CollectionUtils.isEmpty(categoryPage)) {
            for (StoreBrandCategoryVo categoryVo : categoryPage) {
                List<StoreBrandCategoryVo> brandCategoryVos = storeBrandCategoryMapper.getStoreBrandCategoryPage(categoryVo.getPid());
                if (!CollectionUtils.isEmpty(brandCategoryVos)) {
                    categoryVo.setChildList(brandCategoryVos);
                }
            }
        }
        return PagedGridResult.setterPagedGrid(categoryPage, page);
    }

    /**
     * 获取所有品牌分类（树形）
     *
     * @return
     */
    @Override
    public List<StoreBrandCategoryOneVo> getStoreBrandCategoryAllList() {
        List<StoreBrandCategoryOneVo> list = storeBrandCategoryMapper.getStoreBrandCategoryAllList(ConstantParams.COMMON_STATUS_STR0);
        if (!CollectionUtils.isEmpty(list)) {
            for (StoreBrandCategoryOneVo storeCategory : list) {
                List<StoreBrandCategoryOneVo> sonList = storeBrandCategoryMapper.getStoreBrandCategoryAllList(storeCategory.getStoreBrandCategoryId());
                if (!CollectionUtils.isEmpty(sonList)) {
                    storeCategory.setChildList(sonList);
                }
            }
        }
        return list;
    }

    /**
     * 新增品牌数据
     *
     * @param bo
     */
    @Override
    public void insertStoreBrandCategory(StoreBrandCategoryBo bo) {
        if (StringUtils.isEmpty(bo.getPid())) {
            log.error("StoreBrandCategoryServiceImpl===>insertStoreBrandCategory:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_PID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_PID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getCateName())) {
            log.error("StoreBrandCategoryServiceImpl===>insertStoreBrandCategory:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_NAME_NOT_NULL);
        }
        StoreBrandCategory brandCategory = new StoreBrandCategory();
        BeanUtils.copyProperties(bo, brandCategory);
        brandCategory.setStoreBrandCategoryId("SBC" + idWorker.nextId());
        if (bo.getPid().equals(ConstantParams.COMMON_STATUS_STR0)) {
            brandCategory.setLevel(ConstantParams.COMMON_STATUS_0);
            brandCategory.setPath("/");
        } else {
            StoreBrandCategory category = storeBrandCategoryMapper.selectOne(new LambdaQueryWrapper<StoreBrandCategory>()
                    .eq(StoreBrandCategory::getStoreBrandCategoryId, bo.getPid())
                    .eq(StoreBrandCategory::getStatus, ConstantParams.COMMON_STATUS_1));
            if (!category.getPid().equals(ConstantParams.COMMON_STATUS_STR0)) {
                log.error("StoreBrandCategoryServiceImpl===>insertStoreBrandCategory:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_LOWER.msg());
                GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_LOWER);
            } else {
                brandCategory.setLevel(ConstantParams.COMMON_STATUS_1);
                brandCategory.setPath("/" + category.getStoreBrandCategoryId() + "/");
            }
        }
        int index = storeBrandCategoryMapper.insert(brandCategory);
        if (index == 0) {
            log.error("StoreBrandCategoryServiceImpl===>insertStoreBrandCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改品牌分类数据
     *
     * @param bo
     */
    @Override
    public void updateStoreBrandCategory(StoreBrandCategoryBo bo) {
        if (StringUtils.isEmpty(bo.getStoreBrandCategoryId())) {
            log.error("StoreBrandCategoryServiceImpl===>updateStoreBrandCategory:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getPid())) {
            log.error("StoreBrandCategoryServiceImpl===>updateStoreBrandCategory:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_PID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_PID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getCateName())) {
            log.error("StoreBrandCategoryServiceImpl===>updateStoreBrandCategory:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_NAME_NOT_NULL);
        }
        StoreBrandCategory brandCategory = new StoreBrandCategory();
        BeanUtils.copyProperties(bo, brandCategory);
        brandCategory.setUpdateTime(DateUtil.getCurrentDateTime());
        boolean flag = updateById(brandCategory);
        if (!flag) {
            log.error("StoreBrandCategoryServiceImpl===>updateStoreBrandCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改是否显示状态
     *
     * @param storeBrandCategoryId
     */
    @Override
    public void updateIsShow(String storeBrandCategoryId, Integer isShow) {
        if (StringUtils.isEmpty(storeBrandCategoryId)) {
            log.error("StoreBrandCategoryServiceImpl===>updateIsShow:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<StoreBrandCategory>().set(StoreBrandCategory::getIsShow, isShow)
                .eq(StoreBrandCategory::getStoreBrandCategoryId, storeBrandCategoryId));
        if (!flag) {
            log.error("StoreBrandCategoryServiceImpl===>updateIsShow:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据id获取数据
     *
     * @param storeBrandCategoryId
     * @return
     */
    @Override
    public StoreBrandCategoryTwoVo getStoreBrandCategoryById(String storeBrandCategoryId) {
        if (StringUtils.isEmpty(storeBrandCategoryId)) {
            log.error("StoreBrandCategoryServiceImpl===>getStoreBrandCategoryById:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL);
        }
        StoreBrandCategoryTwoVo categoryTwoVo = new StoreBrandCategoryTwoVo();
        StoreBrandCategory category = storeBrandCategoryMapper.selectOne(new LambdaQueryWrapper<StoreBrandCategory>()
                .eq(StoreBrandCategory::getStoreBrandCategoryId, storeBrandCategoryId)
                .eq(StoreBrandCategory::getStatus, ConstantParams.COMMON_STATUS_1));
        BeanUtils.copyProperties(category, categoryTwoVo);
        categoryTwoVo.setChildList(getStoreBrandCategoryAllList());
        return categoryTwoVo;
    }

    /**
     * 删除品牌分类数据
     *
     * @param storeBrandCategoryId
     */
    @Override
    public void deleteStoreBrandCategory(String storeBrandCategoryId) {
        if (StringUtils.isEmpty(storeBrandCategoryId)) {
            log.error("StoreBrandCategoryServiceImpl===>deleteStoreBrandCategory:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<StoreBrandCategory>()
                .set(StoreBrandCategory::getStatus, ConstantParams.COMMON_STATUS_0)
                .eq(StoreBrandCategory::getStoreBrandCategoryId, storeBrandCategoryId));
        if (!flag) {
            log.error("StoreBrandCategoryServiceImpl===>deleteStoreBrandCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




