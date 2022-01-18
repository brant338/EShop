package com.wangshidai.eshop_front.service;

import com.wangshidai.eshop_front.pojo.TypeInfo;

import java.util.List;

public interface TopService {
    List<TypeInfo> findAll(int parent_id1);
}
