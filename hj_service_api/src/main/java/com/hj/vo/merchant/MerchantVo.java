package com.hj.vo.merchant;

import com.hj.entity.merchant.Merchant;
import com.hj.entity.merchant.MerchantCategory;
import com.hj.entity.merchant.MerchantType;
import lombok.Data;

import java.util.List;

@Data
public class MerchantVo {

    /**
     * 商户类型列表
     */
    List<MerchantType> typeList;

    /**
     * 商户分类列表
     */
    List<MerchantCategory> merchantCategoryList;
    /**
     * 商户列表
     */
    List<Merchant> merchantList;

}
