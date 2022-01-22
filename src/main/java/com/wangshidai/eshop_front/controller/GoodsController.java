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
        int type_id1;
        int child_type_id1;
        PageInfo<GoodsInfo> pageInfo = new PageInfo();
        pageInfo.setPageSize(4);
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
        if(currentPage != null){
            pageInfo.setCurrentPage(Integer.parseInt(currentPage));
        }else{
            pageInfo.setCurrentPage(1);
        }
        //查询一级分类商品类型列表
        List<TypeInfo> oneLevelGoods = goodsService.findGoodType(type_id1);

        //搜索
        List<GoodsInfo> goodList = goodsService.findGood(type_id1,child_type_id1,keyword,pageInfo);
        int goodCount = goodsService.findGoodCount(type_id1,child_type_id1,keyword);

        //封装分页有关参数
        int totalPage =
                goodCount % pageInfo.getPageSize() ==0 ? goodCount/pageInfo.getPageSize() : goodCount/pageInfo.getPageSize()+1 ;
        pageInfo.setTotalPage(totalPage);
        pageInfo.setCurrentPageData(goodList);
        pageInfo.setTotalSize(goodCount);
        System.out.println("pageInfo +"+pageInfo);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("oneLevelGoods",oneLevelGoods);
        modelAndView.addObject("goods",goodList);
        //查询搜索数据总条数
        modelAndView.addObject("goodPage",pageInfo);
        //回显搜索数据
        modelAndView.addObject("keyword",keyword);

        modelAndView.addObject("child_type_id",child_type_id1);

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
