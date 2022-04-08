package com.gulimail.product.dao;

import com.gulimail.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:13
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
