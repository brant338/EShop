package com.wangshidai.eshopFront.controller;

import com.wangshidai.eshopFront.pojo.GoodPicInfo;
import com.wangshidai.eshopFront.pojo.GoodsInfo;
import com.wangshidai.eshopFront.pojo.PageInfo;
import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.service.GoodsService;
import com.wangshidai.eshopFront.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TopService topService;

    @RequestMapping("/type")
    public ModelAndView find(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam(value = "type_id",required = false) String type_id,
                             @RequestParam(value = "child_type_id",required = false) String child_type_id,
                             @RequestParam(value ="keyword",required = false) String keyword,
                             @RequestParam(value ="currentPage",required = false) String currentPage){
        int parentId = 0;
        List<TypeInfo> rootType = topService.findAll(parentId);

        Map map = new HashMap();


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

        map.put("type_id",type_id);
        map.put("child_type_id",child_type_id);
        map.put("keyword",keyword);
        map.put("pageInfo",pageInfo);

        List<GoodsInfo> goodList = goodsService.findGood(map);
        int goodCount = goodsService.findGoodCount(map);

        //封装分页有关参数
        int totalPage =
                goodCount % pageInfo.getPageSize() ==0 ? goodCount/pageInfo.getPageSize() : goodCount/pageInfo.getPageSize()+1 ;
        pageInfo.setTotalPage(totalPage);
        pageInfo.setCurrentPageData(goodList);
        pageInfo.setTotalSize(goodCount);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productlist");
        modelAndView.addObject("rootType",rootType);
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

    @RequestMapping("/good")
    public ModelAndView findGoodOne(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestParam("book_id") int book_id){

        GoodsInfo goodDetail = goodsService.findGoodOne(book_id);
        List<GoodPicInfo> goodPics = goodsService.findGoodPic(book_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_info");
        modelAndView.addObject("goodDetail",goodDetail);
        modelAndView.addObject("goodPics",goodPics);
        return modelAndView;
    }
}
