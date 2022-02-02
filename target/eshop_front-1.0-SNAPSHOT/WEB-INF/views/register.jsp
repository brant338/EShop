<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>eshop电子书城</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico"/>
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

<div class="row-fluid" id="app">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">注册</p>
            <div class="block-body">
                <form>
                    <label>会员邮箱</label>
                    <input type="text" class="span12" id="email" name="email" v-model="user.user_email"
                           title="ⓘ提示"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="邮箱不能为空"/>

                    <label>用户名</label>
                    <input type="text" class="span12" id="username" name="username" v-model="user.user_name"
                           title="ⓘ提示"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="用户名不能为空"/>

                    <label>密码</label>
                    <input type="password" class="span12" id="password" name="password" v-model="user.user_pwd"
                           title="ⓘ提示"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="密码不能为空"/>

                    <label>重复密码</label>
                    <input type="password" class="span12" id="password2" name="password2" v-model="user.password2"
                           title="ⓘ提示"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="重复密码不能为空"/>

                    <label>性别</label>
                    男 <input type="radio" class="span1" name="sex" value="男" checked="checked" v-model="user.user_sex"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    女 <input type="radio" class="span1" name="sex" value="女" v-model="user.user_sex"/>

                    <label>
                        <hr/>
                    </label>

                    <label>手机号码</label>
                    <input type="text" class="span12" id="phone" name="phone" v-model="user.user_phone"
                           title="ⓘ提示"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="手机不能为空"/>

                    <label>收货地址</label>
                    <select name="area" id="province" class="span5" v-model="user.province_id" @change="initCity()" >
                        <option value="">--请选择省--</option>
                        <option :value="province.provinceid" v-for="(province,index) in provinces">{{province.province}}</option>
                    </select>
                    <select name="area" id="city" class="span5" v-model="user.city_id" @change="initArea()" autocomplete="off">
                        <option value="" selected = "selected">--请选择市--</option>
                        <option :value="city.cityid" v-for="(city,index) in citys">{{city.city}}</option>
                    </select>
                    <select name="area" id="area" class="span5" style="width:230px; height:20px" v-model="user.area_id">
                        <option value="" selected = "selected">--请选择区/县--</option>
                        <option :value="area.areaid" v-for="(area,index) in areas">{{area.area}}</option>
                    </select>

                    <label>详细地址</label>
                    <input type="text" class="span12" id="address" name="address" v-model="user.user_address"
                           title="ⓘ提示"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="详细地址不能为空"/>

                    <label>
                        <hr/>
                    </label>

                    <label>密保问题</label>
                    <select name="qustion" id="qustion" class="span12" v-model="user.question_id">
                        <option value="">--请选择一个问题--</option>
                        <option :value="pwdQuestion.question_id" v-for="(pwdQuestion,index) in pwdQuestions">{{pwdQuestion.question_title}}</option>
                    </select>

                    <label>答案</label>
                    <input type="text" class="span12" id="answer" name="answer" v-model="user.question_answer"
                           title="ⓘ提示"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="答案不能为空"/>


                    <label>验证码</label>
                    <input type="text" class="span8" id="authCode" name="authCode" v-model="authCode"
                           title="ⓘ提示"
                           data-container="body" data-toggle="popover" data-placement="right"
                           data-content="验证码错误"/>
                    <a href="javascript:changeCode()"><img src="${pageContext.request.contextPath }/user/captcha"
                                                           id="vCode" width="180px" height="50px"/></a>

                    <label>
                        <hr/>
                    </label>
                    <a href="javascript:;" class="btn btn-primary pull-right" @click="registerNew()">注册</a>


                    <div class="clearfix"></div>
                </form>
            </div>
        </div>

    </div>
</div>


