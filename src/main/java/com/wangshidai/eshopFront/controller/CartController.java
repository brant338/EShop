package com.wangshidai.eshopFront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

        @RequestMapping("/showCart")
        public ModelAndView showCart(HttpServletRequest request,
                                     HttpServletResponse response){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("cart");
            return  modelAndView;
        }

        @RequestMapping("/addCart")
        public void addCart(HttpServletRequest request,
                            HttpServletResponse response){
            Map<String,Object> returnMap = new HashMap<>();
            //购物车存储结构
            /*
            {key=value}
            {book_id=num}
            {21=4,12=1}
            */


        }

    @RequestMapping("/removeCart")
    public void removeCart(HttpServletRequest request,
                        HttpServletResponse response){

    }

    @RequestMapping("/updateCart")
    public void updateCart(HttpServletRequest request,
                        HttpServletResponse response){


    }

}
