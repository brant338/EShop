<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/12/17
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

                <dd class="">
                    <a href="product_list.html">
                        <span>文学馆</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>生活馆</span>
                    </a>
                </dd>

                <dd class="on">
                    <a href="product_list.html">
                        <span>计算机馆</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>童书馆</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>金融馆</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>励志馆</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>艺术馆</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>科技馆</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>历史</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>心理学</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>军事</span>
                    </a>
                </dd>
            </dl>
        </div>

        <div class="tg_classify_wrap clearfix">
            <dl class="tg_classify_all tg_classify_flat dl_left">
                <dt class="">
                    <i class="icon_order"></i> 计算机馆
                </dt>
            </dl>
            <dl class="tg_classify_all tg_classify_flat clearfix dl_right">
                <dd class="on">
                    <a href="product_list.html"><span>不限</span></a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>编程语言</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>办公软件</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>数据库</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>操作系统</span>
                    </a>
                </dd>

                <dd class="">
                    <a href="product_list.html">
                        <span>人工智能</span>
                    </a>
                </dd>

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

        <div id="order-page" class="order-page">


				<span class="find_results_num">
					共<span class="red"> 11</span>
					商品
				</span>
            <span class="page-small">
						<a class="prev-btn page-btn" href="#">
							<span class="arrow-left arrow arrow-left-none"></span>
						</a>
						<span class="orange">1</span>/2
						<a class="pnext-btn page-btn" href="productlist.action?typeId=3&amp;childTypeId=&amp;typeName=计算机馆&amp;currentpage=2">
							<span class="arrow-right arrow"></span>
						</a>
				</span>
        </div>

    </div>

    <div class="list">
        <div class="list_main clearfix">



            <div class="per">
                <a target="_blank" href="product_info.html" class="img_link">
                    <img src="${pageContext.request.contextPath}/upload/150902505493857c3d0e2N8d0102bc.jpg" original="#" alt="#" class="lazy">
                </a>
                <div class="foot">
                    <p class="title">
                        <a target="_blank" href="product_info.html">
                            协和专家+协和妈妈圈干货分享（分娩）
                        </a>
                    </p>
                    <div class="statics">
                        <a class="download citecommon">浏览 <em>3次</em></a> <a class="comment citecommon">评论 <em>4条</em></a> <a class="scores citecommon">售价：<em>25.3¥</em></a>
                    </div>
                </div>
            </div>



            <div class="per">
                <a target="_blank" href="product_info.html" class="img_link">
                    <img src="${pageContext.request.contextPath}/upload/150950900808803-1.jpg" original="#" alt="#" class="lazy">
                </a>
                <div class="foot">
                    <p class="title">
                        <a target="_blank" href="product_info.html">
                            好孩子不是管出来的2：自由的孩子更自觉
                        </a>
                    </p>
                    <div class="statics">
                        <a class="download citecommon">浏览 <em>3次</em></a> <a class="comment citecommon">评论 <em>4条</em></a> <a class="scores citecommon">售价：<em>16.8¥</em></a>
                    </div>
                </div>
            </div>



            <div class="per">
                <a target="_blank" href="product_info.html" class="img_link">
                    <img src="${pageContext.request.contextPath}/upload/150950913184604-1.jpg" original="#" alt="#" class="lazy">
                </a>
                <div class="foot">
                    <p class="title">
                        <a target="_blank" href="product_info.html">
                            正面管教
                        </a>
                    </p>
                    <div class="statics">
                        <a class="download citecommon">浏览 <em>3次</em></a> <a class="comment citecommon">评论 <em>4条</em></a> <a class="scores citecommon">售价：<em>36.1¥</em></a>
                    </div>
                </div>
            </div>

            <div class="per" style="margin-right: 0">
                <a target="_blank" href="product_info.html" class="img_link">
                    <img src="${pageContext.request.contextPath}/upload/150950913184604-1.jpg" original="#" alt="#" class="lazy">
                </a>
                <div class="foot">
                    <p class="title">
                        <a target="_blank" href="product_info.html">
                            正面管教
                        </a>
                    </p>
                    <div class="statics">
                        <a class="download citecommon">浏览 <em>3次</em></a> <a class="comment citecommon">评论 <em>4条</em></a> <a class="scores citecommon">售价：<em>36.1¥</em></a>
                    </div>
                </div>
            </div>

            <div class="per">
                <a target="_blank" href="product_info.html" class="img_link">
                    <img src="${pageContext.request.contextPath}/upload/150950913184604-1.jpg" original="#" alt="#" class="lazy">
                </a>
                <div class="foot">
                    <p class="title">
                        <a target="_blank" href="product_info.html">
                            正面管教
                        </a>
                    </p>
                    <div class="statics">
                        <a class="download citecommon">浏览 <em>3次</em></a> <a class="comment citecommon">评论 <em>4条</em></a> <a class="scores citecommon">售价：<em>36.1¥</em></a>
                    </div>
                </div>
            </div>

        </div>
    </div>


    <div class="pager">
        共<span class="red"> 25 </span>个商品

        <!-- 首页、上一页 -->
        <a class="prev">首页</a>
        <a class="prev">上一页</a>


        <!-- 显示页码 -->
        <a class="current" href="productlist.action?typeId=1&amp;childTypeId=&amp;typeName=文学馆&amp;currentpage=1">
            1
        </a>
        <a class="num" href="productlist.action?typeId=1&amp;childTypeId=&amp;typeName=文学馆&amp;currentpage=2">
            2
        </a>
        <a class="num" href="productlist.action?typeId=1&amp;childTypeId=&amp;typeName=文学馆&amp;currentpage=3">
            3
        </a>
        <a class="num" href="productlist.action?typeId=1&amp;childTypeId=&amp;typeName=文学馆&amp;currentpage=4">
            4
        </a>

        <!-- ...33 -->


        <!-- 末页、下一页 -->

        <a class="next" href="productlist.action?typeId=1&amp;childTypeId=&amp;typeName=文学馆&amp;currentpage=2">
            下一页
        </a>
        <a class="next" href="productlist.action?typeId=1&amp;childTypeId=&amp;typeName=文学馆&amp;currentpage=4">
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


<script src="public/js/jquery.js" type="text/javascript"></script>
<script src="public/js/common.js" type="text/javascript"></script>
<script src="public/js/other/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>

</body>
</html>

