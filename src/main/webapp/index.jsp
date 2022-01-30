<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="all" name="robots" />
    <meta name="author" content="Fisher" />
    <meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
    <meta name="description" content="reefdesign" />
    <meta name="keywords" content="reefdesign" />
    <title>eshop电子书城</title>
    <link rel="shortcut icon" href="favicon.ico" />
    <link rel="stylesheet" href="public/css/style.css" type="text/css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body>

<%--顶部--%>
<%--<%@include file="/WEB-INF/views/top.jsp"%>--%>
<%--<jsp:include page="${'/type/list.action'}"></jsp:include>--%>
<c:import url="/top/topMenu" />


<div class="container">
    <div class="index_per index_first clearfix">
        <div class="sidebar_per sidebar_first">
            <dl>
                <dt>
                    <a href="product_list.jsp?/" class="more">更多&nbsp;<span class="more-sign">&gt;</span></a>
                    <strong>新书上架 <span class="name-en">/New</span></strong>
                </dt>
                <dd class="sidebar_articles">
                    <span>03-04</span>
                    <a target="_blank" href="#">尼泊尔(Lonely Planet旅行指南系列)</a>
                </dd>
                <dd class="sidebar_articles">
                    <span>02-04</span>
                    <a target="_blank" href="#">尼泊尔(Lonely Planet旅行指南系列)</a>
                </dd>
                <dd class="sidebar_articles">
                    <span>02-04</span>
                    <a target="_blank" href="#">尼泊尔(Lonely Planet旅行指南系列)</a>
                </dd>
                <dd class="sidebar_articles">
                    <span>02-03</span>
                    <a target="_blank" href="#">尼泊尔(Lonely Planet旅行指南系列)</a>
                </dd>
                <dd class="sidebar_articles">
                    <span>02-03</span>
                    <a target="_blank" href="#">尼泊尔(Lonely Planet旅行指南系列)</a>
                </dd>
                <dd class="sidebar_articles">
                    <span>02-03</span>
                    <a target="_blank" href="#">尼泊尔(Lonely Planet旅行指南系列)</a>
                </dd>
                <dd class="sidebar_articles">
                    <span>02-03</span>
                    <a target="_blank" href="#">尼泊尔(Lonely Planet旅行指南系列)</a>
                </dd>
            </dl>
        </div>
        <div class="index_left clearfix">
            <div class="banner" id="banner">
                <ul id="index_banner">
                    <li>
                        <a target="_blank" href="#">
                            <img src="ad/left_ad02.jpg">
                        </a>
                    </li>
                    <li>
                        <a target="_blank" href="#">
                            <img src="ad/left_ad03.jpg">
                        </a>
                    </li>
                    <li>
                        <a target="_blank" href="#">
                            <img src="ad/left_ad04.jpg">
                        </a>
                    </li>
                </ul>
                <div class="banner_page" id="banner_page"></div>
                <a class="banner_page_btn banner_page_left" id="banner_page_left"></a>
                <a class="banner_page_btn banner_page_right" id="banner_page_right"></a>
            </div>
            <div class='merchant_cats'>
                <div class='head'>
                    <h3>精品导航</h3></div>
                <div class="content" id="merchant_cats_menus">
                    <a href="product_list.jsp?"><i class="merchant_arrow merchant_arrow_right"></i><span class="icon_merchant icon_merchant_fire"></span><span class="name">今日热卖</span><i class="merchant_arrow_left"></i> </a>
                    <a href="product_list.jsp?/0-0-52-0-0-0"><i class="merchant_arrow merchant_arrow_right"></i><span class="icon_merchant icon_merchant_mobile"></span><span class="name">精品图书</span><i class="merchant_arrow_left"></i></a>
                    <a href="product_list.jsp?"><i class="merchant_arrow merchant_arrow_right"></i><span class="icon_merchant icon_merchant_js"></span><span class="name">本周热卖</span><i class="merchant_arrow_left"></i></a>
                    <a href="product_list.jsp?"><i class="merchant_arrow merchant_arrow_right"></i><span class="icon_merchant icon_merchant_png"></span><span class="name">最新图书</span><i class="merchant_arrow_left"></i></a>
                    <a href="product_list.jsp?"><i class="merchant_arrow merchant_arrow_right"></i><span class="icon_merchant icon_merchant_typeface"></span><span class="name">人气图书</span><i class="merchant_arrow_left"></i></a>
                    <a href="product_list.jsp?/124-0-0-0"><i class="merchant_arrow merchant_arrow_right"></i><span class="icon_merchant icon_merchant_code"></span><span class="name">收藏典范</span><i class="merchant_arrow_left"></i></a>
                </div>
            </div>
        </div>
    </div>

    <div class="sidebar_per sidebar_second">
        <dl>
            <dt>
                <a href="product_list.jsp?/0-0-6-0" class="more" target="_blank">更多&nbsp;<span class="more-sign">&gt;</span></a>
                <strong>公告板 <span class="name-en">/New</span></strong>
            </dt>
            <dd class="sidebar_articles">
                <span>01-09</span>
                <a target="_blank" href="#">图书3折起，支持在线浏览 先看再买不后悔,任何商品免费送货</a>
            </dd>
            <dd class="sidebar_articles">
                <span>01-02</span>
                <a target="_blank" href="#">50万种图书3折,百货团购价热卖 畅销榜新书速递,促销天天有</a>
            </dd>
            <dd class="sidebar_articles">
                <span>12-26</span>
                <a target="_blank" href="#">2007年中旅游图书畅销榜速递 中国游,世界游,旅游图书全部7折封顶</a>
            </dd>
            <dd class="sidebar_articles">
                <span>11-25</span>
                <a target="_blank" href="#">50万种图书3折,百货团购价热卖 畅销榜新书速递,促销天天有</a>
            </dd>
            <dd class="sidebar_articles">
                <span>11-24</span>
                <a target="_blank" href="#">Lonely Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</a>
            </dd>
            <dd class="sidebar_articles">
                <span>11-18</span>
                <a target="_blank" href="#">50万种图书3折,百货团购价热卖 畅销榜新书速递,促销天天有</a>
            </dd>
            <dd class="sidebar_articles">
                <span>11-16</span>
                <a target="_blank" href="#">图书3折起，支持在线浏览 先看再买不后悔,任何商品免费送货</a>
            </dd>
            <dd class="sidebar_articles">
                <span>01-07</span>
                <a target="_blank" href="#">Lonely Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</a>
            </dd>
            <dd class="sidebar_articles">
                <span>11-10</span>
                <a target="_blank" href="#">2007年中旅游图书畅销榜速递 中国游,世界游,旅游图书全部7折封顶</a>
            </dd>
            <dd class="sidebar_articles">
                <span>11-08</span>
                <a target="_blank" href="#">50万种图书3折,百货团购价热卖 畅销榜新书速递,促销天天有</a>
            </dd>
            <dd class="sidebar_articles">
                <span>11-02</span>
                <a target="_blank" href="#">图书3折起，支持在线浏览 先看再买不后悔,任何商品免费送货
                    <</a>
            </dd>
            <dd class="sidebar_articles">
                <span>12-29</span>
                <a target="_blank" href="#">50万种图书3折,百货团购价热卖 畅销榜新书速递,促销天天有</a>
            </dd>
            <dd class="sidebar_articles">
                <span>12-29</span>
                <a target="_blank" href="#">Lonely Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</a>
            </dd>
            <dd class="sidebar_articles">
                <span>10-27</span>
                <a target="_blank" href="#">50万种图书3折,百货团购价热卖 畅销榜新书速递,促销天天有</a>
            </dd>
        </dl>
    </div>
    <div class="index_recommend" id='index_recommend_1'>
        <div class="head clearfix">
            <strong>新书上架</strong>
            <ul class="index-coupon-menus clearfix">
                <li class="current index-coupon-menus-first">

                    <span class="arrow-up-menu arrow"></span>
                </li>
            </ul>
        </div>
        <div class="content clearfix">
            <div class="per current">
                <ul class="ul_pics">
                    <li>
                        <a target="_blank" href="product_list.jsp?/712.html">
                            <img src="ad/book1.jpg"></a>
                        <h4 class="book-title">尼泊尔(Lonely Planet旅行指南系列)</h4>
                        <span>尼泊尔王国地处巍峨的喜马拉雅山区，山地的冷气流
                            与印度平原的暖气流在此交汇。这里不仅是牦牛、雪人、
                            佛塔和夏尔巴人的国度，而且拥有世界上最好的徒步流线路。
                            </span></li>
                    <li>
                        <a target="_blank" href="product_list.jsp?/684.html">
                            <img src="ad/book2.jpg"></a>
                        <h4 class="book-title">尼泊尔(Lonely Planet旅行指南系列)</h4>
                        <span>尼泊尔王国地处巍峨的喜马拉雅山区，山地的冷气流
                            与印度平原的暖气流在此交汇。这里不仅是牦牛、雪人、
                            佛塔和夏尔巴人的国度，而且拥有世界上最好的徒步流线路。
                            </span></li>
                    <li>
                        <a target="_blank" href="product_list.jsp?/669.html">
                            <img src="ad/book3.jpg"></a>
                        <h4 class="book-title">尼泊尔(Lonely Planet旅行指南系列)</h4>
                        <span>尼泊尔王国地处巍峨的喜马拉雅山区，山地的冷气流
                            与印度平原的暖气流在此交汇。这里不仅是牦牛、雪人、
                            佛塔和夏尔巴人的国度，而且拥有世界上最好的徒步流线路。
                            </span></li>
                </ul>

            </div>
        </div>
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



<script src="public/js/jquery.js" type="text/javascript"></script>
<script src="public/js/common.js" type="text/javascript"></script>
<script src="public/js/other/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>

</body>

</html>