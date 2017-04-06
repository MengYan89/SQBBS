<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引用公共配置 -->
<%@include file="common/taglib.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    
	<!-- 引用jQuery -->
    <script src="${basePath}/static/js/jQuery.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 引用自定义的css -->
	<link rel="stylesheet" type="text/css" href="${basePath}/static/css/custom.css">
	<style type="text/css">
		.content{
			width: 1100px;
			margin: 0 auto;
			position: relative;
		}
		.background{
			margin-top: 30px;
			width: 1080px;
			height: 400px;
			display: inline-block;
			background:url(static/img/login-1.jpg) no-repeat center;
			background-positon: 100%, 100%;
		}
		.login-wrap{
			text-align:center;
			position: relative; /*相对定位*/
			height: 475px;/*高度*/
			margin: 10px 0 20px;/*设置上下外边距*/
			
			
		}
		.background img{
			height: 400px;
			width:  1040px;
			margin: 35px;
			
		}
		.login-box{
			display: inline-block;
			width: 230px;
			background-color:#2E2E2E;
			margin-right: 60px;
			margin-top: 35px;
			opacity: 0.6;
			
		}
		
		.login-box h2{
			margin:10px 40px 20px;
			color: #c8c8c8 ;
			opacity: 1;
		}
		
		
		
		.inputBox{
			display: inline-block;
			margin-bottom: 20px;
			margin-left: 10px;
			
		}
		
		.inputBox input{
			width: 200px;
  		   height: 25px;
 		   padding-left: 10px;
 		   line-height: 25px;
 		   font-size: 15px;
 		   background: #BDBDBD;
		    color: #464242;
 		   border: none;
  		  border-radius: 2px;
		}
		
		.login_btn{
		    width: 80px;
		    height: 46px;
		    font-size: 20px;
		    text-align: center;
		    color: #fff;
 		   font-family: 微软雅黑;
  		  background: #000000;
		    border-radius: 3px;
		    border: none;
		    cursor: pointer;
		}
	</style>
  </head>
  
  <body>
       <!-- header导航页面  -->
   	  <%@include file="common/header.jsp" %>
   	  <div id="content">
   	  	<div class="login-wrap">
   	  		<div class="background">
   	  			
   	  			<div class="login-box fr">
   	  				<h2>用户登陆</h2>
   	  				<div class="inputBox">
   	  					<input type="text" id="username"  autocomplete="on" maxlength="60" placeholder="请输入账号/邮箱/手机号">
   	  				</div>
   	  				<div class="inputBox">
   	  					<input type="password" id="password"  autocomplete="off" maxlength="60" placeholder="请输入密码">
   	  				</div>
   	  				<div class='inputBox'>
       					 <button class="login_btn" onclick="login()">登陆</button>
   					 </div>
   	  			</div>
   	  		</div>
   	  	</div>
   	  </div>
   	  
   	  <script>
   	  	function login(){
   	  		var username = $('#username').val();
   	  		var password = $('#password').val();
   	  		
   	  		$.ajax({
   	  			type: "post",//请求方式
   	  			url:"${basePath}/controller/loginController.jsp",//请求地址
   	  			data:{"username":username,"password":password},//传递至controller的json数据
   	  			error:function(){
   	  				alert("登陆出错");
   	  			},
   	  			success: function(data){//返回成功执行回调函数
   	  				if(data == -1){
   	  					alert("用户名和密码不能为空");
   	  				}else if(data == -2){
   	  					alert("用户名不存在");
   	  				}else if(data == -3){
   	  					alert("用户名或密码错误");
   	  				}else{
   	  					window.location.href = "${basePath}"
   	  				}
   	  			}
   	  		});


   	  		
   	  	}
   	  </script>
   	  
   	  <%@include file="common/footer.jsp" %>
  </body>
</html>
