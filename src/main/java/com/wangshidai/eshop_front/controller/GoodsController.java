package com.wangshidai.eshop_front.controller;

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
                             @YockMvcAnnotation.RequestParam(name = "parentId") String parentId,
                             @YockMvcAnnotation.RequestParam(name="type_id") String type_id){
        int parent_id1;
        int type_id1;
        if(parentId != null){
            parent_id1 = Integer.parseInt(parentId);
        }else{
            parent_id1=0;
        }
        if(type_id != null){
            type_id1 = Integer.parseInt(type_id);
        }else{
            type_id1 = 0;
        }
        ModelAndView modelAndView = new ModelAndView();
        List<TypeInfo> typeList = goodsService.findGoodType(parent_id1);
        modelAndView.addObject("goodTypes",typeList);
        modelAndView.addObject("type_id",type_id1);
        return modelAndView;
    }
}
