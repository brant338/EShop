package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.GoodsDao;
import com.wangshidai.eshopFront.pojo.GoodPicInfo;
import com.wangshidai.eshopFront.pojo.GoodInfo;
import com.wangshidai.eshopFront.pojo.PageInfo;
import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<TypeInfo> findGoodType(String rootTypeId) {
        return goodsDao.findGoodType(rootTypeId);
    }

    @Override
    public List<GoodInfo> findGood(Map map) {
        PageInfo pageInfo = (PageInfo)map.get("pageInfo");
        map.put("startIndex",(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize());
        return goodsDao.findGood(map);
    }

    @Override
    public int findGoodCount(Map map) {
        return goodsDao.findGoodCount(map);
    }

    @Override
    public GoodInfo findGoodOne(int book_id) {

        return goodsDao.findGoodOne(book_id);
    }

    @Override
    public List<GoodPicInfo> findGoodPic(int book_id) {
        return goodsDao.findGoodPic(book_id);
    }




}
