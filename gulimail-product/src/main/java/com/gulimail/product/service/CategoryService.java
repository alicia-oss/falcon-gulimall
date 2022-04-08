package com.gulimail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:13
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

  List<CategoryEntity> listWithTree();

  Integer getChildren(Long item);

  List<Long> findParentPath(Long attrGroupId);

//  List<CategoryEntity> getChildren(CategoryEntity entity, List<CategoryEntity> entities);
}

