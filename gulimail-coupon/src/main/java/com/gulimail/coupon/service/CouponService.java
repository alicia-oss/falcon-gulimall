package com.gulimail.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-02 16:17:45
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

