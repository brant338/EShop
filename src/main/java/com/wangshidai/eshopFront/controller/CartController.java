package com.wangshidai.eshopFront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

        @RequestMapping("/showCart")
        public ModelAndView showCart(){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("cart");
            return  modelAndView;
        }
}
