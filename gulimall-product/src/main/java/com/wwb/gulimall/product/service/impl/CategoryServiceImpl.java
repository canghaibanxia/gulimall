package com.wwb.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwb.common.utils.PageUtils;
import com.wwb.common.utils.Query;

import com.wwb.gulimall.product.dao.CategoryDao;
import com.wwb.gulimall.product.entity.CategoryEntity;
import com.wwb.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        //查找一级分类
        List<CategoryEntity> collect = categoryEntities.stream().filter((category) -> {
            return category.getParentCid() == 0;
        }).map((entity)->{
            entity.setList(getChildList(entity,categoryEntities));
            return entity;
        }).sorted((category1,category2)->{
            return (category1.getSort()==null?0:category1.getSort()) - (category2.getSort()==null?0:category2.getSort());
        }).collect(Collectors.toList());
        return collect;
    }

    //查找到当前菜单的子菜单
    private List<CategoryEntity> getChildList(CategoryEntity category,List<CategoryEntity> list){
        List<CategoryEntity> collect = list.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == category.getCatId();
        }).map((categoryEntity) -> {
            categoryEntity.setList(getChildList(categoryEntity, list));
            return categoryEntity;
        }).sorted((category1, category2) -> {
            return (category1.getSort()==null?0:category1.getSort()) - (category2.getSort()==null?0:category2.getSort());
        }).collect(Collectors.toList());
        return collect;
    }
}