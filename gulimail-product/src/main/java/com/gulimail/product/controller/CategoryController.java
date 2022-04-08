package com.gulimail.product.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.gulimail.product.eventCenter.eventPublisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gulimail.product.entity.CategoryEntity;
import com.gulimail.product.service.CategoryService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.common.utils.R;



/**
 * 商品三级分类
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:13
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    EventPublisher eventPublisher;

    /**
     * 列表
     */
    @RequestMapping("/list/tree")
    public R listWithTree(){
        List<CategoryEntity> list = categoryService.listWithTree();
        return R.ok().put("data", list);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);
		eventPublisher.publishCateNameChange(category.getCatId(), category.getName());
        return R.ok();
    }

    /**
     * 删除  禁止级联删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
        List<Long> list = Arrays.asList(catIds);
        List<Long> temp = new ArrayList<>();
        List<Long> fail = new ArrayList<>();
        list.forEach(item -> {
            int count = categoryService.getChildren(item);
            if(count == 0){
                categoryService.removeById(item);
            }
            else {
                temp.add(item);
            }
        });
        temp.forEach(item -> {
            int count = categoryService.getChildren(item);
            if(count == 0){
                categoryService.removeById(item);
            }
            else {
                fail.add(item);
            }
        });
        R r = fail.isEmpty() ? R.ok() : R.error().put("failIds", fail);
        return r;
    }

}
