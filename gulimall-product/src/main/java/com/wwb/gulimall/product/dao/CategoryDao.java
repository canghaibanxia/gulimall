package com.wwb.gulimall.product.dao;

import com.wwb.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author weiweibin
 * @email weiweibin@gmail.com
 * @date 2020-06-28 23:37:38
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
