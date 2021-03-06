package com.wwb.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwb.common.utils.PageUtils;
import com.wwb.gulimall.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-29 15:22:58
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

