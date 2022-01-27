package com.wangshidai.eshopFront.dao.impl;

import com.wangshidai.eshopFront.dao.AddressDao;
import com.wangshidai.eshopFront.entity.Area;
import com.wangshidai.eshopFront.entity.City;
import com.wangshidai.eshopFront.entity.Province;
import com.wangshidai.eshopFront.utils.MyJdbcUtilsV5;

import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Override
    public List<Province> findProvince() {
        String sql = "select * from provinces";
        return MyJdbcUtilsV5.acquareFileldToBean(Province.class,
                sql);
    }

    @Override
    public List<City> findCity(String provinceid) {
        String sql = "select * from cities where provinceid = ?";
        return MyJdbcUtilsV5.acquareFileldToBean(City.class,
                sql,provinceid);
    }

    @Override
    public List<Area> findArea(String cityid) {
        String sql = "select * from areas where cityid = ?";
        return MyJdbcUtilsV5.acquareFileldToBean(Area.class,
                sql,cityid);
    }
}
