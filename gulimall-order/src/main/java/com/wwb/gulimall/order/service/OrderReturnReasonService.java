package com.wwb.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwb.common.utils.PageUtils;
import com.wwb.gulimall.order.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * 退货原因
 *
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-29 15:19:03
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

