package com.gulimail.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.gulimail.product.entity.AttrGroupEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.common.utils.Query;

import com.gulimail.product.dao.BrandDao;
import com.gulimail.product.entity.BrandEntity;
import com.gulimail.product.service.BrandService;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<BrandEntity> wrapper) {
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

}
