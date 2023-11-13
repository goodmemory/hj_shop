package com.hj.service.impl.merchant;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.merchant.MerchantBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.merchant.Merchant;
import com.hj.enums.DateEnum;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.merchant.MerchantCategoryMapper;
import com.hj.mapper.merchant.MerchantMapper;
import com.hj.mapper.merchant.MerchantTypeMapper;
import com.hj.service.merchant.MerchantService;
import com.hj.util.DateUtil;
import com.hj.util.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mayaoqi
 * @description 针对表【eb_merchant(商户表)】的数据库操作Service实现
 * @createDate 2023-11-08 14:40:08
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant>
        implements MerchantService {

    @Autowired
    private MerchantTypeMapper merchantTypeMapper;
    @Autowired
    private MerchantCategoryMapper merchantCategoryMapper;
    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * 获取商户信息分页显示
     *
     * @param bo
     * @return
     */
    public PagedGridResult getMerchantListPage(MerchantBo bo) {
        PageHelper.startPage(bo.getPage(), bo.getPageSize());
        LambdaQueryWrapper<Merchant> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(bo.getDate())) {
            if (bo.getDate().equals(DateEnum.TODAY.tag())) {
                queryWrapper.likeRight(Merchant::getCreateTime, DateUtil.getCurrentDate(DateUtil.PATTERN_YYYY_MM_DD));
            } else if (bo.getDate().equals(DateEnum.YESTERDAY.tag())) {
                queryWrapper.likeRight(Merchant::getCreateTime, DateUtil.getYesterday(ConstantParams.COMMON_STATUS_1));
            } else if (bo.getDate().equals(DateEnum.LATELY7.tag())) {
                queryWrapper.between(Merchant::getCreateTime, DateUtil.getYesterday(ConstantParams.COMMON_STATUS_6),
                        DateUtil.getYesterday(ConstantParams.COMMON_STATUS_NEGATIVE_1));
            } else if (bo.getDate().equals(DateEnum.LATELY30.tag())) {
                queryWrapper.between(Merchant::getCreateTime, DateUtil.getYesterday(ConstantParams.COMMON_STATUS_29),
                        DateUtil.getYesterday(ConstantParams.COMMON_STATUS_NEGATIVE_1));
            } else {
                String[] split = bo.getDate().split("-");
                String begin = split[0];
                String end = split[1];
                queryWrapper.between(Merchant::getCreateTime, DateUtil.parsFormatDate(begin), DateUtil.parsFormatDate(end));
            }

        }
        if (!StringUtils.isEmpty(bo.getKeyword())) {
            queryWrapper.like(Merchant::getMerName, bo.getKeyword()).or().like(Merchant::getMerPhone, bo.getKeyword());
        }
        if (!StringUtils.isEmpty(bo.getTypeId())) {
            queryWrapper.like(Merchant::getTypeId, bo.getTypeId());
        }
        if (!StringUtils.isEmpty(bo.getCategoryId())) {
            queryWrapper.like(Merchant::getCategoryId, bo.getCategoryId());
        }
        if (!StringUtils.isEmpty(bo.getIsTrader())) {
            queryWrapper.like(Merchant::getIsTrader, bo.getIsTrader());
        }
        if (StringUtils.isEmpty(bo.getStatus())) {
            queryWrapper.eq(Merchant::getStatus, ConstantParams.COMMON_STATUS_1);
        } else {
            queryWrapper.eq(Merchant::getStatus, bo.getStatus());
        }
        queryWrapper.eq(Merchant::getIsDel, ConstantParams.COMMON_STATUS_1);
        List<Merchant> list = merchantMapper.selectList(queryWrapper);

        return PagedGridResult.setterPagedGrid(list, bo.getPage());
    }

    /**
     * 获取所有商户名称（供商品管理页使用）
     *
     * @return
     */
    @Override
    public List<String> getMerchantName() {
        List<String> nameList = merchantMapper.selectList(new LambdaQueryWrapper<Merchant>()
                .eq(Merchant::getIsDel, ConstantParams.COMMON_STATUS_1))
                .stream().map(Merchant::getMerName).collect(Collectors.toList());
        return nameList;
    }

    /**
     * 新增商户
     *
     * @param merchant
     */
    @Override
    public void addMerchant(Merchant merchant) {
        if (StringUtils.isEmpty(merchant.getMerName())) {
            log.error("MerchantServiceImpl===>addMerchant:" + ResponseStatusEnum.MERCHANT_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MERCHANT_NAME_NOT_NULL);
        }
        if (StringUtils.isEmpty(merchant.getCategoryId())) {
            log.error("MerchantServiceImpl===>addMerchant:" + ResponseStatusEnum.MERCHANT_CATEGORY_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MERCHANT_CATEGORY_NOT_NULL);
        }
        if (StringUtils.isEmpty(merchant.getTypeId())) {
            log.error("MerchantServiceImpl===>addMerchant:" + ResponseStatusEnum.MERCHANT_TYPE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.MERCHANT_TYPE_NOT_NULL);
        }
    }
}




