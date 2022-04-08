package com.gulimail.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.gulimail.product.entity.BrandEntity;
import com.gulimail.product.entity.CategoryEntity;
import com.gulimail.product.service.BrandService;
import com.gulimail.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.common.utils.Query;

import com.gulimail.product.dao.CategoryBrandRelationDao;
import com.gulimail.product.entity.CategoryBrandRelationEntity;
import com.gulimail.product.service.CategoryBrandRelationService;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {
    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CategoryBrandRelationEntity> wrapper) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public boolean save(CategoryBrandRelationEntity entity) {
        BrandEntity brand = brandService.getById(entity.getBrandId());
        CategoryEntity categoryEntity = categoryService.getById(entity.getCatelogId());
        entity.setBrandName(brand.getName());
        entity.setCatelogName(categoryEntity.getName());
        return super.save(entity);
    }


}
