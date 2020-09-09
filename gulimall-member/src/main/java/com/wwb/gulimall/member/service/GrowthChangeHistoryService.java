package com.wwb.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwb.common.utils.PageUtils;
import com.wwb.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-29 15:14:01
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

