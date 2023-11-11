package com.hj.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hj.bo.store.StoreProductReplyBo;
import com.hj.constant.ConstantParams;
import com.hj.entity.store.StoreProductReply;
import com.hj.enums.ResponseStatusEnum;
import com.hj.exceptions.GraceException;
import com.hj.mapper.StoreProductReplyMapper;
import com.hj.service.StoreProductReplyService;
import com.hj.util.DateUtil;
import com.hj.util.IdWorker;
import com.hj.util.PagedGridResult;
import com.hj.vo.store.StoreProductReplyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author mayaoqi
 * @description 针对表【eb_store_product_reply(商品评论表)】的数据库操作Service实现
 * @createDate 2023-11-07 14:19:15
 */
@Service
public class StoreProductReplyServiceImpl extends ServiceImpl<StoreProductReplyMapper, StoreProductReply>
        implements StoreProductReplyService {

    @Autowired
    private StoreProductReplyMapper storeProductReplyMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 根据条件分页获取评价信息
     *
     * @param bo
     * @return
     */
    @Override
    public PagedGridResult getStoreProductReplyListPage(StoreProductReplyBo bo) {
        PageHelper.startPage(bo.getPage(), bo.getPageSize());
        //处理时间格式
        if (!StringUtils.isEmpty(bo.getDate()) && bo.getDate().contains("-")) {
            String[] split = bo.getDate().split("-");
            String beginDate = DateUtil.parsFormatDate(split[0]);
            String endDate = DateUtil.parsFormatDate(split[1]);
            bo.setBeginDate(beginDate);
            bo.setEndDate(endDate);
        }
        List<StoreProductReplyVo> listPage = storeProductReplyMapper.getStoreProductReplyListPage(bo);

        return PagedGridResult.setterPagedGrid(listPage, bo.getPage());
    }

    /**
     * 添加虚拟评价
     *
     * @param bo
     */
    @Override
    public void insertStoreProductReply(StoreProductReplyBo bo) {
        if (StringUtils.isEmpty(bo.getProductId())) {
            log.error("StoreProductReplyServiceImpl===>insertStoreProductReply:" + ResponseStatusEnum.STORE_PRODUCE_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_ID_NOT_NULL);
        }
        if (StringUtils.isEmpty(bo.getNickname())) {
            log.error("StoreProductReplyServiceImpl===>insertStoreProductReply:" + ResponseStatusEnum.USER_NICKNAME_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.USER_NICKNAME_NOT_NULL);
        }
        StoreProductReply reply = new StoreProductReply();
        BeanUtils.copyProperties(bo, reply);
        reply.setReplyId(idWorker.nextId());
        int index = storeProductReplyMapper.insert(reply);
        if (index == 0) {
            log.error("StoreProductReplyServiceImpl===>insertStoreProductReply:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }

    /**
     * 删除评论
     *
     * @param replyId
     */
    @Override
    public void deleteStoreProductReply(Long replyId) {
        if (StringUtils.isEmpty(replyId)) {
            log.error("StoreProductReplyServiceImpl===>deleteStoreProductReply:" + ResponseStatusEnum.STORE_PRODUCE_REPLY_ID_NOT_NULL.msg());
            GraceException.display(ResponseStatusEnum.STORE_PRODUCE_REPLY_ID_NOT_NULL);
        }
        boolean flag = update(new LambdaUpdateWrapper<StoreProductReply>()
                .set(StoreProductReply::getStatus, ConstantParams.COMMON_STATUS_0)
                .eq(StoreProductReply::getReplyId, replyId));
        if (!flag) {
            log.error("StoreProductReplyServiceImpl===>deleteStoreProductReply:" + ResponseStatusEnum.SYSTEM_OPERATION_ERROR.msg());
            GraceException.display(ResponseStatusEnum.SYSTEM_OPERATION_ERROR);
        }
    }
}




