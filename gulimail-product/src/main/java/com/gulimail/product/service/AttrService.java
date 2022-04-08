package com.gulimail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:14
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

