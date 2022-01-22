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
     * @param oneLevelGoodParentId
     * @return
     */
    List<TypeInfo> findGoodType(Integer oneLevelGoodParentId);

    /**
     * 查询 未添加搜索
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
     * 查询商品总个数
     *
     * @param type_id1
     * @param child_type_id1
     * @param keyword
     * @return
     */
    int findGoodCount(int type_id1, int child_type_id1, String keyword);

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
