package com.gulimail.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.common.utils.Query;

import com.gulimail.product.dao.CategoryDao;
import com.gulimail.product.entity.CategoryEntity;
import com.gulimail.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> entities = this.baseMapper.selectList(null);
        return entities.stream().
                filter(entity -> entity.getParentCid() == 0).
                peek(entity -> entity.setChildren(getChildren(entity, entities))).
                sorted((entity1, entity2) ->
                        (entity1.getSort() == null ? 0 : entity1.getSort()) -
                                (entity2.getSort() == null ? 0 : entity2.getSort())).
                collect(Collectors.toList());
    }

    @Override
    public Integer getChildren(Long item) {
        LambdaQueryWrapper<CategoryEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CategoryEntity::getParentCid,item);
        Integer count = baseMapper.selectCount(wrapper);
        return count;
    }

    @Override
    public List<Long> findParentPath(Long catelogId) {
        CategoryEntity entity = baseMapper.selectById(catelogId);
        LinkedList<Long> res = new LinkedList<>();
        res.addFirst(entity.getCatId());
        while (entity.getParentCid() != 0){
            entity = baseMapper.selectById(entity.getParentCid());
            res.addFirst(entity.getCatId());
        }
        return res;
    }


    private List<CategoryEntity> getChildren(CategoryEntity entity, List<CategoryEntity> entities) {
        return entities.stream()
                .filter(item -> item.getParentCid().equals(entity.getCatId()))
                .peek(item -> item.setChildren(getChildren(item, entities)))
                .sorted(Comparator.comparingInt(item -> (item.getSort() == null ? 0 : item.getSort())))
                .collect(Collectors.toList());
    }

}
