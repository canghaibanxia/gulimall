package com.wwb.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwb.common.utils.PageUtils;
import com.wwb.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-28 23:37:38
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

