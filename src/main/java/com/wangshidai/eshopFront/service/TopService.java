package com.wangshidai.eshopFront.service;

import com.wangshidai.eshopFront.pojo.TypeInfo;

import java.util.List;

public interface TopService {
    List<TypeInfo> findAll(int parent_id1);
}
