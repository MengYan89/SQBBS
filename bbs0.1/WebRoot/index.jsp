<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引用公共配置 -->
<%@include file="common/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>首页</title>
    <!-- 引用jQuery -->
    <script src="${basePath}/static/js/jQuery.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 引用自定义的css -->
	<link rel="stylesheet" type="text/css" href="${basePath}/static/css/custom.css">
  </head>
  
  <body>
   	  <!-- header导航页面  -->
   	  <%@include file="common/header.jsp" %>
   	  <!-- 轮播框  -->
   	   <div class="banner">
    	<div class='content'>
    		<ul>
    			<li class='fl'>
    				<a href="javascript:void(0)">
    					<img src="${basePath}/static/img/3.jpg"/>
    				</a>
    			</li>
    			
    			<li class='fl'>
    				<a href="javascript:void(0)">
    					<img src="${basePath}/static/img/1.jpg"/>
    				</a>
    			</li>
    			
    			<li class='fl'>
    				<a href="javascript:void(0)">
    					<img src="${basePath}/static/img/2.jpg"/>
    				</a>
    			</li>
    			
    			<li class='fl'>
    				<a href="javascript:void(0)">
    					<img src="${basePath}/static/img/3.jpg"/>
    				</a>
    			</li>
    			
    			<li class='fl'>
    				<a href="javascript:void(0)">
    					<img src="${basePath}/static/img/1.jpg"/>
    				</a>
    			</li>
    		</ul>
    		<span class='banner_left'><i class='btn_left'></i></span>
			<span class='banner_right'><i class='btn_right'></i></span>
    	</div>
    </div>
    <!-- 引用轮播框的js -->
    <script language="javascript" src="${basePath}/static/js/index.banner.js"></script>
    
    <%@include file="common/footer.jsp" %>
  </body>
</html>
