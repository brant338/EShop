package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.pojo.GoodPicInfo;
import com.wangshidai.eshopFront.pojo.GoodInfo;

import com.wangshidai.eshopFront.pojo.TypeInfo;


import java.util.List;
import java.util.Map;



public interface GoodsDao {
    /**
     * 查询一级商品类型
     *
     * @param rootTypeId
     * @return
     */
    List<TypeInfo> findGoodType(String rootTypeId);

    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    List<GoodInfo> findGood(Map map);

    /**
     * 查询商品总个数
     *
     * @param map
     * @return
     */
    int findGoodCount(Map map);

    /**
     * 查询单个商品
     *
     * @param book_id
     * @return
     */
    GoodInfo findGoodOne(int book_id);

    /**
     * 查询商品图片(小图)
     *
     * @param book_id
     * @return
     */
    List<GoodPicInfo> findGoodPic(int book_id);

    List<GoodInfo> findGoodByCart(Map<Integer, Integer> cartMap);
}
