package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.GoodsDao;
import com.wangshidai.eshopFront.dao.impl.GoodsDaoImpl;
import com.wangshidai.eshopFront.pojo.GoodPicInfo;
import com.wangshidai.eshopFront.pojo.GoodsInfo;
import com.wangshidai.eshopFront.pojo.PageInfo;
import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public List<TypeInfo> findGoodType(String rootTypeId) {
        return goodsDao.findGoodType(rootTypeId);
    }

    @Override
    public List<GoodsInfo> findGood(String rootTypeId, String oneLevelTypeId) {
        return goodsDao.findGood(rootTypeId, oneLevelTypeId);
    }

    @Override
    public List<GoodsInfo> findGood(String rootTypeId, String oneLevelTypeId, String keyword, PageInfo<GoodsInfo> pageInfo) {
        return goodsDao.findGood(rootTypeId,oneLevelTypeId,keyword,pageInfo);
    }

    @Override
    public int findGoodCount(String rootTypeId, String oneLevelTypeId, String keyword) {
        return goodsDao.findGoodCount(rootTypeId,oneLevelTypeId,keyword);
    }

    @Override
    public GoodsInfo findGood(int book_id) {
        return goodsDao.findGood(book_id);
    }

    @Override
    public List<GoodPicInfo> findGoodPic(int book_id) {
        return goodsDao.findGoodPic(book_id);
    }


}
