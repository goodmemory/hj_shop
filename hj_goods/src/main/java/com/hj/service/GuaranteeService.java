package com.hj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.entity.store.Guarantee;
import com.hj.util.PagedGridResult;

/**
 * @author mayaoqi
 * @description 针对表【eb_guarantee(保障服务选项)】的数据库操作Service
 * @createDate 2023-11-13 20:58:28
 */
public interface GuaranteeService extends IService<Guarantee> {

    /**
     * 分页查询
     *
     * @param date
     * @param guaranteeName
     * @return
     */
    PagedGridResult getGuaranteeListPage(String date, String guaranteeName, Integer page, Integer pageSize);

    /**
     * 新增保障服务
     *
     * @param guarantee
     */
    void insertGuarantee(Guarantee guarantee);

    /**
     * 修改保障服务
     *
     * @param guarantee
     */
    void updateGuarantee(Guarantee guarantee);

    /**
     * 删除保障服务
     *
     * @param guaranteeId
     */
    void deleteGuarantee(Long guaranteeId);

    /**
     * 修改是否显示状态
     *
     * @param guaranteeId
     */
    void updateStatus(Long guaranteeId, Integer status);

    /**
     * 根据id查询数据
     *
     * @param guaranteeId
     * @return
     */
    Guarantee getGuaranteeById(Long guaranteeId);


}
