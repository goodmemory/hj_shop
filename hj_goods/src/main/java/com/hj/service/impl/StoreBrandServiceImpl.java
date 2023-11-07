package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.store.StoreBrandBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.store.StoreBrand;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.StoreBrandMapper;
import com.hj.service.StoreBrandService;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreBrandVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_brand(商品品牌表)】的数据库操作Service实现
 * @createDate 2023-11-06 23:14:58
 */
@Service
public class StoreBrandServiceImpl extends ServiceImpl<StoreBrandMapper, StoreBrand>
        implements StoreBrandService {

    @Autowired
    private StoreBrandMapper storeBrandMapper;
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
    public PagedGridResult getStoreBrandListPage(Long brandCategoryId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<StoreBrand> storeBrands = storeBrandMapper.selectList(new LambdaQueryWrapper<StoreBrand>()
                .eq(StoreBrand::getStatus, ConstantParams.COMMON_STATUS_0));
        return PagedGridResult.setterPagedGrid(storeBrands, page);
    }

    /**
     * 新增品牌
     *
     * @param bo
     */
    @Override
    public void insertStoreBrand(StoreBrandBo bo) {
        if (StringUtils.isEmpty(bo.getBrandCategoryId())) {
            log.error("StoreBrandServiceImpl===>insertStoreBrand:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getBrandName())) {
            log.error("StoreBrandServiceImpl===>insertStoreBrand:" + ResponseStatusEnum.STORE_BRAND_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_NAME_NOT_NULL);
        }
        StoreBrand storeBrand = new StoreBrand();
        BeanUtils.copyProperties(bo, storeBrand);
        storeBrand.setBrandId(idWorker.nextId());
        int index = storeBrandMapper.insert(storeBrand);
        if (index == 0) {
            log.error("StoreBrandServiceImpl===>insertStoreBrand:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改品牌
     *
     * @param bo
     */
    @Override
    public void updateStoreBrand(StoreBrandBo bo) {
        if (StringUtils.isEmpty(bo.getBrandId())) {
            log.error("StoreBrandServiceImpl===>updateStoreBrand:" + ResponseStatusEnum.STORE_BRAND_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getBrandCategoryId())) {
            log.error("StoreBrandServiceImpl===>updateStoreBrand:" + ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_CATEGORY_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getBrandName())) {
            log.error("StoreBrandServiceImpl===>updateStoreBrand:" + ResponseStatusEnum.STORE_BRAND_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_NAME_NOT_NULL);
        }
        StoreBrand storeBrand = new StoreBrand();
        BeanUtils.copyProperties(bo, storeBrand);
        boolean flag = updateById(storeBrand);
        if (!flag) {
            log.error("StoreBrandServiceImpl===>updateStoreBrand:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除品牌
     *
     * @param brandId
     */
    @Override
    public void deleteStoreBrand(Long brandId) {
        if (StringUtils.isEmpty(brandId)) {
            log.error("StoreBrandServiceImpl===>updateStoreBrand:" + ResponseStatusEnum.STORE_BRAND_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<StoreBrand>()
                .set(StoreBrand::getStatus, ConstantParams.COMMON_STATUS_0)
                .eq(StoreBrand::getBrandId, brandId));
        if (!flag) {
            log.error("StoreBrandServiceImpl===>updateStoreBrand:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据id获取数据
     *
     * @param brandId
     * @return
     */
    @Override
    public StoreBrandVo getStoreBrandById(Long brandId) {
        if (StringUtils.isEmpty(brandId)) {
            log.error("StoreBrandServiceImpl===>getStoreBrandById:" + ResponseStatusEnum.STORE_BRAND_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_ID_NOT_NULL);
        }
        StoreBrand storeBrand = storeBrandMapper.selectOne(new LambdaQueryWrapper<StoreBrand>().eq(StoreBrand::getBrandId, brandId)
                .eq(StoreBrand::getStatus, ConstantParams.COMMON_STATUS_0));
        StoreBrandVo brandVo = new StoreBrandVo();
        BeanUtils.copyProperties(storeBrand, brandVo);
        return brandVo;
    }

    /**
     * 修改是否显示状态
     *
     * @param brandId
     * @param isShow
     */
    @Override
    public void updateIsShow(Long brandId, Integer isShow) {
        if (StringUtils.isEmpty(brandId)) {
            log.error("StoreBrandServiceImpl===>updateIsShow:" + ResponseStatusEnum.STORE_BRAND_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_BRAND_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<StoreBrand>()
                .set(StoreBrand::getIsShow, isShow)
                .eq(StoreBrand::getBrandId, brandId));
        if (!flag) {
            log.error("StoreBrandServiceImpl===>updateIsShow:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




