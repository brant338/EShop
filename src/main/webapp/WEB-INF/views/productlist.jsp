<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/12/17
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="all" name="robots" />
    <meta name="author" content="Fisher" />
    <meta name="Copyright"
          content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
    <meta name="description" content="reefdesign" />
    <meta name="keywords" content="reefdesign" />
    <title>eshop电子书城</title>
    <link rel="shortcut icon" href="favicon.ico" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css" type="text/css" />
    <!--头部-->
</head>
<body>

<c:import url="/top" />
<!--商品展示区-->
<div id="classify" class="tg_classify">
    <div class="tg_tab_box on">
        <div class="tg_classify_wrap clearfix">
            <dl class="tg_classify_all tg_classify_flat dl_left">
                <dt class="">
                    <i class="icon_order"></i> 书籍分类
                </dt>
            </dl>
            <dl class="tg_classify_all tg_classify_flat clearfix dl_right">
                <c:forEach items="${rootType}" var="type">
                    <dd class="${type.type_id == type_id ? 'on' : ''}">
                        <a href="${pageContext.request.contextPath}/product/type.action?type_id=${type.type_id}">
                            <span>${type.type_name}</span>
                        </a>
                    </dd>
                </c:forEach>
            </dl>
        </div>

        <div class="tg_classify_wrap clearfix">
            <dl class="tg_classify_all tg_classify_flat dl_left">
                <dt class="">
                    <i class="icon_order"></i> ${rootLevelGood}
                </dt>
            </dl>
            <dl class="tg_classify_all tg_classify_flat clearfix dl_right">
                <dd class="on">
                    <a href="product_list.html"><span>不限</span></a>
                </dd>
                <c:forEach items="${oneLevelGoods}" var="oneLevelGood">
                    <dd class="">
                        <a href="${pageContext.request.contextPath}/product/type.action?type_id=${type_id}&child_type_id=${oneLevelGood.type_id}">
                            <span>${oneLevelGood.type_name}</span>
                        </a>
                    </dd>
                </c:forEach>
            </dl>
        </div>
    </div>
</div>

