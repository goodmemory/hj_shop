package com.hj.bo.merchant;

import lombok.Data;

@Data
public class MerchantBo {

    private Integer page;
    private Integer pageSize;
    //日期标识
    private String date;

    private String keyword;
    private Integer status;
    private Integer isTrader;
    private Long typeId;
    private Long categoryId;

    private String merName;

    private String merPhone;

}
