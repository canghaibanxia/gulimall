package com.wwb.gulimall.order.dao;

import com.wwb.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-29 15:19:03
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