<div id="container">
    <div id="sort" class="tg_sort clearfix">
        <div class="tg_classify_wrap">
            <dl class="tg_classify_toggle">
                <dt class="on">
                    <a href="js.html?/0-0-1-0"> <i class="icon_order"></i> <span>综合</span>
                        <b class="icon_order"></b>
                    </a>
                </dt>
            </dl>
        </div>
        <div class="tg_classify_wrap">
            <dl class="tg_classify_toggle">
                <dt class="">
                    <a href="js.html?/0-0-2-0"> <i class="icon_order"></i> <span>地区</span>
                        <b class="icon_order"></b>
                    </a>
                </dt>
            </dl>
        </div>
        <div class="tg_classify_wrap">
            <dl class="tg_classify_toggle">
                <dt class="">
                    <a href="js.html?/0-0-3-0"> <i class="icon_order"></i> <span>人气</span>
                        <b class="icon_order"></b>
                    </a>
                </dt>
            </dl>
        </div>
        <div class="tg_classify_wrap">
            <dl class="tg_classify_toggle">
                <dt class="">
                    <a href="js.html?/0-0-4-0"> <i class="icon_order"></i> <span>价格</span>
                        <b class="icon_order"></b>
                    </a>
                </dt>
            </dl>
        </div>
        <div class="tg_classify_wrap">
            <dl class="tg_classify_simplecheck">
                <dt class="">
                    <a href="js.html?/0-0-6-0"> <i class="icon_order"></i> <span>销量</span>
                    </a>
                </dt>
            </dl>
        </div>

        <c:set var="pageUrl">
            ${pageContext.request.contextPath}/product/type.action?type_id=${type_id}&child_type_id=${child_type_id}&keyword=${keyword}
        </c:set>

        <div id="order-page" class="order-page">


				<span class="find_results_num">
					共<span class="red"> ${goodPage.totalSize}</span>
					商品
				</span>
            <span class="page-small">
						<a class="prev-btn page-btn" <c:if test="${goodPage.currentPage <= 1}">href="javascript:;"</c:if>
                           <c:if test="${goodPage.currentPage > 1}">href="${pageUrl}&currentPage=${goodPage.currentPage-1}"</c:if>>
							<span class="arrow-left arrow arrow-left-none" <c:if test="${goodPage.currentPage <= 1}">style="border-right: 5px solid #ccc;" </c:if>
                                  <c:if test="${goodPage.currentPage > 1}">style="border-right: 5px solid #2A2C2E;"</c:if>></span>
						</a>
                <!-- 显示页码 -->
        <c:if test="${goodPage.totalPage <= 1}">
                <span class="orange">${goodPage.currentPage}</span>
        </c:if>
        <c:if test="${goodPage.totalPage > 1}">
            <c:if test="${goodPage.currentPage >1 && (goodPage.totalPage-goodPage.currentPage) < 1 }">
                ${goodPage.currentPage-1}/<span class="orange">${goodPage.currentPage}</span>
            </c:if>
            <c:if test="${goodPage.totalPage > 1 && (goodPage.totalPage-goodPage.currentPage) >= 1}">
                <span class="orange">${goodPage.currentPage}</span>/${goodPage.currentPage+1}
            </c:if>
        </c:if>
						<a class="pnext-btn page-btn" <c:if test="${goodPage.currentPage >= goodPage.totalPage}">href="javascript:;"</c:if>
                           <c:if test="${goodPage.currentPage < goodPage.totalPage}">href="${pageUrl}&currentPage=${goodPage.currentPage+1}"</c:if>>
							<span class="arrow-right arrow" <c:if test="${goodPage.currentPage >= goodPage.totalPage}">style="border-left: 5px solid #ccc;"</c:if>
                                  <c:if test="${goodPage.currentPage < goodPage.totalPage}">style="border-left: 5px solid #2A2C2E;"</c:if>></span>
						</a>
				</span>
        </div>

    </div>
    <div class="list">
        <div class="list_main clearfix">
            <c:forEach items="${goods}" var="goodInfo" varStatus="i">
                <c:set var="isRight">
                    <c:if test="${(i.index+1)%4 == 0}">
                        style="margin-right: 0"
                    </c:if>
                </c:set>
                <div class="per" ${isRight}>
                    <a target="_blank" href="product_info.html" class="img_link">
                        <img src="${pageContext.request.contextPath}/upload/${goodInfo.book_logo_small}" original="#" alt="#" class="lazy">
                    </a>
                    <div class="foot">
                        <p class="title">
                            <a target="_blank" href="product_info.html">
                                ${goodInfo.book_name}
                            </a>
                        </p>
                        <div class="statics">
                            <a class="download citecommon">浏览 <em>3次</em></a> <a class="comment citecommon">评论 <em>4条</em></a> <a class="scores citecommon">售价：<em>36.1¥</em></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


    <div class="pager">
        共<span class="red"> ${goodPage.totalSize}</span>个商品


        <!-- 首页、上一页 -->
        <a class="prev" <c:if test="${goodPage.currentPage <= 1}">href="javascript:;"</c:if>
           <c:if test="${goodPage.currentPage > 1}">href="${pageUrl}&currentPage=1"</c:if>>首页</a>
        <a class="prev" <c:if test="${goodPage.currentPage <= 1}">href="javascript:;"</c:if>
           <c:if test="${goodPage.currentPage > 1}">href="${pageUrl}&currentPage=${goodPage.currentPage-1}"</c:if>>上一页</a>


        <!-- 显示页码 -->
        <c:if test="${goodPage.totalPage <= 5}">
            <c:forEach begin="1" end="${goodPage.totalPage}" var="i">
                <a <c:if test="${goodPage.currentPage == i}">class="current"</c:if> href="${pageUrl}&currentPage=${i}">
                    ${i}
                </a>
            </c:forEach>
        </c:if>
        <c:if test="${goodPage.totalPage > 5}">
            <c:if test="${goodPage.currentPage <= 3}">
                <c:forEach begin="0" end="4" step="1" var="i">
                    <a <c:if test="${goodPage.currentPage == i+1}">class="current"</c:if> href="${pageUrl}&currentPage=${i+1}">
                            ${i+1}
                    </a>
                </c:forEach>
            </c:if>
            <c:if test="${goodPage.currentPage >3 && (goodPage.totalPage-goodPage.currentPage) <= 2 }">
                <c:forEach begin="${goodPage.totalPage-5}" end="${goodPage.totalPage-1}" var="i">
                    <a <c:if test="${goodPage.currentPage == i+1}">class="current"</c:if> href="${pageUrl}&currentPage=${i+1}">
                            ${i+1}
                    </a>
                </c:forEach>
            </c:if>
            <c:if test="${goodPage.currentPage > 3 && (goodPage.totalPage-goodPage.currentPage) > 2}">
                <c:forEach begin="${goodPage.currentPage-3}" end="${goodPage.currentPage+1}" var="i">
                    <a <c:if test="${goodPage.currentPage == i+1}">class="current"</c:if> href="${pageUrl}&currentPage=${i+1}">
                            ${i+1}
                    </a>
                </c:forEach>
            </c:if>
        </c:if>

        <!-- ...33 -->


        <!-- 末页、下一页 -->

        <a class="next" <c:if test="${goodPage.currentPage >= goodPage.totalPage}">href="javascript:;"</c:if>
           <c:if test="${goodPage.currentPage < goodPage.totalPage}">href="${pageUrl}&currentPage=${goodPage.currentPage+1}"</c:if>>
            下一页
        </a>
        <a class="next" <c:if test="${goodPage.currentPage >= goodPage.totalPage}">href="javascript:;"</c:if>
           <c:if test="${goodPage.currentPage < goodPage.totalPage}">href="${pageUrl}&currentPage=${goodPage.totalPage}"</c:if>>
            末页
        </a>
    </div>

</div>

<div class="footer" id="footer" data-url="http://www.sucaihuo.com/" data-logout="http://www.sucaihuo.com/Download/logout?r=" data-id="" data-mtype="">
    <div class="footer_main clearfix">

        <div class="friendly">
            <div class="foot_menu">
						<span class="address">
							copyright © 蓝桥网版权所有
							<br />京公网安备 11010802020352号
						</span>
            </div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/public/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/public/js/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/public/js/other/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>

</body>
</html>