<script src="${pageContext.request.contextPath}/public/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/public/js/vue.js"></script>
<script src="${pageContext.request.contextPath}/public/js/axios-0.18.0.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function () {
        $('.demo-cancel-click').click(function () {
            return false;
        });
    });

    function changeCode() {
        $("#vCode").attr("src", "${pageContext.request.contextPath }/register/captcha?uuid=" + new Date().getTime());
    }

    var isValidateUserEmail = false;
    var isValidateUsername = false;
    var isValidatePassword = false;
    var isValidatePhone = false;
    var isValidatePassword2 = false;
    var isValidateAddress = false;
    var isValidateAnswer = false;
    var isValidateAuthCode = false;

    var vue = new Vue({
        el: '#app',
        data: {
            user: {
                user_email: "",
                user_name: "",
                user_pwd: "",
                user_head: "1.jpg",
                user_phone: "",
                user_sex: "",
                password2: "",
                province_id: "",
                city_id: "",
                area_id: "",
                user_address: "",
                question_id: "",
                question_answer: "",
                is_activated: "",
                is_online: "",
                time: ""
            },
            authCode: "",
            provinces: [],
            citys: [],
            areas: [],
            pwdQuestions: []
        },
        created() {
            this.initProvince();
            this.initPwdQuestion();
        },
        methods: {
            registerNew() {


                $("#email").blur(function () {
                    var user_email = $(this).val();
                    if (user_email == "") {
                        $(this).attr("data-content", "邮箱不能为空");
                        $(this).popover("show");
                        isValidateUserEmail = false;
                    } else {
                        $(this).popover("destroy");
                        isValidateUserEmail = true;
                    }
                })
                $("#username").blur(function () {
                    var user_name = $(this).val();
                    if (user_name == "") {
                        $(this).attr("data-content", "用户名不能为空");
                        $(this).popover("show");
                        isValidateUsername = false;
                    } else {
                        $(this).popover("destroy");
                        isValidateUsername = true;
                    }
                })
                $("#password").blur(function () {
                    var user_pwd = $(this).val();
                    if (user_pwd == "") {
                        $(this).attr("data-content", "密码不能为空");
                        $(this).popover("show");
                        isValidatePassword = false;
                    } else {
                        $(this).popover("destroy");
                        isValidatePassword = true;
                    }
                })
                $("#phone").blur(function () {
                    var phone = $(this).val();
                    if (phone == "") {
                        $(this).attr("data-content", "手机不能为空");
                        $(this).popover("show");
                        isValidatePhone = false;
                    } else {
                        $(this).popover("destroy");
                        isValidatePhone = true;
                    }
                })
                $("#password2").blur(function () {
                    var password2 = $(this).val();
                    if (password2 == "") {
                        $(this).attr("data-content", "重复密码不能为空");
                        $(this).popover("show");
                        isValidatePassword2 = false;
                    } else {
                        $(this).popover("destroy");
                        isValidatePassword2 = true;
                        if (password2 !== $("#password").val()) {
                            $(this).attr("data-content", "重复密码与设置密码必须一样");
                            $(this).popover("show");
                            isValidatePassword2 = false;
                        } else {
                            $(this).popover("destroy");
                            isValidatePassword2 = true;
                        }
                    }
                })
                $("#address").blur(function () {
                    var user_address = $(this).val();
                    if (user_address == "") {
                        $(this).attr("data-content", "详细地址不能为空");
                        $(this).popover("show");
                        isValidateAddress = false;
                    } else {
                        $(this).popover("destroy");
                        isValidateAddress = true;
                    }
                })
                $("#answer").blur(function () {
                    var question_answer = $(this).val();
                    if (question_answer == "") {
                        $(this).attr("data-content", "答案不能为空");
                        $(this).popover("show");
                        isValidateAnswer = false;
                    } else {
                        $(this).popover("destroy");
                        isValidateAnswer = true;
                    }
                })
                $("#authCode").blur(function () {
                    var authCode1 = $(this).val();
                    if (authCode1 == "") {
                        $(this).attr("data-content", "验证码不能为空");
                        $(this).popover("show");
                        isValidateAuthCode = false;
                    } else {
                        $(this).popover("destroy");
                        isValidateAuthCode = true;
                    }
                })
                if (isValidateUserEmail && isValidateUsername && isValidatePassword && isValidatePhone
                    && isValidatePassword2 && isValidateAddress && isValidateAnswer && isValidateAuthCode) {
                    var url = "${pageContext.request.contextPath}/register/check_captcha";
                    var data = {
                        authCode: this.authCode
                    }
                    var url1 = "${pageContext.request.contextPath}/register/newRegister";
                    var userInfo = this.user
                    //验证码
                    $.post(url, data, function (response1) {
                        if (response1.flag) {
                            axios.post(url1, userInfo).then(
                                response => {
                                    if (response.data.flag) {
                                        alert("注册成功,请前往邮箱验证")
                                    } else {
                                        alert("注册失败")
                                    }
                                    console.log(response.data)
                                }
                            )
                        } else {
                            alert("验证码错误")
                            changeCode()
                        }
                    }, "json")
                }
            },
            initProvince() {
                //页面加载省份
                var url = "${pageContext.request.contextPath}/address/province";
                axios.get(url).then(
                    response => {
                        if (response.data.flag) {
                            this.provinces = response.data.data

                        } else {
                            alert("省份查询失败")
                        }
                    }
                )
            },
            initCity(){
                //页面加载城市
                var url = "${pageContext.request.contextPath}/address/city";
                var data = {
                    provinceid: this.user.province_id
                }
                axios.post(url,data).then(
                    response => {
                        if (response.data.flag) {
                            this.citys = response.data.data
                        } else {
                            alert("城市查询失败")
                        }
                    }
                )
            },
            initArea(){
                //页面加载地区
                var url = "${pageContext.request.contextPath}/address/area";
                var data = {
                    cityid: this.user.city_id
                }
                axios.post(url,data).then(
                    response => {
                        if (response.data.flag) {
                            this.areas = response.data.data
                        } else {
                            alert("地区查询失败")
                        }
                    }
                )
            },
            initPwdQuestion(){
                url = "${pageContext.request.contextPath}/register/pwdQuestion"
                //加载密保问题
                axios.get(url).then(
                    response => {
                        if (response.data.flag) {
                            this.pwdQuestions = response.data.data
                        } else {
                            alert("密保问题查询失败")
                        }
                    }
                )
            }
        },
        mounted() {
            this.registerNew();
        }
    })
    //回车事件
    /*$(function(){

        $(window).keydown(function(e){
            if(e.keyCode==13){
                sublogin();
            }
        });

    });*/

</script>
</body>
</html>


