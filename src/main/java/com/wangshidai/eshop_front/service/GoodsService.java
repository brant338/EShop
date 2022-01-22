package com.wangshidai.eshop_front.service;

import com.wangshidai.eshop_front.pojo.GoodPicInfo;
import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.PageInfo;
import com.wangshidai.eshop_front.pojo.TypeInfo;

import java.util.List;

public interface GoodsService {
    /**
     * 查询一级分类商品类型
     *
     * @param oneLevelGoodParentId
     * @return
     */
    List<TypeInfo> findGoodType(Integer oneLevelGoodParentId);

    /**
     * 查询一级分类商品信息
     *
     * @param type_id1
     * @param child_type_id
     * @return
     */
    List<GoodsInfo> findGood(int type_id1, int child_type_id);

    /**
     * 分页查询
     *
     * @param type_id1
     * @param child_type_id1
     * @param keyword
     * @param pageInfo
     * @return
     */
    List<GoodsInfo> findGood(int type_id1, int child_type_id1, String keyword, PageInfo<GoodsInfo> pageInfo);

    /**
     * 根据搜索框查询商品信息
     *
     * @param type_id1
     * @param child_type_id1
     * @param keyword
     * @return
     */
    int findGoodCount(int type_id1, int child_type_id1, String keyword);

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
