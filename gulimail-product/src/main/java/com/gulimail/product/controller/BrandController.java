package com.gulimail.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gulimail.product.entity.AttrGroupEntity;
import com.gulimail.product.eventCenter.eventPublisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gulimail.product.entity.BrandEntity;
import com.gulimail.product.service.BrandService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.common.utils.R;

import javax.validation.Valid;


/**
 * ๅ็
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-01 22:51:13
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    EventPublisher eventPublisher;

    /**
     * ๅ่กจ
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        LambdaQueryWrapper<BrandEntity> wrapper = new LambdaQueryWrapper<>();
        if(params.containsKey("key") && !StringUtils.isEmpty(params.get("key"))){
            String key = (String) params.get("key");
            wrapper.and(el -> {
                el.eq(BrandEntity::getBrandId, key).or()
                        .like(BrandEntity::getName, key);
            });
        }
        PageUtils page = brandService.queryPage(params,wrapper);
        return R.ok().put("page", page);
    }


    /**
     * ไฟกๆฏ
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * ไฟๅญ
     *
     */
    @RequestMapping("/save")
    public R save(@Valid @RequestBody  BrandEntity brand){
        brandService.save(brand);

        return R.ok();
    }

    /**
     * ไฟฎๆน
     */
    @RequestMapping("/update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);
        eventPublisher.publishBrandNameChange(brand.getBrandId(), brand.getName());
        return R.ok();
    }

    /**
     * ๅ?้ค
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
