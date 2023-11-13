package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.constant.ConstantParams;
import com.hj.entity.store.Guarantee;
import com.hj.enums.DateEnum;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.GuaranteeMapper;
import com.hj.service.GuaranteeService;
import com.hj.util.DateUtil;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_guarantee(保障服务选项)】的数据库操作Service实现
 * @createDate 2023-11-13 20:58:28
 */
@Service
public class GuaranteeServiceImpl extends ServiceImpl<GuaranteeMapper, Guarantee>
        implements GuaranteeService {

    @Autowired
    private GuaranteeMapper guaranteeMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 分页查询
     *
     * @param date
     * @param guaranteeName
     * @return
     */
    @Override
    public PagedGridResult getGuaranteeListPage(String date, String guaranteeName, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        LambdaQueryWrapper<Guarantee> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(date)) {
            if (date.equals(DateEnum.TODAY.tag())) {
                queryWrapper.likeRight(Guarantee::getCreateTime, DateUtil.getCurrentDate(DateUtil.PATTERN_YYYY_MM_DD));
            } else if (date.equals(DateEnum.YESTERDAY.tag())) {
                queryWrapper.likeRight(Guarantee::getCreateTime, DateUtil.getYesterday(ConstantParams.COMMON_STATUS_1));
            } else if (date.equals(DateEnum.LATELY7.tag())) {
                queryWrapper.between(Guarantee::getCreateTime, DateUtil.getYesterday(ConstantParams.COMMON_STATUS_6),
                        DateUtil.getYesterday(ConstantParams.COMMON_STATUS_NEGATIVE_1));
            } else if (date.equals(DateEnum.LATELY30.tag())) {
                queryWrapper.between(Guarantee::getCreateTime, DateUtil.getYesterday(ConstantParams.COMMON_STATUS_29),
                        DateUtil.getYesterday(ConstantParams.COMMON_STATUS_NEGATIVE_1));
            } else {
                String[] split = date.split("-");
                String begin = split[0];
                String end = split[1];
                queryWrapper.between(Guarantee::getCreateTime, DateUtil.parsFormatDate(begin), DateUtil.parsFormatDate(end));
            }
        }
        if (!StringUtils.isEmpty(guaranteeName)) {
            queryWrapper.eq(Guarantee::getGuaranteeName, guaranteeName);
        }
        queryWrapper.eq(Guarantee::getIsDel, ConstantParams.COMMON_STATUS_1);
        List<Guarantee> list = guaranteeMapper.selectList(queryWrapper);
        return PagedGridResult.setterPagedGrid(list, page);
    }

    /**
     * 新增保障服务
     *
     * @param guarantee
     */
    @Override
    public void insertGuarantee(Guarantee guarantee) {
        if (StringUtils.isEmpty(guarantee.getGuaranteeName())) {
            log.error("GuaranteeServiceImpl===>insertGuarantee:" + ResponseStatusEnum.GUARANTEE_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_NAME_NOT_NULL);
        }
        if (StringUtils.isEmpty(guarantee.getGuaranteeInfo())) {
            log.error("GuaranteeServiceImpl===>insertGuarantee:" + ResponseStatusEnum.GUARANTEE_INFO_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_INFO_NOT_NULL);
        }
        if (StringUtils.isEmpty(guarantee.getImage())) {
            log.error("GuaranteeServiceImpl===>insertGuarantee:" + ResponseStatusEnum.GUARANTEE_IMAGE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_IMAGE_NOT_NULL);
        }
        guarantee.setGuaranteeId(idWorker.nextId());
        int index = guaranteeMapper.insert(guarantee);
        if (index == 0) {
            log.error("GuaranteeServiceImpl===>insertGuarantee:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改保障服务
     *
     * @param guarantee
     */
    @Override
    public void updateGuarantee(Guarantee guarantee) {
        if (StringUtils.isEmpty(guarantee.getGuaranteeId())) {
            log.error("GuaranteeServiceImpl===>updateGuarantee:" + ResponseStatusEnum.GUARANTEE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(guarantee.getGuaranteeName())) {
            log.error("GuaranteeServiceImpl===>updateGuarantee:" + ResponseStatusEnum.GUARANTEE_NAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_NAME_NOT_NULL);
        }
        if (StringUtils.isEmpty(guarantee.getGuaranteeInfo())) {
            log.error("GuaranteeServiceImpl===>updateGuarantee:" + ResponseStatusEnum.GUARANTEE_INFO_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_INFO_NOT_NULL);
        }
        if (StringUtils.isEmpty(guarantee.getImage())) {
            log.error("GuaranteeServiceImpl===>updateGuarantee:" + ResponseStatusEnum.GUARANTEE_IMAGE_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_IMAGE_NOT_NULL);
        }
        boolean flag = updateById(guarantee);
        if (!flag) {
            log.error("GuaranteeServiceImpl===>updateGuarantee:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除保障服务
     *
     * @param guaranteeId
     */
    @Override
    public void deleteGuarantee(Long guaranteeId) {
        if (StringUtils.isEmpty(guaranteeId)) {
            log.error("GuaranteeServiceImpl===>deleteGuarantee:" + ResponseStatusEnum.GUARANTEE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<Guarantee>()
                .eq(Guarantee::getGuaranteeId, guaranteeId)
                .set(Guarantee::getIsDel, ConstantParams.COMMON_STATUS_0));
        if (!flag) {
            log.error("GuaranteeServiceImpl===>updateGuarantee:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 修改是否显示状态
     *
     * @param guaranteeId
     */
    @Override
    public void updateStatus(Long guaranteeId, Integer status) {
        if (StringUtils.isEmpty(guaranteeId)) {
            log.error("GuaranteeServiceImpl===>updateStatus:" + ResponseStatusEnum.GUARANTEE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<Guarantee>()
                .eq(Guarantee::getGuaranteeId, guaranteeId)
                .set(Guarantee::getStatus, status));
        if (!flag) {
            log.error("GuaranteeServiceImpl===>updateStatus:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 根据id查询数据
     *
     * @param guaranteeId
     * @return
     */
    @Override
    public Guarantee getGuaranteeById(Long guaranteeId) {
        if (StringUtils.isEmpty(guaranteeId)) {
            log.error("GuaranteeServiceImpl===>insertGuarantee:" + ResponseStatusEnum.GUARANTEE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.GUARANTEE_ID_NOT_NULL);
        }
        Guarantee guarantee = guaranteeMapper.selectOne(new LambdaQueryWrapper<Guarantee>().eq(Guarantee::getGuaranteeId, guaranteeId));
        return guarantee;
    }
}




