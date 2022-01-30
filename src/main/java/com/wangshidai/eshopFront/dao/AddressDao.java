package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.entity.Area;
import com.wangshidai.eshopFront.entity.City;
import com.wangshidai.eshopFront.entity.Province;
import org.springframework.stereotype.Repository;


import java.util.List;


public interface AddressDao {


    List<Province> findProvince();

    List<City> findCity(String provinceid);

    List<Area> findArea(String cityid);
}
