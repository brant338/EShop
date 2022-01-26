package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.pojo.TypeInfo;

import java.util.List;

public interface TopDao {
    List<TypeInfo> findAll(int parent_id1);
}
