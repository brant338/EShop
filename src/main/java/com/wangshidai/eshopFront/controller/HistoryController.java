package com.wangshidai.eshopFront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @RequestMapping("/showHistory")
    public ModelAndView showHistory(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("history");
        return modelAndView;
    }
}
