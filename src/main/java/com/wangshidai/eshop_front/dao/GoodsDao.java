package com.wangshidai.eshop_front.dao;

import com.wangshidai.eshop_front.pojo.GoodPicInfo;
import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.PageInfo;
import com.wangshidai.eshop_front.pojo.TypeInfo;

import java.util.List;

public interface GoodsDao {
    /**
     * 查询一级商品类型
     *
     * @param rootTypeId
     * @return
     */
    List<TypeInfo> findGoodType(String rootTypeId);

    /**
     * 查询 未添加搜索
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
     * 查询商品总个数
     *
     * @param rootTypeId
     * @param oneLevelTypeId
     * @param keyword
     * @return
     */
    int findGoodCount(String rootTypeId, String oneLevelTypeId, String keyword);

    /**
     * 查询单个商品
     *
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
