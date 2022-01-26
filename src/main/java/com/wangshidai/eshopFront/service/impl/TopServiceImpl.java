package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.TopDao;
import com.wangshidai.eshopFront.dao.impl.TopDaoImpl;
import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.service.TopService;

import java.util.List;

public class TopServiceImpl implements TopService {

    private TopDao topDao = new TopDaoImpl();

    @Override
    public List<TypeInfo> findAll(int parent_id1) {
        return topDao.findAll(parent_id1);
    }
}
