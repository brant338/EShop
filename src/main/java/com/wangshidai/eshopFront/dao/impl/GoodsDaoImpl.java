package com.wangshidai.eshopFront.dao.impl;

import com.wangshidai.eshopFront.dao.GoodsDao;
import com.wangshidai.eshopFront.pojo.GoodPicInfo;
import com.wangshidai.eshopFront.pojo.GoodsInfo;
import com.wangshidai.eshopFront.pojo.PageInfo;
import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.utils.MyJdbcUtilsV5;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<TypeInfo> findGoodType(String rootTypeId) {
        return MyJdbcUtilsV5.acquareFileldToBean(TypeInfo.class,
                "select * from tb_type where parent_id = ?",
                rootTypeId);
    }

    @Override
    public List<GoodsInfo> findGood(String rootTypeId, String oneLevelTypeId) {
        String sql = "SELECT * FROM `tb_book` where type_id = ?";
        ArrayList<Object> paramList = new ArrayList<>();
        if(oneLevelTypeId == null || !oneLevelTypeId.isEmpty()){
            paramList.add(oneLevelTypeId);
        }else{
            sql += " or type_id in (select type_id from tb_type where parent_id = ?)";
            paramList.add(rootTypeId);
            paramList.add(rootTypeId);
        }
        return MyJdbcUtilsV5.acquareFileldToBean(GoodsInfo.class,
                sql,
                paramList.toArray());
    }

    @Override
    public List<GoodsInfo> findGood(String rootTypeId, String oneLevelTypeId, String keyword, PageInfo<GoodsInfo> pageInfo) {
        String sql = "  ";
        ArrayList<Object> goodsInfos = new ArrayList<>();
        //区分首页搜索,商品详情搜索还是非首页搜索
        //首页搜索,商品详情搜索指在全部商品下搜索
        //非首页搜索是指在0级分类下搜索
        if(rootTypeId != null && !rootTypeId.isEmpty()){
            if(keyword == null || keyword.isEmpty()){
                sql = " SELECT * FROM `tb_book` where type_id = ?";
                if(oneLevelTypeId != null && !oneLevelTypeId.isEmpty()){
                    goodsInfos.add(oneLevelTypeId);
                }else{
                    sql += " or type_id in (select type_id from tb_type where parent_id = ?)";
                    goodsInfos.add(rootTypeId);
                    goodsInfos.add(rootTypeId);
                }
            }else{
                sql = " select * from tb_book \n" +
                        " where (type_id = ? or type_id in (select type_id from tb_type where parent_id = ?)) \n" +
                        " and (book_name like ? or book_author like ? or book_press like ?)\n" +
                        " order by book_id";
                goodsInfos.add(rootTypeId);
                goodsInfos.add(rootTypeId);
                goodsInfos.add("%"+keyword+"%");
                goodsInfos.add("%"+keyword+"%");
                goodsInfos.add("%"+keyword+"%");
            }
        }else{
            sql = " select * from tb_book \n" +
                    " where book_name like ? or book_author like ? or book_press like ? \n" +
                    " order by book_id";
            goodsInfos.add("%"+keyword+"%");
            goodsInfos.add("%"+keyword+"%");
            goodsInfos.add("%"+keyword+"%");
        }
        sql += " limit ?,? ";
        goodsInfos.add((pageInfo.getCurrentPage()-1)*pageInfo.getPageSize());
        goodsInfos.add(pageInfo.getPageSize());

        return MyJdbcUtilsV5.acquareFileldToBean(GoodsInfo.class,
                sql,
                goodsInfos.toArray());
    }

    @Override
    public int findGoodCount(String rootTypeId, String oneLevelTypeId,  String keyword) {
        String sql = "  ";
        ArrayList<Object> goodsInfos = new ArrayList<>();
        //区分首页搜索,商品详情搜索还是非首页搜索
        //首页搜索,商品详情搜索指在全部商品下搜索
        //非首页搜索是指在0级分类下搜索
        if(rootTypeId != null && !rootTypeId.isEmpty()){
            if(keyword == null || keyword.isEmpty()){
                sql = " SELECT count(*) FROM `tb_book` where type_id = ? ";
                if(oneLevelTypeId != null && !oneLevelTypeId.isEmpty()){
                    goodsInfos.add(oneLevelTypeId);
                }else{
                    sql += " or type_id in (select type_id from tb_type where parent_id = ?) ";
                    goodsInfos.add(rootTypeId);
                    goodsInfos.add(rootTypeId);
                }
            }else{
                sql = " select count(*) from tb_book \n" +
                        " where (type_id = ? or type_id in (select type_id from tb_type where parent_id = ?)) \n" +
                        " and (book_name like ? or book_author like ? or book_press like ?)\n" +
                        " order by book_id";
                goodsInfos.add(rootTypeId);
                goodsInfos.add(rootTypeId);
                goodsInfos.add("%"+keyword+"%");
                goodsInfos.add("%"+keyword+"%");
                goodsInfos.add("%"+keyword+"%");
            }
        }else{
                sql = " select count(*) from tb_book \n" +
                        " where book_name like ? or book_author like ? or book_press like ? \n" +
                        " order by book_id";
                goodsInfos.add("%"+keyword+"%");
                goodsInfos.add("%"+keyword+"%");
                goodsInfos.add("%"+keyword+"%");
        }
        return ((Long)MyJdbcUtilsV5.acquireSqlQuaryOne(sql,goodsInfos.toArray())).intValue();
    }

    @Override
    public GoodsInfo findGood(int book_id) {
        return MyJdbcUtilsV5.acquareFileldToBeanOneLine(GoodsInfo.class,
                " select * from tb_book where book_id = ? ",
                book_id);
    }

    @Override
    public List<GoodPicInfo> findGoodPic(int book_id) {
        return MyJdbcUtilsV5.acquareFileldToBean(GoodPicInfo.class,
                " select * from tb_book_pic where book_id = ? ",
                book_id);
    }
}
