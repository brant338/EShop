package com.wangshidai.eshopFront.controller;


import com.alibaba.fastjson.JSON;
import com.wangshidai.eshopFront.entity.Area;
import com.wangshidai.eshopFront.entity.City;
import com.wangshidai.eshopFront.entity.Province;
import com.wangshidai.eshopFront.entity.ResultBean;
import com.wangshidai.eshopFront.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/province")
    public void findProvince(HttpServletRequest request,
                               HttpServletResponse reponse) throws IOException {
        List<Province> provinces = addressService.findProvince();
        System.out.println(JSON.toJSONString(new ResultBean(true,provinces)));
        reponse.getWriter().write(JSON.toJSONString(new ResultBean(true,provinces)));
    }

    @RequestMapping("/city")
    public void findCity(HttpServletRequest request,
                           HttpServletResponse reponse,
                           @RequestBody Province province) throws IOException {
        String provinceid = province.getProvinceid();
        List<City> citys = addressService.findCity(provinceid);
        reponse.getWriter().write(JSON.toJSONString(new ResultBean(true,citys)));
    }

    @RequestMapping("/area")
    public void findArea(HttpServletRequest request,
                           HttpServletResponse reponse,
                           @RequestBody City city) throws IOException {
        String cityid = city.getCityid();
        List<Area> areas = addressService.findArea(cityid);
        reponse.getWriter().write(JSON.toJSONString(new ResultBean(true,areas)));
    }
}
