<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <title>eshop电子书城</title>
        <meta name="keywords" content="" /> 
        <meta name="description" content="" /> 
        <link rel="shortcut icon" href="favicon.ico" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css" type="text/css" />
        <link href="${pageContext.request.contextPath}/public/css/member.css" rel="stylesheet" type="text/css" />
    </head> 
    <body> 
        
<c:import url="/top?goodDetailMenu=1" />
		
<div class="container clearfix">
    
    <div class="member_right">
		<div class="member_per">
			<div class="panel clearfix">
				<div class="panel-info clearfix">
					<img class="round-image" width="50" height="50" src="${pageContext.request.contextPath}/public/css/images/temp.png" alt="头像">
					<div class="name-job">
						<h4 class="myname"> yock </h4>
						<p class="job-title"> dengyukun@126.com </p>
					</div>
				</div>
			</div>
		</div>
		<div class="member_per">
			<ul class="nav panel">
				<li>
					<a href="member_set.jsp"><i class="icon-nav icon-note"></i>我的设置</a>
				</li>
				<li>
					<a href="orderlist.jsp"><i class="icon-nav icon-tick"></i>我的订单</a>
				</li> 
				<li>
					<a href="commentlist.jsp"><i class="icon-nav icon-plan"></i>我的评价</a>
				</li>
			   <li style='border-bottom: none'>
					<a href="favoritelist.jsp"><i class="icon-nav icon-ques"></i>我的收藏</a>
			   </li>
			</ul>
		</div>
		<div class="member_per">
			<ul class="space-data panel">
				<li>
					<span class="icon-clock icon" title="购买"></span>
					购买：
					<a href="#">53件商品</a>
				</li>
				<li>
					<span class="icon-tick icon" title="收藏"></span>
					收藏：
					<a  href="#">3件商品</a>
				</li>
				<li>
					<span class="icon-tick icon" title="购物车"></span>
					购物车：
					<a class="countNote" href="#">15件商品</a>
				</li>

			</ul>
		</div>
	</div>
    
    <div class="member_main">
        <div class="perInfo">
            <div class="titleInfoBorder">
                <span>我的设置</span>
            </div>
            <div class="firstTabBox lineSpace">
    <a class="tab currentTab" href="member_set.html">个人资料</a>
    <span class="line">|</span>
    <a class="tab " href="member_avatar.html">安全设置</a>
    <span class="line">|</span>
    <a class="tab " href="member_pwd.html">修改密码</a>
</div>
        </div>
        <div class="setting-right-wrap wrap-boxes settings">
            <div id="setting-profile" class="setting-wrap setting-profile">
            	<div class="wlfg-wrap">
                    <label class="label-name" >头像</label>
                    <input type="file" class="rlf-select" />
                    <!--  
                    <input id="nickname" class="rlf-input rlf-input-nick" type="text" placeholder="请输入昵称" value="" data-validate="nick" autocomplete="off" name="nickname" />
                    -->
                </div>
                <div class="wlfg-wrap">
                    <label class="label">性别</label>
                    <label>
                        <input type="radio" name="sex" value="1" hidefocus="true" autocomplete="off" checked="checked"/>男
                    </label>
                    <label>
                        <input type="radio" name="sex" value="2" hidefocus="true" autocomplete="off" />女
                    </label>
                </div>
                <div class="wlfg-wrap">
                    <label class="label-name" >手机号码</label>
                    <input type="text"  class="rlf-input" placeholder="请输入手机号码" />
                </div>
                 <div class="wlfg-wrap">
                    <label class="label-name" >密保问题</label>
                    <select id="question" class="rlf-select">
                    	<option value="">请选择问题</option>
                    </select>
                </div>
                <div class="wlfg-wrap">
                    <label class="label-name" >密保答案</label>
                    <input type="text" id="phone" class="rlf-input" placeholder="请输入密保答案" />
                </div>
                <div class="wlfg-wrap">
                    <label class="label-name" >收货地址</label>
                    <span id="city_area">
                        <select class="prov" id="province">
                        	<option value="">请选择省份</option>
                        </select> 
                        <select class="city" id="city">
                        	<option value="">请选择市</option>
                        </select>
                        <select class="dist" id="area">
                        	<option value="">请选择区/县</option>
                        </select>
                    </span>
                </div>
                <div class="wlfg-wrap">
                    <label class="label-name label_signature" >详细地址</label>
                    <textarea  class="textarea textarea_signature" rows="5" cols="30" id='signature'>龙华新区汇海大厦B1205</textarea>
                </div>
                <div class="wlfg-wrap">
                    <label class="label-name"></label>
                    <button class="btn" type="button" id='btn_submit'>保存</button>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="footer" id="footer" data-url="http://www.sucaihuo.com/" data-logout="http://www.sucaihuo.com/Download/logout?r=" data-id="" data-mtype="">
			<div class="footer_main clearfix">
				
				<div class="friendly">
					<div class="foot_menu">
						<span class="address">
							copyright ? 2013-2018 河南云和数据信息技术有限公司深圳分公司  - Collect from 
							<a href="http://www.iyunhe.com/" title="云和数据" target="_blank">云和数据</a>
							<br />粤ICP备16098514号
						</span>
					</div>
				</div>
			</div>
	</div>

<script src="${pageContext.request.contextPath}/public/js/other/jquery_highlight.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/public/js/member.js" type="text/javascript"></script>
<div class="mmsg-box mmsg-box-info" id='msg-box' style="margin-top: -23.5px; margin-left: -96.5px;">
    <div class="mmsg-content">
        <i class="mmsg-icon"></i>
        <p id='msg-box-content'></p>
    </div>
    <div class="mmsg-background"></div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/other/jquery.cityselect.js"></script>
<script type="text/javascript">
    $(function() {
        $("#city_area").citySelect({
            prov: "北京",
            city: "东城区",
            dist: "null",
            nodata: "none",
            url: "${pageContext.request.contextPath}/public/js/other/city.min.js"
        });
        $("#btn_submit").click(function() {
            var nickname = $("#nickname").val();
            var job = $("#job").val();
            var sex = $("input[name=sex]:checked").val();
            var signature = $("#signature").val();
            var area = '';
            $("#city_area").children("select").each(function() {
                area += $(this).val() + ",";
            })
            checkBefore('#btn_submit');
            $.post(getUrl("Ajax/updateInfo"), {nickname: nickname, job: job, area: area, sex: sex, signature: signature}, function(data) {
                $("#signed_textarea").val(signature);
                $(".job-title").html(job);
                $(".myname").html(nickname);
                checkAfter('#btn_submit');
                showSuccessTip('资料修改成功！');
            }, "json")
        })
    })

</script>
</body>
</html>