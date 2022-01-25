<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <title>eshop电子书城</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" />
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/public/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/public/css/theme.css">
    <script src="${pageContext.request.contextPath }/public/js/jquery.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/public/js/tooltips.js" type="text/javascript"></script>
    <%--<script src="${pageContext.request.contextPath }/public/js/common.js" type="text/javascript"></script>--%>

  </head>

  <body class=""> 
  
  <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">登录</p>
            <div class="block-body">
                <form>
                    <label>用户名/邮箱</label>
                    
		            <input type="text" class="span12" id="username" name="username" 
		              	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="用户名或邮箱不能为空" />
                    
                    <label>密码</label>
                    <input type="password" class="span12" id="pwd" name="pwd"
                    	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="密码不能为空" />
                    
                    <label>验证码</label>
                    <input type="text" class="span8" id="authCode" name="authCode"
                    	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="验证码错误" />
                    <a href="javascript:changeCode()"><img src="${pageContext.request.contextPath }/user/captcha.action" id="vCode" width="180px" height="50px"  /></a>
                    
                    <label><hr /></label>
                    <a href="javascript:sublogin()" class="btn btn-primary pull-right">登录</a>
                    <label class="remember-me"><input type="checkbox" id="rememberme">两周内免登录</label>
                    
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p><a href="#">忘记密码?</a></p>
    </div>
</div>

    <script src="${pageContext.request.contextPath}/public/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        
        function changeCode(){
    		$("#vCode").attr("src","${pageContext.request.contextPath }/user/captcha.action?uuid="+new Date().getTime());
    	}

    	$("#username").blur(function () {
            var val = $(this).val();
            if(val==""){
                $(this).attr("data-content","用户名不能为空");
                $(this).popover("show");
            }else{
                $(this).popover("destory");
            }
        })
        $("#pwd").blur(function () {
            var val = $(this).val();
            if(val==""){
                $(this).attr("data-content","密码不能为空");
                $(this).popover("show");
            }else{
                $(this).popover("destory");
            }
        })
        $("#authCode").blur(function () {
            var val = $(this).val();
            if(val==""){
                $(this).attr("data-content","验证码不能为空");
                $(this).popover("show");

            }else{
                $(this).popover("destory");
            }
        })

    	//回车事件
    	$(function(){
    		
    		$(window).keydown(function(e){
    			if(e.keyCode==13){
    				sublogin();
    			}
    		});
    		
    	});
        
    </script>
    
  </body>
</html>


