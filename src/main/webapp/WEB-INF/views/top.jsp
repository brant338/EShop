<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/12/11
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="site_nav">
    <div class="sn_container clearfix">
        <ul class="tg_tools fr">
            <li class="no-hover">
                <a id="msg_notify" class="msg_notify" href="member_message.html"></a>
            </li>
            <li class='box_color nav_home'>
                <span><a href="${pageContext.request.contextPath}/user/member.action"><span>我的账户</span></a></span><b class="icon"></b>
                <ul>
                    <li>
                        <a href="history.html"><span>浏览记录</span></a>
                    </li>

                    <li>
                        <a href="cart.html"><span>购物车(10)</span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/user/logOut.action"><span>退出登录</span></a>
                    </li>
                </ul>
            </li>
            <li class="tg-line icon"></li>
            <li class='box_color'>
                <span>帮助中心</span><b class="icon"></b>
                <ul>
                    <li>
                        <a href="#"><span>联系我们</span></a>
                    </li>
                    <li>
                        <a href="#"><span>关于我们</span></a>
                    </li>
                </ul>
            </li>
        </ul>
        <ul class="tg_tools fl" id="login_area">
            <li class="tg_tools_home no-hover"><i class="icon-more"></i><span><a href="${pageContext.request.contextPath}/">eshop首页</a></span></li>
            <li class="tg-line icon"></li>

            <c:if test="${ empty sessionScope.user.user_name}">
                <li class="no-hover nologin"><span><a href="reg.html">注册</a></span></li>
                <li class="tg-line icon"></li>
                <li class="no-hover nologin"><span><a href="${pageContext.request.contextPath}/user/showLogin.action">亲，请先登录！</a></span></li>
            </c:if>
            <c:if test="${ !empty sessionScope.user.user_name }">
                <li class="no-hover nologin"><span><a href="reg.html">欢迎您</a></span></li>
                <li class="tg-line icon"></li>
                <li class="no-hover nologin"><span><a href="${pageContext.request.contextPath}/user/showLogin.action">${sessionScope.user.user_name }</a></span></li>
            </c:if>

           </ul>
    </div>
</div>
<div id="header">
    <div class="tg_tools_home">
        <div class="logo">
            <a class="logo-bd" href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/public/css/images/logo.png" alt="Eshop" width="75px" height="70px" /></a>
        </div>
        <form action="${pageContext.request.contextPath}/product/type.action?type_id=${type_id}&child_type_id=${child_type_id}" method="post" id="form_search">
            <div id='search'>
                <div class="search_area">
                    <input type='submit' value='搜 索' class='btn_search' />
                    <div class="search_select">
                        <span class="icon-search"></span>
                    </div>
                    <input type='text' name="keyword" value='${keyword}' class="search_input" autocomplete="off" id="search_input" data-default="请输入搜索内容"
                           onblur="checkInputBlur($(this))" onfocus="checkInputFocus($(this))" />
                </div>
                <div class="search_box hide" id="search_box"></div>
                <div class='search_keywords'>
                    <span>热门搜索：</span>
                    <a href="product_list.jsp?keyword=手机" class="red">手机</a>
                    <a href="product_list.jsp?keyword=盗墓笔记">盗墓笔记</a>
                    <a href="product_list.jsp?keyword=bootstrap">bootstrap</a>
                    <a href="product_list.jsp?keyword=鲁滨逊漂流记">鲁滨逊漂流记</a>
                    <a href="product_list.jsp?keyword=疯狂java" class="red">疯狂java</a>
                </div>
            </div>
        </form>
    </div>
</div>

<c:if test="${empty goodDetailMenu}">
    <div id='nav' class='nav'>
        <div class='nav_main clearfix' id="topMenu">
            <a href="${pageContext.request.contextPath}/" class="menu ${type_id == 0 ? 'current' : ''}">首 页</a>
            <c:forEach items="${rootType}" var="type" >
                <a href="${pageContext.request.contextPath}/product/type.action?type_id=${type.type_id}"
                   class="menu ${type_id == type.type_id ? 'current' : ''} "> ${type.type_name}
                </a>
            </c:forEach>
        </div>
    </div>
</c:if>


</body>
</html>
