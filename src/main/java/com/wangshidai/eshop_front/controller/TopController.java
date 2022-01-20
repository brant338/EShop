package com.wangshidai.eshop_front.controller;

import com.wangshidai.eshop_front.pojo.TypeInfo;
import com.wangshidai.eshop_front.service.TopService;
import com.wangshidai.eshop_front.service.impl.TopServiceImpl;
import org.lanqiao.mvc.entity.YockMvcAnnotation;

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
        String parentId = request.getParameter("parentId");
        String type_id = request.getParameter("type_id");

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
        List<TypeInfo> rootType = topService.findAll(parent_id1);
        request.setAttribute("rootType",rootType);
        request.setAttribute("type_id",type_id1);
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
