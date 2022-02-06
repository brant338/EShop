package com.wangshidai.eshopFront.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangshidai.eshopFront.entity.ResultBean;
import com.wangshidai.eshopFront.pojo.CartInfo;
import com.wangshidai.eshopFront.pojo.GoodInfo;
import com.wangshidai.eshopFront.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/showCart")
    public ModelAndView showCart(HttpServletRequest request,
                                 HttpServletResponse response) {
        Map<Integer,Integer> cartMap = (Map<Integer,Integer>)request.getSession().getAttribute("Cart");
        if(cartMap == null){
            cartMap = new HashMap<Integer,Integer>();
            request.getSession().setAttribute("Cart",cartMap);
        }

        List<GoodInfo> goodByCartList =  cartService.findGoodByCart(cartMap);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        modelAndView.addObject("goodByCartList",goodByCartList);
        return modelAndView;
    }

    @RequestMapping("/addCart")
    public void addCart(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(name = "book_id",required = false) int book_id,
                        @RequestParam(name="num",required = false) int num) throws IOException {
        //购物车存储结构
            /*
            {key=value}
            {book_id=num}
            {21=4,12=1}
            */
        //获取Session
        Map<Integer,Integer> cartMap = (Map<Integer,Integer>)request.getSession().getAttribute("Cart");
        if(cartMap==null){
            //第一次使用session存储购物车数据
            cartMap = new HashMap<>();
            cartMap.put(book_id,num);
        }else{
            boolean isExists = cartMap.containsKey(book_id);
            if(isExists){
                int number = cartMap.get(book_id);
                cartMap.put(book_id,num+number);
            }else{
                cartMap.put(book_id,num);
            }
        }
        //更新Session中的cartMap
        request.getSession().setAttribute("Cart",cartMap);

        ResultBean resultBean = new ResultBean(true,"添加购物车成功");
        response.getWriter().write(new ObjectMapper().writeValueAsString(resultBean));

    }

    @RequestMapping("/removeCart")
    public void removeCart(HttpServletRequest request,
                           HttpServletResponse response) {

    }

    @RequestMapping("/updateCart")
    public void updateCart(HttpServletRequest request,
                           HttpServletResponse response) {


    }

}
