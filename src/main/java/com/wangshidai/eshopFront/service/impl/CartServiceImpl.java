package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.CartDao;
import com.wangshidai.eshopFront.pojo.CartInfo;
import com.wangshidai.eshopFront.pojo.GoodInfo;
import com.wangshidai.eshopFront.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public CartInfo findCartById(String book_id) {
        return cartDao.findCartById(book_id);
    }

    @Override
    public List<GoodInfo> findGoodByCart(Map<Integer, Integer> cartMap) {

        ArrayList<Integer> bookIdList = new ArrayList<>();

        if(cartMap.size() > 0){
            Set<Integer> keySet = cartMap.keySet();
            for (Integer bookId : keySet) {
                bookIdList.add(bookId);
            }
            List<GoodInfo> GoodInfoList = cartDao.findGoodByCart(bookIdList);
            //设置购物车中每个商品的数量
            for (GoodInfo goodInfo : GoodInfoList) {
                Integer num = cartMap.get(goodInfo.getBook_id());
                goodInfo.setNum(num);
            }
            return GoodInfoList;
        }
        return null;
    }
}
