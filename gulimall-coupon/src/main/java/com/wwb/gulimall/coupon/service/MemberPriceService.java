package com.wwb.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwb.common.utils.PageUtils;
import com.wwb.gulimall.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-29 14:55:33
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

