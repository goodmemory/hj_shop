package com.hj.service.impl.merchant;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.constant.ConstantParams;
import com.hj.entity.merchant.MerchantCategory;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.merchant.MerchantCategoryMapper;
import com.hj.service.merchant.MerchantCategoryService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import com.hj.vo.merchant.MerchantCategoryVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_merchant_category(商户分类表)】的数据库操作Service实现
 * @createDate 2023-11-04 14:55:32
 */
@Service
public class MerchantCategoryServiceImpl extends ServiceImpl<MerchantCategoryMapper, MerchantCategory>
        implements MerchantCategoryService {

    @Autowired
    private MerchantCategoryMapper merchantCategoryMapper;

    /**
     * 获取所有商户分类分页显示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getMerchantCategoryList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<MerchantCategory> merchantCategories = merchantCategoryMapper.selectList(new LambdaQueryWrapper<MerchantCategory>()
                .eq(MerchantCategory::getStatus, ConstantParams.COMMON_STATUS_1));

        return PagedGridResult.setterPagedGrid(merchantCategories, page);
    }

    /**
     * 添加商户分类信息
     *
     * @param categoryName
     * @param commissionRate
     */
    @Override
    public void insertMerchantCategory(String categoryName, BigDecimal commissionRate) {
        if (StringUtils.isEmpty(categoryName)) {
            log.error("MerchantCategoryServiceImpl===>insertMerchantCategory:" + ResponseStatusEnum.MERCHANT_CATEGORY_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MERCHANT_CATEGORY_NAME_NOT_NULL);
        }
        MerchantCategory merchantCategory = new MerchantCategory();
        merchantCategory.setCategoryName(categoryName);
        merchantCategory.setCommissionRate(commissionRate);
        int index = merchantCategoryMapper.insert(merchantCategory);
        if (index == 0) {
            log.error("MerchantCategoryServiceImpl===>insertMerchantCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据id获取商户分类信息
     *
     * @param merchantCategoryId
     * @return
     */
    @Override
    public MerchantCategoryVo getMerchantCategoryById(Integer merchantCategoryId) {
        if (merchantCategoryId == null || merchantCategoryId == 0) {
            log.error("MerchantCategoryServiceImpl===>getMerchantCategory:" + ResponseStatusEnum.MERCHANT_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MERCHANT_CATEGORY_ID_NOT_NULL);
        }
        MerchantCategory merchantCategory = merchantCategoryMapper.selectOne(new LambdaQueryWrapper<MerchantCategory>()
                .eq(MerchantCategory::getMerchantCategoryId, merchantCategoryId)
                .eq(MerchantCategory::getStatus, ConstantParams.COMMON_STATUS_1));
        MerchantCategoryVo merchantCategoryVo = new MerchantCategoryVo();
        BeanUtils.copyProperties(merchantCategory, merchantCategoryVo);
        return merchantCategoryVo;
    }

    /**
     * 修改商户分类信息
     *
     * @param categoryName
     * @param commissionRate
     */
    @Override
    public void updateMerchantCategory(Integer merchantCategoryId, String categoryName, BigDecimal commissionRate) {
        if (merchantCategoryId == null || merchantCategoryId == 0) {
            log.error("MerchantCategoryServiceImpl===>updateMerchantCategory:" + ResponseStatusEnum.MERCHANT_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MERCHANT_CATEGORY_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(categoryName)) {
            log.error("MerchantCategoryServiceImpl===>updateMerchantCategory:" + ResponseStatusEnum.MERCHANT_CATEGORY_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MERCHANT_CATEGORY_NAME_NOT_NULL);
        }
        MerchantCategory merchantCategory = new MerchantCategory();
        merchantCategory.setMerchantCategoryId(merchantCategoryId);
        merchantCategory.setCategoryName(categoryName);
        merchantCategory.setCommissionRate(commissionRate);
        merchantCategory.setUpdateTime(DateUtil.getCurrentDateTime());
        int index = merchantCategoryMapper.updateById(merchantCategory);
        if (index == 0) {
            log.error("MerchantCategoryServiceImpl===>updateMerchantCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除商户分类信息
     *
     * @param merchantCategoryId
     */
    @Override
    public void deleteMerchantCategory(Integer merchantCategoryId) {
        if (merchantCategoryId == null || merchantCategoryId == 0) {
            log.error("MerchantCategoryServiceImpl===>deleteMerchantCategory:" + ResponseStatusEnum.MERCHANT_CATEGORY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MERCHANT_CATEGORY_ID_NOT_NULL);
        }
        boolean flag = this.update(new LambdaUpdateWrapper<MerchantCategory>()
                .set(MerchantCategory::getStatus, ConstantParams.COMMON_STATUS_0)
                .eq(MerchantCategory::getMerchantCategoryId, merchantCategoryId));
        if (!flag) {
            log.error("MerchantCategoryServiceImpl===>deleteMerchantCategory:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }

    }
}




