package com.wangshidai.eshop_front.controller;

import com.wangshidai.eshop_front.pojo.GoodPicInfo;
import com.wangshidai.eshop_front.pojo.GoodsInfo;
import com.wangshidai.eshop_front.pojo.PageInfo;
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
                             @YockMvcAnnotation.RequestParam(name="keyword") String keyword,
                             @YockMvcAnnotation.RequestParam(name = "currentPage") String currentPage){
        PageInfo<GoodsInfo> pageInfo = new PageInfo();
        pageInfo.setPageSize(4);

        if(currentPage != null){
            pageInfo.setCurrentPage(Integer.parseInt(currentPage));
        }else{
            pageInfo.setCurrentPage(1);
        }
        //查询一级分类商品类型列表
        List<TypeInfo> oneLevelGoods = goodsService.findGoodType(type_id);
        System.out.println(type_id);
        //搜索
        List<GoodsInfo> goodList = goodsService.findGood(type_id,child_type_id,keyword,pageInfo);
        int goodCount = goodsService.findGoodCount(type_id,child_type_id,keyword);

        //封装分页有关参数
        int totalPage =
                goodCount % pageInfo.getPageSize() ==0 ? goodCount/pageInfo.getPageSize() : goodCount/pageInfo.getPageSize()+1 ;
        pageInfo.setTotalPage(totalPage);
        pageInfo.setCurrentPageData(goodList);
        pageInfo.setTotalSize(goodCount);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("oneLevelGoods",oneLevelGoods);
        modelAndView.addObject("goods",goodList);
        //查询搜索数据总条数
        modelAndView.addObject("goodPage",pageInfo);
        //回显搜索数据
        modelAndView.addObject("keyword",keyword);

        modelAndView.addObject("type_id",type_id);

        modelAndView.addObject("child_type_id",child_type_id);


        return modelAndView;
    }

    @YockMvcAnnotation.RequestMapping("/good.action")
    @YockMvcAnnotation.ResponseDispatch("/WEB-INF/views/product_info.jsp")
    public ModelAndView findGood(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @YockMvcAnnotation.RequestParam(name="book_id") int book_id){

        GoodsInfo goodDetail = goodsService.findGood(book_id);
        List<GoodPicInfo> goodPics = goodsService.findGoodPic(book_id);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("goodDetail",goodDetail);
        modelAndView.addObject("goodPics",goodPics);
        return modelAndView;
    }
}
