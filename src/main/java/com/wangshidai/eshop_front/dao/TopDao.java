package com.wangshidai.eshop_front.dao;

import com.wangshidai.eshop_front.pojo.TypeInfo;

import java.util.List;

public interface TopDao {
    List<TypeInfo> findAll(int parent_id1);
}
