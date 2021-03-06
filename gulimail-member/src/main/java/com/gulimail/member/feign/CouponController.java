package com.gulimail.member.feign;

import com.gulimail.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("gulimail-coupon")
public interface CouponController {
  @RequestMapping("/coupon/coupon/test")
  public R test();
}
