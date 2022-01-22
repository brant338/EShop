package com.wangshidai.eshop_front.service.impl;

import com.wangshidai.eshop_front.dao.GoodsDao;
import com.wangshidai.eshop_front.dao.impl.GoodsDaoImpl;
import com.wangshidai.eshop_front.pojo.GoodPicInfo;
import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.PageInfo;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public List<TypeInfo> findGoodType(Integer oneLevelGoodParentId) {
        return goodsDao.findGoodType(oneLevelGoodParentId);
    }

    @Override
    public List<GoodsInfo> findGood(int type_id1, int child_type_id) {
        return goodsDao.findGood(type_id1, child_type_id);
    }

    @Override
    public List<GoodsInfo> findGood(int type_id1, int child_type_id1, String keyword, PageInfo<GoodsInfo> pageInfo) {
        return goodsDao.findGood(type_id1,child_type_id1,keyword,pageInfo);
    }

    @Override
    public int findGoodCount(int type_id1, int child_type_id1, String keyword) {
        return goodsDao.findGoodCount(type_id1,child_type_id1,keyword);
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
