package com.wangshidai.eshopFront.service;

import com.wangshidai.eshopFront.pojo.GoodPicInfo;
import com.wangshidai.eshopFront.pojo.GoodsInfo;
import com.wangshidai.eshopFront.pojo.PageInfo;
import com.wangshidai.eshopFront.pojo.TypeInfo;

import java.util.List;

public interface GoodsService {
    /**
     * 查询一级分类商品类型
     *
     * @param rootTypeId
     * @return
     */
    List<TypeInfo> findGoodType(String rootTypeId);

    /**
     * 查询一级分类商品信息
     *
     * @param rootTypeId
     * @param oneLevelTypeId
     * @return
     */
    List<GoodsInfo> findGood(String rootTypeId, String oneLevelTypeId);

    /**
     * 分页查询
     *
     * @param rootTypeId
     * @param oneLevelTypeId
     * @param keyword
     * @param pageInfo
     * @return
     */
    List<GoodsInfo> findGood(String rootTypeId, String oneLevelTypeId, String keyword, PageInfo<GoodsInfo> pageInfo);

    /**
     * 根据搜索框查询商品信息
     *
     * @param rootTypeId
     * @param oneLevelTypeId
     * @param keyword
     * @return
     */
    int findGoodCount(String rootTypeId, String oneLevelTypeId, String keyword);

    /**
     * 查询单个商品
     * @param book_id
     * @return
     */
    GoodsInfo findGood(int book_id);

    /**
     * 查询商品图片(小图)
     *
     * @param book_id
     * @return
     */
    List<GoodPicInfo> findGoodPic(int book_id);
}
