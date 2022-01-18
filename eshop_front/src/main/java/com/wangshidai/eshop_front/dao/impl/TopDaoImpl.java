package com.wangshidai.eshop_front.dao.impl;

import com.wangshidai.eshop_front.dao.TopDao;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.utils.MyJdbcUtilsV5;

import java.util.List;

public class TopDaoImpl implements TopDao {
    @Override
    public List<TypeInfo> findAll(int parent_id1) {
        return MyJdbcUtilsV5.acquareFileldToBean(TypeInfo.class,
                "select * from tb_type where parent_id = ?",
                parent_id1);
    }
}
