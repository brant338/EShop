<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>eshop电子书城</title>
    <link rel="shortcut icon" href="favicon.ico" />
	
    <link href="${pageContext.request.contextPath}/public/css/member.css" rel="stylesheet" type="text/css" />
    <style>
        body,ul,li,ol,h2,img{
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
        }
        ul,ol{
            list-style: none;
        }
        :focus{
            outline: none;
        }
        a{
            text-decoration: none;
            color: inherit;
        }
        .clearfix::after{
            content: "";
            display: block;
            height: 0;
            visibility: hidden;
            clear: both;
        }
        body{
        	background-color: white !important;
        }
        .goods-infor{
            margin: 0 auto;
            width: 1000px;
        }
        .goods-img{
            float: left;
        }
        .goods-infor .big-img{
            width: 420px;
            height: 420px;
            border: 1px solid #ccc;
        }
        .goods-infor .small-img{
            width: 420px;
            text-align: center;
            margin-top: 10px;
        }
        .goods-infor .small-img img{
            border: 2px solid transparent;
            cursor: pointer;
        }
        .goods-infor .small-img .img-active{
            border: 2px solid black;
        }
        .goods-para{
            float: left;
            margin-left: 20px;
        }
        .goods-para .goods-title{
            width: 520px;
            box-sizing: border-box;
            padding: 0 4px;
            line-height: 20px;
            margin-top: 5px;
            margin-bottom: 10px;
        }
        .goods-para .goods-price{
            width: 520px;
            height: 198px;
            background: url("price-bg.png") no-repeat;
        }
        .goods-para .goods-price tr td:first-child{
            color: #999;
            font-size: 14px;
        }
        .goods-para .goods-price tr{
            height: 30px;
        }
        .goods-para .buy{
            height: 30px;
            line-height: 30px;
            color: #999;
            text-align: center;
            font-size: 14px;
            margin-top: 20px;
            margin-left: 20px;
        }
        .goods-para .buy li{
            float: left;
        }
        .goods-para .buy .count{
            float: left;
            width: 36px;
            height: 26px;
            padding: 3px 2px 0 3px;
            border: 1px solid #ccc;
        }
        .goods-para .buy .arrow{
            height: 30px;
            float: left;
        }
        .goods-para .buy .arrow .up,.goods-para .buy .arrow .down{
            width: 12px;
            height: 16px;
            overflow: hidden;
            border: 1px solid #ccc;
            display: block;
            line-height: 12px;
            font-size: 16px;
            cursor: pointer;
            margin-left: 6px;
            margin-top: -2px;
            transform: rotate(-90deg);
        }
        .goods-para .buy-count li:nth-child(2){
            margin: 0 32px;
        }
        .goods-para .buy-control{
            margin: 20px auto;
            font-size: 16px;
        }
        .goods-para .buy-control a{
            float: left;
            overflow: hidden;
            width: 178px;
            height: 38px;
            line-height: 38px;
            background-color: #ffeded;
            border: 1px solid #FF0036;
            color: #FF0036;
        }
        .goods-para .buy-control .buy-now{
            margin: 0 10px 0 60px;
        }
        .goods-para .buy-control .buy-add{
            background-color: #ff0036;
            border: 1px solid #ff0036;
            color: #fff;
        }
        .goods-details{
            width: 1000px;
            margin: 20px auto;
            border-top: 1px solid #ccc;
            border-bottom: 1px solid #ccc;
        }
        .goods-details .detail-title{
            box-sizing: border-box;
            width: 1000px;
            position: relative;
            top:0;
            height: 53px ;
            text-align: center;
            background-color: white;
            border-bottom: 1px solid #ccc;
            border-right: 1px solid #ccc;
            border-left: 1px solid #ccc;
        }
        .goods-details .detail-title li{
            padding: 0 30px;
            line-height: 50px;
            float: left;
            height: 50px;
            cursor: pointer;
            border: 1px solid transparent;
            border-top-width: 2px;
        }
        .goods-details .detail-title .title-active{
            border-left: 1px solid #ccc;
            border-right: 1px solid #ccc;
            border-top: 2px solid #ff0036;
            position: relative;
        }
        .goods-details .detail-title .title-active:before{
            content: "";
            width: 0;
            height: 0;
            position: absolute;
            left: 50%;
            top: 0;
            margin-left: -6px;
            border-top: 6px solid #ff0036;
            border-left: 6px solid transparent;
            border-right: 6px solid transparent;
        }
        .goods-details .detail-content{
            border-right: 1px solid #ccc;
            border-left: 1px solid #ccc;
        }
        .goods-details .detail-content .content-item{
            display: none;
            padding: 20px;
        }
    </style>

