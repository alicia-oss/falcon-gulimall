package com.gulimail.product.eventCenter.eventHandler;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.gulimail.product.entity.BrandEntity;
import com.gulimail.product.entity.CategoryBrandRelationEntity;
import com.gulimail.product.eventCenter.event.BrandNameChange;
import com.gulimail.product.service.BrandService;
import com.gulimail.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BrandNameChangeHandler implements ApplicationListener<BrandNameChange> {
  @Autowired
  CategoryBrandRelationService categoryBrandRelationService;

  @Override
  public void onApplicationEvent(BrandNameChange event) {
    LambdaUpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new LambdaUpdateWrapper<>();
    updateWrapper.set(CategoryBrandRelationEntity::getBrandName, event.getBrandName()).
            eq(CategoryBrandRelationEntity::getBrandId, event.getBrandId());
    categoryBrandRelationService.update(updateWrapper);
  }
}
