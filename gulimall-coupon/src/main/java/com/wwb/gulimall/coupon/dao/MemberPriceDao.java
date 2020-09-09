package com.wwb.gulimall.coupon.dao;

import com.wwb.gulimall.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-29 14:55:33
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
