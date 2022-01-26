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
                    <a href="javascript:;" class="btn btn-primary pull-right" id="submit">登录</a>
                    <label class="remember-me"><input type="checkbox" id="rememberme">两周内免登录</label>
                    
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p><a href="#">忘记密码?</a></p>
    </div>
</div>
    <script src="${pageContext.request.contextPath }/public/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/public/js/tooltips.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/public/js/bootstrap.js" type="text/javascript"></script>
    <%--<script src="${pageContext.request.contextPath }/public/js/common.js" type="text/javascript"></script>--%>

    <script type="text/javascript">
        /*$("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });*/
        
        function changeCode(){
    		$("#vCode").attr("src","${pageContext.request.contextPath }/user/captcha.action?uuid="+new Date().getTime());
    	}

    	$("#username").blur(function () {
            var val = $(this).val();
            if(val==""){
                $(this).attr("data-content","用户名不能为空");
                $(this).popover("show");
            }else{
                $(this).popover("destroy");
            }
        })
        $("#pwd").blur(function () {
            var val = $(this).val();
            if(val==""){
                $(this).attr("data-content","密码不能为空");
                $(this).popover("show");
            }else{
                $(this).popover("destroy");
            }
        })
        $("#authCode").blur(function () {
            var val = $(this).val();
            if(val==""){
                $(this).attr("data-content","验证码不能为空");
                $(this).popover("show");


            }else{
                $(this).popover("destroy")
                   $("#submit").click(function(){

                       var url = "${pageContext.request.contextPath}/user/check_captcha.action";
                       var username = $("#username").val();
                       var pwd = $("#pwd").val();
                       val = $("#authCode").val();

                       var data = {
                           username: username,
                           pwd: pwd,
                           authCode: val
                       };
                       //验证码
                       $.post(url,data,function (response) {

                           console.log(response);
                           if(response.flag){
                               url = "${pageContext.request.contextPath}/user/login.action";
                               //验证用户名和密码
                               $.post(url,data,function (response1) {
                                   if(response1.flag){
                                       console.log(response1)
                                       var loginUrl = response1.data.notify_url

                                       //登录成功
                                       location.href = loginUrl;

                                   }else{

                                       alert(response1.data)
                                       //验证码更新
                                       changeCode()

                                   }
                               },"json")
                           }else{
                               alert(response.data)
                               //验证码更新
                               changeCode()
                           }
                       },"json")
                    });
            }
        })
    </script>
    
  </body>
</html>


