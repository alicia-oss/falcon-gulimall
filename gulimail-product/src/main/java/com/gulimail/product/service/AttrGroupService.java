package com.gulimail.product.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:14
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Wrapper<AttrGroupEntity> wrapper);
}

