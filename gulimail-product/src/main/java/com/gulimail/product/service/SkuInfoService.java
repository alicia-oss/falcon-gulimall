package com.gulimail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:14
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

