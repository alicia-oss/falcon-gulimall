package com.gulimail.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-02 16:31:29
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

