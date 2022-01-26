package com.wangshidai.eshopFront.dao.impl;

import com.wangshidai.eshopFront.dao.TopDao;
import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.utils.MyJdbcUtilsV5;

import java.util.List;

public class TopDaoImpl implements TopDao {
    @Override
    public List<TypeInfo> findAll(int parent_id1) {
        return MyJdbcUtilsV5.acquareFileldToBean(TypeInfo.class,
                "select * from tb_type where parent_id = ?",
                parent_id1);
    }
}
