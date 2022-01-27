package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.AddressDao;
import com.wangshidai.eshopFront.dao.impl.AddressDaoImpl;
import com.wangshidai.eshopFront.entity.Area;
import com.wangshidai.eshopFront.entity.City;
import com.wangshidai.eshopFront.entity.Province;
import com.wangshidai.eshopFront.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = new AddressDaoImpl();
    @Override
    public List<Province> findProvince() {
        return addressDao.findProvince();
    }

    @Override
    public List<City> findCity(String provinceid) {
        return addressDao.findCity(provinceid);
    }

    @Override
    public List<Area> findArea(String cityid) {
        return addressDao.findArea(cityid);
    }
}
