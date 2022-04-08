package com.gulimail.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gulimail.product.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gulimail.product.entity.CategoryBrandRelationEntity;
import com.gulimail.product.service.CategoryBrandRelationService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.common.utils.R;



/**
 * 品牌分类关联
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:13
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        LambdaQueryWrapper<CategoryBrandRelationEntity> wrapper = new LambdaQueryWrapper<>();
        PageUtils page = categoryBrandRelationService.queryPage(params, wrapper);

        return R.ok().put("page", page);
    }

    /**
     * 列表  获取当前品牌的所有分类
     */
    @GetMapping("/catelog/list")
    public R listByBrandId(@RequestParam Map<String, Object> params,
                           @RequestParam("brandId") Long brandId){
        LambdaQueryWrapper<CategoryBrandRelationEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CategoryBrandRelationEntity::getBrandId, brandId);
        List<CategoryBrandRelationEntity> list = categoryBrandRelationService.list(wrapper);

        return R.ok().put("data", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存 重写save方法  冗余字段后端填写  前端不可靠
     */
    @PostMapping("/save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){

		categoryBrandRelationService.save(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
