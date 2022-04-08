package com.gulimail.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gulimail.common.utils.Query;
import com.gulimail.product.entity.CategoryEntity;
import com.gulimail.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.gulimail.product.entity.AttrGroupEntity;
import com.gulimail.product.service.AttrGroupService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.common.utils.R;



/**
 * 属性分组
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:14
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 列表 查询某个分类下的所有属性  属性有自己组 属性组与属性间是多对多关系
     */
    @GetMapping("/list/{catelogId}")
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable("catelogId") long catelogId){
        LambdaQueryWrapper<AttrGroupEntity> wrapper = new LambdaQueryWrapper<>();
        if(catelogId != 0)   wrapper.eq(AttrGroupEntity::getCatelogId, catelogId);
        if(params.containsKey("key") && !StringUtils.isEmpty(params.get("key"))){
            String key = (String) params.get("key");
            wrapper.and(el -> {
                el.eq(AttrGroupEntity::getAttrGroupId, key).or()
                        .like(AttrGroupEntity::getAttrGroupName, key);
            });
        }
        PageUtils pageUtils = attrGroupService.queryPage(params, wrapper);
        return R.ok().put("page", pageUtils);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        List<Long> list = categoryService.findParentPath(attrGroup.getCatelogId());
        attrGroup.setCatelogPath(list);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
