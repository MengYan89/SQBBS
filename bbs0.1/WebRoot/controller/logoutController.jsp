<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//注销
	session.removeAttribute("username");
	session.removeAttribute("user");
	session.invalidate();
	
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	response.sendRedirect(basePath+"/index.jsp");
%>

