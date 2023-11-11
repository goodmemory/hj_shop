package com.hj.service.impl.merchant;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.entity.merchant.Merchant;
import com.hj.mapper.merchant.MerchantMapper;
import com.hj.service.merchant.MerchantCategoryService;
import com.hj.service.merchant.MerchantService;
import com.hj.service.merchant.MerchantTypeService;
import com.hj.util.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mayaoqi
 * @description 针对表【eb_merchant(商户表)】的数据库操作Service实现
 * @createDate 2023-11-08 14:40:08
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant>
        implements MerchantService {

    @Autowired
    private MerchantTypeService merchantTypeService;
    @Autowired
    private MerchantCategoryService merchantCategoryService;
    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * @return
     */
    public PagedGridResult getMerchantListPage() {

    }
}




