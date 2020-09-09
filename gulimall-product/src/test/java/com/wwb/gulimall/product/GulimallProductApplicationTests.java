package com.wwb.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wwb.gulimall.product.entity.BrandEntity;
import com.wwb.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    BrandService BrandService;
    @Test
    public void contextLoads() {
        /*BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandEntity.setDescript("123");
        BrandService.save(brandEntity);

        List<BrandEntity> list = BrandService.list(new QueryWrapper<BrandEntity>().orderByAsc("brand_id"));
        System.out.println(list.size());
        list.forEach(item->{
            System.out.println(item.getName());
        });*/

    }

}
