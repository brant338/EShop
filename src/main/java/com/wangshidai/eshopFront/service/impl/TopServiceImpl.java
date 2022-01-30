package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.TopDao;
import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopServiceImpl implements TopService {

    @Autowired
    private TopDao topDao;

    @Override
    public List<TypeInfo> findAll(int parent_id1) {
        return topDao.findAll(parent_id1);
    }
}
