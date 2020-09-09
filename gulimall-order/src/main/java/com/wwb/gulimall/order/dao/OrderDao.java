package com.wwb.gulimall.order.dao;

import com.wwb.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-29 15:19:03
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
