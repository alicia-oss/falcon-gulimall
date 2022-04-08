package com.gulimail.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimail.common.utils.PageUtils;
import com.gulimail.member.entity.MemberCollectSpuEntity;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author Felconxx99
 * @email 554884007@qq.com
 * @date 2022-03-02 16:31:29
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

