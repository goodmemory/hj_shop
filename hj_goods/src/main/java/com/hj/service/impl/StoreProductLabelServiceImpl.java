package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.constant.ConstantParams;
import com.hj.entity.store.StoreProductLabel;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.StoreProductLabelMapper;
import com.hj.service.StoreProductLabelService;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_product_label】的数据库操作Service实现
 * @createDate 2023-11-12 14:15:40
 */
@Service
public class StoreProductLabelServiceImpl extends ServiceImpl<StoreProductLabelMapper, StoreProductLabel>
        implements StoreProductLabelService {

    @Autowired
    private StoreProductLabelMapper storeProductLabelMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 分页显示商品标签列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PagedGridResult getStoreProductLabelListPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<StoreProductLabel> list = storeProductLabelMapper.selectList(new LambdaQueryWrapper<StoreProductLabel>()
                .eq(StoreProductLabel::getIsDel, ConstantParams.COMMON_STATUS_1));
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 新增商品标签
     *
     * @param label
     */
    @Override
    public void insertStoreProductLabel(StoreProductLabel label) {
        if (StringUtils.isEmpty(label.getLabelName())) {
            log.error("StoreProductLabelServiceImpl===>insertStoreProductLabel:" + ResponseStatusEnum.STORE_PRODUCE_LABEL_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_LABEL_NAME_NOT_NULL);
        }
        label.setProductLabelId(idWorker.nextId());
        int index = storeProductLabelMapper.insert(label);
        if (index == 0) {
            log.error("StoreProductLabelServiceImpl===>insertStoreProductLabel:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改商品标签
     *
     * @param label
     */
    @Override
    public void updateStoreProductLabel(StoreProductLabel label) {
        if (StringUtils.isEmpty(label.getProductLabelId())) {
            log.error("StoreProductLabelServiceImpl===>updateStoreProductLabel:" + ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(label.getLabelName())) {
            log.error("StoreProductLabelServiceImpl===>updateStoreProductLabel:" + ResponseStatusEnum.STORE_PRODUCE_LABEL_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_LABEL_NAME_NOT_NULL);
        }
        int index = storeProductLabelMapper.updateById(label);
        if (index == 0) {
            log.error("StoreProductLabelServiceImpl===>updateStoreProductLabel:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除商品标签
     *
     * @param productLabelId
     */
    @Override
    public void deleteStoreProductLabel(Long productLabelId) {
        if (StringUtils.isEmpty(productLabelId)) {
            log.error("StoreProductLabelServiceImpl===>deleteStoreProductLabel:" + ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<StoreProductLabel>()
                .eq(StoreProductLabel::getProductLabelId, productLabelId)
                .set(StoreProductLabel::getIsDel, ConstantParams.COMMON_STATUS_0));
        if (!flag) {
            log.error("StoreProductLabelServiceImpl===>deleteStoreProductLabel:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改商品标签显示状态
     *
     * @param productLabelId
     */
    @Override
    public void updateStatus(Long productLabelId, Integer status) {
        if (StringUtils.isEmpty(productLabelId)) {
            log.error("StoreProductLabelServiceImpl===>updateStatus:" + ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<StoreProductLabel>()
                .eq(StoreProductLabel::getProductLabelId, productLabelId)
                .set(StoreProductLabel::getStatus, status));
        if (!flag) {
            log.error("StoreProductLabelServiceImpl===>updateStatus:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据id获取数据
     *
     * @param productLabelId
     * @return
     */
    @Override
    public StoreProductLabel getStoreProductLabelById(Long productLabelId) {
        if (StringUtils.isEmpty(productLabelId)) {
            log.error("StoreProductLabelServiceImpl===>getStoreProductLabelById:" + ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_LABEL_ID_NOT_NULL);
        }
        StoreProductLabel label = storeProductLabelMapper.selectOne(new LambdaQueryWrapper<StoreProductLabel>().eq(StoreProductLabel::getProductLabelId, productLabelId));
        return label;
    }
}




