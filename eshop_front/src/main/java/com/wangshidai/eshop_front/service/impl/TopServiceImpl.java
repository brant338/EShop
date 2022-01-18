package com.wangshidai.eshop_front.service.impl;

import com.wangshidai.eshop_front.dao.TopDao;
import com.wangshidai.eshop_front.dao.impl.TopDaoImpl;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.service.TopService;

import java.util.List;

public class TopServiceImpl implements TopService {

    private TopDao topDao = new TopDaoImpl();

    @Override
    public List<TypeInfo> findAll(int parent_id1) {
        return topDao.findAll(parent_id1);
    }
}
