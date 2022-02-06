package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.pojo.CartInfo;
import com.wangshidai.eshopFront.pojo.GoodInfo;

import java.util.ArrayList;
import java.util.List;

public interface CartDao {
    /**
     * 根据id查询书籍
     *
     * @param book_id 书籍ID
     * @return
     */
    CartInfo findCartById(String book_id);

    /**
     * 根据Cart查询所有商品信息
     *
     * @param bookIdList
     * @return
     */
    List<GoodInfo> findGoodByCart(ArrayList<Integer> bookIdList);
}
