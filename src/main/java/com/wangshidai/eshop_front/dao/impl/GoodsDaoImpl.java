package com.wangshidai.eshop_front.dao.impl;

import com.wangshidai.eshop_front.dao.GoodsDao;
import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.utils.MyJdbcUtilsV5;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<TypeInfo> findGoodType(Integer oneLevelGoodParentId) {
        return MyJdbcUtilsV5.acquareFileldToBean(TypeInfo.class,
                "select * from tb_type where parent_id = ?",
                oneLevelGoodParentId);
    }

    @Override
    public List<GoodsInfo> findGood(int goodId) {
        return MyJdbcUtilsV5.acquareFileldToBean(GoodsInfo.class,
                "SELECT * FROM `tb_book` where type_id = 1 \n" +
                "or type_id in (select type_id from tb_type where parent_id = ?)",
                goodId);
    }
}
