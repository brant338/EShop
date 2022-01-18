package com.wangshidai.eshop_front.dao;

import com.wangshidai.eshop_front.pojo.TypeInfo;

import java.util.List;

public interface GoodsDao {
    List<TypeInfo> findGoodType(Integer parent_id);
}
