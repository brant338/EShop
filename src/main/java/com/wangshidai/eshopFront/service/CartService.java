package com.wangshidai.eshopFront.service;

import com.wangshidai.eshopFront.pojo.CartInfo;
import com.wangshidai.eshopFront.pojo.GoodInfo;

import java.util.List;
import java.util.Map;


public interface CartService {
    CartInfo findCartById(String book_id);

    List<GoodInfo> findGoodByCart(Map<Integer, Integer> cartMap);
}
