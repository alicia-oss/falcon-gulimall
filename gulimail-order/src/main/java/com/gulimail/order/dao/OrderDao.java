package com.gulimail.order.dao;

import com.gulimail.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-02 16:24:05
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
