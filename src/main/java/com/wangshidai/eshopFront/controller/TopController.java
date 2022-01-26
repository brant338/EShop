package com.wangshidai.eshopFront.controller;

import com.wangshidai.eshopFront.pojo.TypeInfo;
import com.wangshidai.eshopFront.service.TopService;
import com.wangshidai.eshopFront.service.impl.TopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@YockMvcAnnotation.Controller("/type")
@WebServlet("/top")
public class TopController extends HttpServlet {
    private TopService topService = new TopServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.service(request, response);
        String goodDetailMenu = request.getParameter("goodDetailMenu");
        int parentId = 0;
        List<TypeInfo> rootType = topService.findAll(parentId);
        request.setAttribute("rootType",rootType);
        request.setAttribute("goodDetailMenu",goodDetailMenu);
        //请求包含
        request.getRequestDispatcher("WEB-INF/views/top.jsp").include(request,response);
    }
    /*@YockMvcAnnotation.RequestMapping("/list.action")
    @YockMvcAnnotation.ResponseVoid
    public void list(HttpServletRequest request,
                     HttpServletResponse response,
                     @YockMvcAnnotation.RequestParam(name = "class_name") String class_name)
            throws ServletException, IOException {
    }*/
}
