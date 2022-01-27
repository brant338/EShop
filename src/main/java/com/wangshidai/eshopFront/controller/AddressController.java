package com.wangshidai.eshopFront.controller;


import com.alibaba.fastjson.JSON;
import com.wangshidai.eshopFront.entity.Area;
import com.wangshidai.eshopFront.entity.City;
import com.wangshidai.eshopFront.entity.Province;
import com.wangshidai.eshopFront.entity.ResultBean;
import com.wangshidai.eshopFront.service.AddressService;
import com.wangshidai.eshopFront.service.impl.AddressServiceImpl;
import org.lanqiao.mvc.entity.YockMvcAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@YockMvcAnnotation.Controller("/address")
public class AddressController {

    private AddressService addressService = new AddressServiceImpl();

    @YockMvcAnnotation.RequestMapping("/province.action")
    @YockMvcAnnotation.ResponseVoid
    public void findProvince(HttpServletRequest request,
                               HttpServletResponse reponse) throws IOException {
        List<Province> provinces = addressService.findProvince();
        System.out.println(JSON.toJSONString(new ResultBean(true,provinces)));
        reponse.getWriter().write(JSON.toJSONString(new ResultBean(true,provinces)));
    }

    @YockMvcAnnotation.RequestMapping("/city.action")
    @YockMvcAnnotation.ResponseVoid
    public void findCity(HttpServletRequest request,
                           HttpServletResponse reponse,
                           @YockMvcAnnotation.RequestParam(name = "provinceid") String provinceid) throws IOException {

        List<City> citys = addressService.findCity(provinceid);
        reponse.getWriter().write(JSON.toJSONString(new ResultBean(true,citys)));
    }

    @YockMvcAnnotation.RequestMapping("/area.action")
    @YockMvcAnnotation.ResponseVoid
    public void findArea(HttpServletRequest request,
                           HttpServletResponse reponse,
                           @YockMvcAnnotation.RequestParam(name = "cityid") String cityid) throws IOException {
        List<Area> areas = addressService.findArea(cityid);
        reponse.getWriter().write(JSON.toJSONString(new ResultBean(true,areas)));
    }
}
