package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.store.StoreCategoryBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.store.StoreCategory;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.StoreCategoryMapper;
import com.hj.service.StoreCategoryService;
import com.hj.util.DateUtil;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreCategoryOneVo;
import com.hj.vo.store.StoreCategoryTwoVo;
import com.hj.vo.store.StoreCategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_category(商品分类表)】的数据库操作Service实现
 * @createDate 2023-11-06 11:26:27
 */
@Service
public class StoreCategoryServiceImpl extends ServiceImpl<StoreCategoryMapper, StoreCategory>
        implements StoreCategoryService {

    @Autowired
    private StoreCategoryMapper storeCategoryMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 获取商品分类分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getStoreCategoryListPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<StoreCategoryVo> list = storeCategoryMapper.getStoreCategoryListAll(ConstantParams.COMMON_STATUS_LONG0);
        for (StoreCategoryVo categoryVo : list) {
            List<StoreCategoryVo> sonList = storeCategoryMapper.getStoreCategoryListAll(categoryVo.getStoreCategoryId());

            if (!CollectionUtils.isEmpty(sonList)) {
                categoryVo.setStoreCategoryList(sonList);
                for (StoreCategoryVo storeCategoryVo : sonList) {
                    List<StoreCategoryVo> grandsonList = storeCategoryMapper.getStoreCategoryListAll(storeCategoryVo.getStoreCategoryId());
                    if (!CollectionUtils.isEmpty(grandsonList)) {
                        storeCategoryVo.setStoreCategoryList(grandsonList);
                    }
                }
            }
        }
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 获取所有商品分类
     *
     * @return
     */
    @Override
    public List<StoreCategoryOneVo> getStoreCategoryList() {
        List<StoreCategoryOneVo> list = storeCategoryMapper.getStoreCategoryNotEqLevel2List(ConstantParams.COMMON_STATUS_LONG0);
        for (StoreCategoryOneVo categoryOneVo : list) {
            List<StoreCategoryOneVo> sonList = storeCategoryMapper.getStoreCategoryNotEqLevel2List(categoryOneVo.getStoreCategoryId());
            if (!CollectionUtils.isEmpty(sonList)) {
                categoryOneVo.setStoreCategoryList(sonList);
            }
        }
        return list;
    }

    /**
     * 新增分类
     *
     * @param bo
     */
    @Override
    public void insertStoreCategory(StoreCategoryBo bo) {
        if (StringUtils.isEmpty(bo.getPid())) {
            log.error("StoreCategoryServiceImpl===>insertStoreCategory:" + ResponseStatusEnum.STORE_PID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getCateName())) {
            log.error("StoreCategoryServiceImpl===>insertStoreCategory:" + ResponseStatusEnum.STORE_CATEGORY_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_CATEGORY_NAME_NOT_NULL);
        }
        StoreCategory category = new StoreCategory();
        BeanUtils.copyProperties(bo, category);
        category.setStoreCategoryId(idWorker.nextId());
        if (bo.getPid().equals(ConstantParams.COMMON_STATUS_STR0)) {
            category.setPath("/");
            category.setLevel(ConstantParams.COMMON_STATUS_0);
        } else {
            StoreCategory storeCategory = storeCategoryMapper.selectOne(new LambdaQueryWrapper<StoreCategory>()
                    .eq(StoreCategory::getStoreCategoryId, bo.getPid())
                    .eq(StoreCategory::getStatus, ConstantParams.COMMON_STATUS_STR1));
            if (storeCategory.getPid().equals(ConstantParams.COMMON_STATUS_STR0)) {
                category.setPath("/" + storeCategory.getStoreCategoryId() + "/");
                category.setLevel(ConstantParams.COMMON_STATUS_1);
            } else {
                category.setPath("/" + storeCategory.getPid() + "/" + storeCategory.getStoreCategoryId() + "/");
                category.setLevel(ConstantParams.COMMON_STATUS_2);
            }
        }
        int index = storeCategoryMapper.insert(category);
        if (index == 0) {
            log.error("StoreCategoryServiceImpl===>insertStoreCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改分类
     *
     * @param bo
     */
    @Override
    public void updateStoreCategory(StoreCategoryBo bo) {
        if (StringUtils.isEmpty(bo.getStoreCategoryId())) {
            log.error("StoreCategoryServiceImpl===>updateStoreCategory:" + ResponseStatusEnum.STORE_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_CATEGORY_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getPid())) {
            log.error("StoreCategoryServiceImpl===>updateStoreCategory:" + ResponseStatusEnum.STORE_PID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getCateName())) {
            log.error("StoreCategoryServiceImpl===>updateStoreCategory:" + ResponseStatusEnum.STORE_CATEGORY_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_CATEGORY_NAME_NOT_NULL);
        }
        StoreCategory storeCategory = new StoreCategory();
        BeanUtils.copyProperties(bo, storeCategory);
        storeCategory.setUpdateTime(DateUtil.getCurrentDateTime());
        boolean flag = updateById(storeCategory);
        if (!false) {
            log.error("StoreCategoryServiceImpl===>updateStoreCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改是否显示 type:0，是否推荐 type:1 ，发货前确认 type:2
     *
     * @param type
     * @param storeCategoryId
     */
    @Override
    public void updateCategoryStatus(Integer type, Long storeCategoryId, Integer params) {
        if (StringUtils.isEmpty(storeCategoryId)) {
            log.error("StoreCategoryServiceImpl===>updateCategoryStatus:" + ResponseStatusEnum.STORE_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_CATEGORY_ID_NOT_NULL);
        }
        LambdaUpdateWrapper<StoreCategory> updateWrapper = new LambdaUpdateWrapper<>();
        if (type == ConstantParams.COMMON_STATUS_0) {
            updateWrapper.set(StoreCategory::getIsShow, params);
        }
        if (type == ConstantParams.COMMON_STATUS_1) {
            updateWrapper.set(StoreCategory::getIsHot, params);
        }
        if (type == ConstantParams.COMMON_STATUS_2) {
            updateWrapper.set(StoreCategory::getIsDeliveryConfirm, params);
        }
        updateWrapper.eq(StoreCategory::getStoreCategoryId, storeCategoryId);
        boolean flag = this.update(updateWrapper);
        if (!flag) {
            log.error("StoreCategoryServiceImpl===>updateCategoryStatus:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除
     *
     * @param storeCategoryId
     */
    @Override
    public void deleteStoreCategory(Long storeCategoryId) {
        if (StringUtils.isEmpty(storeCategoryId)) {
            log.error("StoreCategoryServiceImpl===>deleteStoreCategory:" + ResponseStatusEnum.STORE_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_CATEGORY_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<StoreCategory>()
                .set(StoreCategory::getStatus, ConstantParams.COMMON_STATUS_0)
                .eq(StoreCategory::getStoreCategoryId, storeCategoryId));
        if (!flag) {
            log.error("StoreCategoryServiceImpl===>updateCategoryStatus:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据id获取商品信息
     *
     * @param storeCategoryId
     * @return
     */
    @Override
    public StoreCategoryTwoVo getStoreCategoryById(Long storeCategoryId) {
        if (StringUtils.isEmpty(storeCategoryId)) {
            log.error("StoreCategoryServiceImpl===>getStoreCategoryById:" + ResponseStatusEnum.STORE_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_CATEGORY_ID_NOT_NULL);
        }
        StoreCategory storeCategory = storeCategoryMapper.selectOne(new LambdaQueryWrapper<StoreCategory>()
                .eq(StoreCategory::getStoreCategoryId, storeCategoryId)
                .eq(StoreCategory::getStatus, ConstantParams.COMMON_STATUS_1));
        StoreCategoryTwoVo categoryTwoVo = new StoreCategoryTwoVo();
        BeanUtils.copyProperties(storeCategory, categoryTwoVo);
        categoryTwoVo.setStoreCategoryList(getStoreCategoryList());
        return categoryTwoVo;
    }
}




