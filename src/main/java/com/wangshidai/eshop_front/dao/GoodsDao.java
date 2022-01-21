package com.wangshidai.eshop_front.dao;

import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.PageInfo;
import com.wangshidai.eshop_front.pojo.TypeInfo;

import java.util.List;

public interface GoodsDao {
    List<TypeInfo> findGoodType(Integer oneLevelGoodParentId);

    List<GoodsInfo> findGood(int type_id1, int child_type_id);

    List<GoodsInfo> findGood(int type_id1, int child_type_id1, String keyword, PageInfo<GoodsInfo> pageInfo);

    int findGoodCount(int type_id1, int child_type_id1, String keyword);
}
