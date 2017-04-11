<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header">
   	  		<div class="logo">少女前线</div>
   	  		<ul>
   	  			<li class="first"><a href="javascript:void(0)">首页</a></li>
   	  			<li><a href="javascript:void(0)">攻略</a></li>
   	  			<li><a href="javascript:void(0)">热门话题</a></li>
   	  			<li><a href="javascript:void(0)">欣赏图集</a></li>
   	  			<li><a href="javascript:void(0)">建造查询</a></li>
   	  		</ul>
   	  		<div class="login">
   	  		 <c:choose>
   	  		 	<c:when test="${empty sessionScope.username }">
   	  		 		<span><a href="login.jsp">登陆</a></span>
   	  				<span>|</span>
   	  				<span><a href="javascript:void(0)">注册</a></span>
   	  		 	</c:when>
   	  		 	<c:otherwise>
   	  		 		<span><a href="javascript:void(0)">${sessionScope.username}</a></span>
   	  		 		<span>|</span>
   	  				<span><a href="${basePath}/controller/logoutController.jsp">注销</a></span>
   	  		 	</c:otherwise>
   	  		</c:choose>
   	  		</div>
</div>
