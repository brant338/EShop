package com.wangshidai.eshop_front.service.impl;

import com.wangshidai.eshop_front.dao.GoodsDao;
import com.wangshidai.eshop_front.dao.impl.GoodsDaoImpl;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public List<TypeInfo> findGoodType(Integer oneLevelGoodParentId) {
        return goodsDao.findGoodType(oneLevelGoodParentId);
    }
}
