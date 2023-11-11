package com.hj.service.merchant;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.entity.merchant.MerchantType;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_merchant_type(商户类型表)】的数据库操作Service
 * @createDate 2023-11-08 14:30:45
 */
public interface MerchantTypeService extends IService<MerchantType> {

    @Override
    default List<MerchantType> list() {
        return IService.super.list();
    }
}
