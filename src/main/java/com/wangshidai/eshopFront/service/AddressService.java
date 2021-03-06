package com.wangshidai.eshopFront.service;

import com.wangshidai.eshopFront.entity.Area;
import com.wangshidai.eshopFront.entity.City;
import com.wangshidai.eshopFront.entity.Province;

import java.util.List;

public interface AddressService {
    List<Province> findProvince();

    List<City> findCity(String provinceid);

    List<Area> findArea(String cityid);
}
