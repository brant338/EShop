package com.wangshidai.eshop_front.dao.impl;

import com.wangshidai.eshop_front.dao.GoodsDao;
import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.PageInfo;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.utils.MyJdbcUtilsV5;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<TypeInfo> findGoodType(Integer oneLevelGoodParentId) {
        return MyJdbcUtilsV5.acquareFileldToBean(TypeInfo.class,
                "select * from tb_type where parent_id = ?",
                oneLevelGoodParentId);
    }

    @Override
    public List<GoodsInfo> findGood(int type_id1, int child_type_id) {
        String sql = "SELECT * FROM `tb_book` where type_id = ?";
        ArrayList<Object> paramList = new ArrayList<>();
        if(child_type_id != 0){
            paramList.add(child_type_id);
        }else{
            sql += " or type_id in (select type_id from tb_type where parent_id = ?)";
            paramList.add(type_id1);
            paramList.add(type_id1);
        }
        return MyJdbcUtilsV5.acquareFileldToBean(GoodsInfo.class,
                sql,
                paramList.toArray());
    }

    @Override
    public List<GoodsInfo> findGood(int type_id1, int child_type_id1, String keyword, PageInfo<GoodsInfo> pageInfo) {
        String sql = "  ";
        ArrayList<Object> goodsInfos = new ArrayList<>();
        if(keyword == null || keyword.isEmpty()){
            sql = "SELECT * FROM `tb_book` where type_id = ?";
            if(child_type_id1 != 0){
                goodsInfos.add(child_type_id1);
            }else{
                sql += " or type_id in (select type_id from tb_type where parent_id = ?)";
                goodsInfos.add(type_id1);
                goodsInfos.add(type_id1);
            }
        }else{
            sql = " select * from tb_book \n" +
                    "where (type_id = ? or type_id in (select type_id from tb_type where parent_id = ?)) \n" +
                    "and (book_name like ? or book_author like ? or book_press like ?)\n" +
                    "order by book_id";
            goodsInfos.add(type_id1);
            goodsInfos.add(type_id1);
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
    public int findGoodCount(int type_id1, int child_type_id1, String keyword) {
        String sql = "  ";
        ArrayList<Object> goodsInfos = new ArrayList<>();
        if(keyword == null || keyword.isEmpty()){
            sql = "SELECT count(*) FROM `tb_book` where type_id = ?";
            if(child_type_id1 != 0){
                goodsInfos.add(child_type_id1);
            }else{
                sql += " or type_id in (select type_id from tb_type where parent_id = ?)";
                goodsInfos.add(type_id1);
                goodsInfos.add(type_id1);
            }
        }else{
            sql = " select count(*) from tb_book \n" +
                    "where (type_id = ? or type_id in (select type_id from tb_type where parent_id = ?)) \n" +
                    "and (book_name like ? or book_author like ? or book_press like ?)\n" +
                    "order by book_id";
            goodsInfos.add(type_id1);
            goodsInfos.add(type_id1);
            goodsInfos.add("%"+keyword+"%");
            goodsInfos.add("%"+keyword+"%");
            goodsInfos.add("%"+keyword+"%");
        }
        return ((Long)MyJdbcUtilsV5.acquireSqlQuaryOne(sql,goodsInfos.toArray())).intValue();
    }
}
