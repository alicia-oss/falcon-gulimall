package com.gulimail.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-02 16:40:53
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

