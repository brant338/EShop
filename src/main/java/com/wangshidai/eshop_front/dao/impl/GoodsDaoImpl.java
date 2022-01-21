package com.wangshidai.eshop_front.dao.impl;

import com.wangshidai.eshop_front.dao.GoodsDao;
import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.utils.MyJdbcUtilsV5;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<TypeInfo> findGoodType(Integer oneLevelGoodParentId) {
        return MyJdbcUtilsV5.acquareFileldToBean(TypeInfo.class,
                "select * from tb_type where parent_id = ?",
                oneLevelGoodParentId);
    }

    @Override
    public List<GoodsInfo> findGood(int type_id1, int child_type_id) {
        String sql = "SELECT * FROM `tb_book` where type_id = ?";
        ArrayList<Object> paramList = new ArrayList<>();
        if(child_type_id != 0){
            paramList.add(child_type_id);
        }else{
            sql += " or type_id in (select type_id from tb_type where parent_id = ?)";
            paramList.add(type_id1);
            paramList.add(type_id1);
        }
        return MyJdbcUtilsV5.acquareFileldToBean(GoodsInfo.class,
                sql,
                paramList.toArray());
    }
}
