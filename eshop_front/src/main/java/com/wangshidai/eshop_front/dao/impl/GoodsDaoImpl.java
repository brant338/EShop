package com.wangshidai.eshop_front.dao.impl;

import com.wangshidai.eshop_front.dao.GoodsDao;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.utils.MyJdbcUtilsV5;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<TypeInfo> findGoodType(Integer parent_id) {
        return MyJdbcUtilsV5.acquareFileldToBean(TypeInfo.class,
                "select * from tb_type where parent_id = ?",
                parent_id);
    }
}
