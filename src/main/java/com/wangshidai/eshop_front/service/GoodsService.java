package com.wangshidai.eshop_front.service;

import com.wangshidai.eshop_front.pojo.TypeInfo;

import java.util.List;

public interface GoodsService {
    List<TypeInfo> findGoodType(Integer parent_id);
}