</head>
<body>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css" type="text/css" />

    <c:import url="/top/topMenu?goodDetailMenu=1" />

    <div class="goods-infor clearfix">
        <div class="goods-img">
            <div class="big-img">
                <img src="${pageContext.request.contextPath}/upload/${goodDetail.book_logo_big}"
                	width="420" height="420">
            </div>
            <div class="small-img">

            		<img src="${pageContext.request.contextPath}/upload/${goodDetail.book_logo_small}" alt="" width="60" height="60" class="img-active">
                    <c:forEach items="${goodPics}" var="goodPic">
                        <img src="${pageContext.request.contextPath}/upload/${goodPic.pic_name}" alt="" width="60" height="60" class="img-active">
                    </c:forEach>
            	
            </div>
        </div>
        <div class="goods-para">
            <h2 class="goods-title">${goodDetail.book_name}</h2>
            <div class="goods-price">
                <table width="520" cellspacing="10">
                    <tr>
                        <td width="70">作者</td>
                        <td>${goodDetail.book_author}</td>
                    </tr>
                    <tr>
                        <td>价格</td>
                        <td style="text-decoration: line-through;">${goodDetail.book_price_old}</td>
                    </tr>
                    <tr>
                        <td>促销价</td>
                        <td style="color: red; font-size: 30px; font-weight: bold;">${goodDetail.book_price}</td>
                    </tr>
                    <tr>
                        <td>出版社</td>
                        <td>${goodDetail.book_press}</td>
                    </tr>
                </table>
            </div>
            <div class="buy">
                <ul class="buy-count clearfix">
                    <li>数量</li>
                    <li>
                        <input class="count" value="1">
                        <div class="arrow clearfix">
                            <span class="up">ww</span>
                            <span class="down">&lt;</span>
                        </div>

                    </li>
                    <li>库存<span class="total"> ${goodDetail.store_count} </span>件</li>
                </ul>
                <div class="buy-control clearfix">
                    <a class="buy-now" href="#">立即购买</a>
                    <a class="buy-add" href="#">加入购物车</a>
                </div>
            </div>
        </div>
    </div>
    <div class="goods-details">
        <ul class="detail-title">
            <li class="title-active">商品详情</li>
            <li>累积评论 <span>2056</span></li>
        </ul>
        <ol class="detail-content">
        	<!-- 商品详情 -->
            <li style="display: block;" class="content-item">

                ${goodDetail.book_description}
            	
            </li>
            
            <!-- 评论列表 -->
            <li class="content-item">
            	<!-- 评论1 -->
            	<div class="infoPerBlock infoCommentBlock ">
					<div class="leftPicBlock">
                        <a href="member_index.html">
                            <img src="ad/book1.jpg" width="80px" height="80px" title="头像" alt="头像" />
                        </a>
                    </div>
                    <div class="centerBlock">
                        <span class="title">
                        	<a class="blue" target="_blank" href="http://www.sucaihuo.com/space/uid/1528">sunhine</a>
                        	评论说：
                    	</span>
                        <div class="infoNews">
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        </div>
                        <div class="objectBlock">
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                        </div>
                    </div>
                    <div class="rightBlock">
                        <span class="time">01-21 08:24</span>
                    </div>
                    <div class="clear"></div>
                </div>
                
                <!-- 评论1 -->
            	<div class="infoPerBlock infoCommentBlock ">
					<div class="leftPicBlock">
                        <a href="member_index.html">
                            <img src="ad/book1.jpg" width="80px" height="80px" title="头像" alt="头像" />
                        </a>
                    </div>
                    <div class="centerBlock">
                        <span class="title">
                        	<a class="blue" target="_blank" href="http://www.sucaihuo.com/space/uid/1528">sunhine</a>
                        	评论说：
                    	</span>
                        <div class="infoNews">
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        </div>
                        <div class="objectBlock">
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                        </div>
                    </div>
                    <div class="rightBlock">
                        <span class="time">01-21 08:24</span>
                    </div>
                    <div class="clear"></div>
                </div>
                
                <!-- 评论1 -->
            	<div class="infoPerBlock infoCommentBlock ">
					<div class="leftPicBlock">
                        <a href="member_index.html">
                            <img src="ad/book1.jpg" width="80px" height="80px" title="头像" alt="头像" />
                        </a>
                    </div>
                    <div class="centerBlock">
                        <span class="title">
                        	<a class="blue" target="_blank" href="http://www.sucaihuo.com/space/uid/1528">sunhine</a>
                        	评论说：
                    	</span>
                        <div class="infoNews">
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        </div>
                        <div class="objectBlock">
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                        </div>
                    </div>
                    <div class="rightBlock">
                        <span class="time">01-21 08:24</span>
                    </div>
                    <div class="clear"></div>
                </div>
            	
				<!-- 评论1 -->
            	<div class="infoPerBlock infoCommentBlock ">
					<div class="leftPicBlock">
                        <a href="member_index.html">
                            <img src="ad/book1.jpg" width="80px" height="80px" title="头像" alt="头像" />
                        </a>
                    </div>
                    <div class="centerBlock">
                        <span class="title">
                        	<a class="blue" target="_blank" href="http://www.sucaihuo.com/space/uid/1528">sunhine</a>
                        	评论说：
                    	</span>
                        <div class="infoNews">
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        </div>
                        <div class="objectBlock">
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                        </div>
                    </div>
                    <div class="rightBlock">
                        <span class="time">01-21 08:24</span>
                    </div>
                    <div class="clear"></div>
                </div>
				
				<!-- 评论1 -->
            	<div class="infoPerBlock infoCommentBlock ">
					<div class="leftPicBlock">
                        <a href="member_index.html">
                            <img src="ad/book1.jpg" width="80px" height="80px" title="头像" alt="头像" />
                        </a>
                    </div>
                    <div class="centerBlock">
                        <span class="title">
                        	<a class="blue" target="_blank" href="http://www.sucaihuo.com/space/uid/1528">sunhine</a>
                        	评论说：
                    	</span>
                        <div class="infoNews">
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        </div>
                        <div class="objectBlock">
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                        </div>
                    </div>
                    <div class="rightBlock">
                        <span class="time">01-21 08:24</span>
                    </div>
                    <div class="clear"></div>
                </div>
				
				<!-- 评论1 -->
            	<div class="infoPerBlock infoCommentBlock ">
					<div class="leftPicBlock">
                        <a href="member_index.html">
                            <img src="ad/book1.jpg" width="80px" height="80px" title="头像" alt="头像" />
                        </a>
                    </div>
                    <div class="centerBlock">
                        <span class="title">
                        	<a class="blue" target="_blank" href="http://www.sucaihuo.com/space/uid/1528">sunhine</a>
                        	评论说：
                    	</span>
                        <div class="infoNews">
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        	你应该说的是弹窗iframe.本文演示的是弹出层（div）,没有浏览器会禁止弹出层的。
                        </div>
                        <div class="objectBlock">
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                            &nbsp;&nbsp;
                            <span class="pic">
                                <a target="_blank" href="js.html?/567">
                                    <img width="50px" height="50px" style="margin-top:0px" alt="jQuery+Ajax" src="${pageContext.request.contextPath}/public/css/images/nba.png">
                                </a>
                            </span>
                        </div>
                    </div>
                    <div class="rightBlock">
                        <span class="time">01-21 08:24</span>
                    </div>
                    <div class="clear"></div>
                </div>
            	
            </li>
            
        </ol>
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
	
    <script>
        $(function(){
            $(".goods-infor .small-img").on("mouseover", "img", function(){
                $(this).addClass("img-active").siblings().removeClass("img-active");
                $(".goods-infor .big-img img").attr("src", $(this).attr("src"));
            });
            var $count = $(".goods-para .count");
            $(".goods-para .arrow .up").on("click", function(){
                $count.val(parseInt($count.val()) + 1);
            });
            $(".goods-para .arrow .down").on("click", function(){
                if($count.val() <= 1){
                    $count.val(1);
                }else{
                    $count.val(parseInt($count.val()) - 1);
                }
            });
            $count.on("input", function(){
                var $val = parseInt($(this).val());
                setTimeout(function(){
                    if(isNaN($val) || $val < 1){
                        $count.val(1);
                    }else{
                        this.val($val);
                    }
                }.bind($(this)),30);
            });
            $(".detail-title").on("click", "li", function(){
                $(this).addClass("title-active").siblings().removeClass("title-active");
                $(".detail-content li").eq($(this).index()).show().siblings().hide();
            });
        });
    </script>
</body>
</html>