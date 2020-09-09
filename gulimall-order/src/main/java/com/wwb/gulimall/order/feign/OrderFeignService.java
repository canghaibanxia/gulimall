package com.wwb.gulimall.order.feign;

import com.wwb.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("gulimall-coupon")
public interface OrderFeignService {

    @RequestMapping("/coupon/coupon/list")
    public R list(@RequestParam Map<String, Object> params);
}
