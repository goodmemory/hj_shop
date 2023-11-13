package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.store.StoreProductBo;
import com.hj.entity.store.StoreProduct;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.feign.MerchantFeign;
import com.hj.mapper.StoreProductMapper;
import com.hj.service.StoreProductService;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_product(商品表)】的数据库操作Service实现
 * @createDate 2023-11-11 14:54:31
 */
@Service
public class StoreProductServiceImpl extends ServiceImpl<StoreProductMapper, StoreProduct>
        implements StoreProductService {

    @Autowired
    private MerchantFeign merchantFeign;
    @Autowired
    private StoreProductMapper storeProductMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 分页查询商品信息
     *
     * @param bo
     * @return
     */
    @Override
    public PagedGridResult getStoreProductListPage(StoreProductBo bo) {
        PageHelper.startPage(bo.getPage(), bo.getPageSize());
        List<StoreProductVo> listPage = storeProductMapper.getStoreProductListPage(bo);
        return PagedGridResult.setterPagedGrid(listPage, bo.getPage());
    }

    /**
     * 修改是否显示状态
     *
     * @param productId
     */
    @Override
    public void updateIsUsed(Long productId, Integer isUsed) {
        if (StringUtils.isEmpty(productId)) {
            log.error("StoreProductServiceImpl===>updateIsUsed:" + ResponseStatusEnum.STORE_PRODUCE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<StoreProduct>()
                .eq(StoreProduct::getProductId, productId)
                .set(StoreProduct::getIsUsed, isUsed));
        if (!flag) {
            log.error("StoreProductServiceImpl===>updateIsUsed:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }

    }

    /**
     * 编辑标签
     *
     * @param labelId
     */
    @Override
    public void updateLabel(Long productId, Long labelId) {
        if (StringUtils.isEmpty(productId)) {
            log.error("StoreProductServiceImpl===>updateLabel:" + ResponseStatusEnum.STORE_PRODUCE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(labelId)) {
            log.error("StoreProductServiceImpl===>updateLabel:" + ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<StoreProduct>().set(StoreProduct::getLabelId, labelId)
                .eq(StoreProduct::getProductId, productId));
        if (!flag) {
            log.error("StoreProductServiceImpl===>updateLabel:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




