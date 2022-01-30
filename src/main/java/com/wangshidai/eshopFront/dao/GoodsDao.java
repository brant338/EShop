package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.pojo.GoodPicInfo;
import com.wangshidai.eshopFront.pojo.GoodsInfo;

import com.wangshidai.eshopFront.pojo.TypeInfo;
import org.springframework.stereotype.Repository;


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
    List<GoodsInfo> findGood(Map map);

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
    GoodsInfo findGoodOne(int book_id);

    /**
     * 查询商品图片(小图)
     *
     * @param book_id
     * @return
     */
    List<GoodPicInfo> findGoodPic(int book_id);
}
