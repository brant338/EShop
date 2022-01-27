<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>eshop电子书城</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" />
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/public/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/public/css/theme.css">
    <script src="${pageContext.request.contextPath }/public/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/public/js/common.js" type="text/javascript"></script>
	
  </head>

  <body class=""> 
  
  <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">注册</p>
            <div class="block-body">
                <form>
                    <label>会员邮箱</label>
		            <input type="text" class="span12" id="email" name="email" 
		              	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="邮箱不能为空" />
            			
            		<label>用户名</label>
		            <input type="text" class="span12" id="username" name="username" 
		              	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="用户名不能为空" />
                    
                    <label>密码</label>
                    <input type="password" class="span12" id="password" name="password"
                    	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="密码不能为空" />
            		
            		<label>重复密码</label>
                    <input type="password" class="span12" id="password2" name="password2"
                    	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="重复密码不能为空" />
            			
            		<label>性别</label>
                                                  男 <input type="radio" class="span1" name="sex" value="男" checked="checked" />&nbsp;&nbsp;&nbsp;&nbsp;
                                                  女 <input type="radio" class="span1" name="sex" value="女" />
                                                  
                    <label><hr /></label>
                    
                    
                    <label>手机号码</label>
		            <input type="text" class="span12" id="phone" name="phone" 
		              	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="手机不能为空" />
            			
            		<label>收货地址</label>
		            <select name="area"  id="province" class="span5">
						<option value="">--请选择省--</option>
					</select>
					<select name="area"  id="city" class="span5">
						<option value="">--请选择市--</option>
					</select>
					<select name="area"  id="area" class="span5" style="width:230px; height:20px">
						<option value="">--请选择区/县--</option>
					</select>
					
					<label>详细地址</label>
		            <input type="text" class="span12" id="address" name="address" 
		              	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="详细地址不能为空" />
                    
                    <label><hr /></label>
                    
                    <label>密保问题</label>
		            <select name="qustion"  id="qustion" class="span12">
						<option value="">--请选择一个问题--</option>
					</select>
					
					<label>答案</label>
		            <input type="text" class="span12" id="answer" name="answer" 
		              	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="答案不能为空" />
                    
                    
                    <label>验证码</label>
                    <input type="text" class="span8" id="authCode" name="authCode"
                    	title="ⓘ提示"
            		  	data-container="body" data-toggle="popover" data-placement="right"
            			data-content="验证码错误" />
                    <a href="javascript:changeCode()"><img src="${pageContext.request.contextPath }/user/captcha.action" id="vCode" width="180px" height="50px"  /></a>
                    
                    <label><hr /></label>
                    <a href="javascript:subReg()" class="btn btn-primary pull-right">注册</a>
                    
                    
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
       
    </div>
</div>


	<script src="${pageContext.request.contextPath}/public/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        
        function changeCode(){
    		$("#vCode").attr("src","${pageContext.request.contextPath }/verifyCodeServlet?uuid="+new Date().getTime());
    	}

    	function sublogin(){
			$("#email").blur(function () {
				var val = $(this).val();
				if(val==""){
					$(this).attr("data-content","邮箱不能为空");
					$(this).popover("show");
					//isValidateUsername = false;
				}else{
					$(this).popover("destroy");
					//isValidateUsername = true;
				}
			})
			$("#username").blur(function () {
				var val = $(this).val();
				if(val==""){
					$(this).attr("data-content","用户名不能为空");
					$(this).popover("show");
					//isValidateUsername = false;
				}else{
					$(this).popover("destroy");
					//isValidateUsername = true;
				}
			})
			$("#password").blur(function () {
				var val = $(this).val();
				if(val==""){
					$(this).attr("data-content","密码不能为空");
					$(this).popover("show");
					//isValidateUsername = false;
				}else{
					$(this).popover("destroy");
					//isValidateUsername = true;
				}
			})
			$("#phone").blur(function () {
				var val = $(this).val();
				if(val==""){
					$(this).attr("data-content","手机不能为空");
					$(this).popover("show");
					//isValidateUsername = false;
				}else{
					$(this).popover("destroy");
					//isValidateUsername = true;
				}
			})
			$("#password2").blur(function () {
				var val = $(this).val();
				if(val==""){
					$(this).attr("data-content","重复密码不能为空");
					$(this).popover("show");
					//isValidateUsername = false;
				}else{
					$(this).popover("destroy");
					//isValidateUsername = true;
				}
			})
			$("#address").blur(function () {
				var val = $(this).val();
				if(val==""){
					$(this).attr("data-content","详细地址不能为空");
					$(this).popover("show");
					//isValidateUsername = false;
				}else{
					$(this).popover("destroy");
					//isValidateUsername = true;
				}
			})
			$("#answer").blur(function () {
				var val = $(this).val();
				if(val==""){
					$(this).attr("data-content","答案不能为空");
					$(this).popover("show");
					//isValidateUsername = false;
				}else{
					$(this).popover("destroy");
					//isValidateUsername = true;
				}
			})
		}


    	//回车事件
    	$(function(){
    		
    		$(window).keydown(function(e){
    			if(e.keyCode==13){
    				sublogin();
    			}
    		});
    		
    	});
		//页面加载省份
        $(window).off().on("load",function () {
        	var url = "${pageContext.request.contextPath}/address/province.action";
        	var data = {}
			$.post(url,data,function (result) {
				if(result.flag){
							var provinces = result.data

							$.each(provinces,function (index,element) {
								$("#province").append(
									$("<option value=\""+element.provinceid+"\">"+element.province+"</option>")
								)
							})
					//查询密保问题
					  url = "${pageContext.request.contextPath}/user/pwdQuestion.action"
					  data = {}
					  $.post(url,data,function (response1) {
						  if(response1.flag){
							var pwdQuestions = response1.data;
							  $.each(pwdQuestions,function (index,element) {
								  $("#qustion").append(
										  $("<option value=\""+element.question_id+"\">"+element.question_title+"</option>")
								  )
							  })
						  }else{
						  	alert("密保问题查询失败")
						  }
					  },"json")


				}else{
					alert("省份查询失败")
				}
			},"json")
		})

        $("#province").change(function () {

			$("#city").empty();
        	var provinceid = $("#province option:selected").val();
			console.log(provinceid)
			var url = "${pageContext.request.contextPath}/address/city.action";
			var data = {
				provinceid: provinceid
			}
			$.post(url,data,function (result) {
				if(result.flag){
					var citys = result.data

					$.each(citys,function (index,element) {
						$("#city").append(
								$("<option value=\""+element.cityid+"\">"+element.city+"</option>")
						)
					})

				}else{
					alert("城市查询失败")
				}
			},"json")
		})

        $("#city").change(function () {

            $("#area").empty();
            var cityid = $("#city option:selected").val();
            console.log(cityid)
            var url = "${pageContext.request.contextPath}/address/area.action";
            var data = {
               cityid: cityid
            }
            $.post(url,data,function (result) {
                if(result.flag){
                    var areas = result.data

                    $.each(areas,function (index,element) {
                        $("#area").append(
                            $("<option value=\""+element.areaid+"\">"+element.area+"</option>")
                        )
                    })

                }else{
                    alert("区查询失败")
                }
            },"json")
        })

    </script>
    
  </body>
</html>


