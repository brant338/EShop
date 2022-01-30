package com.wangshidai.eshopFront.controller;

import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.service.TopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/top")
@Controller
@RequestMapping("/top")
public class TopController extends HttpServlet {

    @Autowired
    private TopService topService;

    @RequestMapping("/topMenu")
    protected void topMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String goodDetailMenu = request.getParameter("goodDetailMenu");
        int parentId = 0;
        List<TypeInfo> rootType = topService.findAll(parentId);

        request.setAttribute("rootType",rootType);
        request.setAttribute("goodDetailMenu",goodDetailMenu);
        //请求包含
        request.getRequestDispatcher("/WEB-INF/views/top.jsp").include(request,response);
    }
}
