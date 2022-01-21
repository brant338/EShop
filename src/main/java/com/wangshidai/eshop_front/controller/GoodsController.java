package com.wangshidai.eshop_front.controller;

import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.service.GoodsService;
import com.wangshidai.eshop_front.service.impl.GoodsServiceImpl;
import org.lanqiao.mvc.entity.ModelAndView;
import org.lanqiao.mvc.entity.YockMvcAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@YockMvcAnnotation.Controller("/product")
public class GoodsController {

    private GoodsService goodsService = new GoodsServiceImpl();

    @YockMvcAnnotation.RequestMapping("/type.action")
    @YockMvcAnnotation.ResponseDispatch("/WEB-INF/views/productlist.jsp")
    public ModelAndView find(HttpServletRequest request,
                             HttpServletResponse response,
                             @YockMvcAnnotation.RequestParam(name="type_id") String type_id,
                             @YockMvcAnnotation.RequestParam(name="child_type_id") String child_type_id,
                             @YockMvcAnnotation.RequestParam(name="keyword") String keyword){
        int type_id1;
        int child_type_id1;
        if(type_id != null){
            type_id1 = Integer.parseInt(type_id);
        }else{
            type_id1 = 0;
        }
        if(child_type_id != null){
            child_type_id1 = Integer.parseInt(child_type_id);
        }else{
            child_type_id1 = 0;
        }
        //查询一级分类商品类型列表
        List<TypeInfo> oneLevelGoods = goodsService.findGoodType(type_id1);

        //搜索
        List<GoodsInfo> goodList = goodsService.findGood(type_id1,child_type_id1,keyword);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("oneLevelGoods",oneLevelGoods);
        modelAndView.addObject("goods",goodList);
        //回显搜索数据
        modelAndView.addObject("keyword",keyword);
        return modelAndView;
    }
}
