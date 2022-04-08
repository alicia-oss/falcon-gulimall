package com.gulimail.product.eventCenter.eventHandler;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.gulimail.product.entity.BrandEntity;
import com.gulimail.product.entity.CategoryBrandRelationEntity;
import com.gulimail.product.entity.CategoryEntity;
import com.gulimail.product.eventCenter.event.BrandNameChange;
import com.gulimail.product.eventCenter.event.CateNameChange;
import com.gulimail.product.service.BrandService;
import com.gulimail.product.service.CategoryBrandRelationService;
import com.gulimail.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CateNameChangeHandler implements ApplicationListener<CateNameChange> {
  @Autowired
  CategoryBrandRelationService categoryBrandRelationService;

  @Override
  public void onApplicationEvent(CateNameChange event) {
    LambdaUpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new LambdaUpdateWrapper<>();
    updateWrapper.set(CategoryBrandRelationEntity::getCatelogName, event.getName()).
            eq(CategoryBrandRelationEntity::getCatelogId, event.getCateId());
    categoryBrandRelationService.update(updateWrapper);
  }
}
