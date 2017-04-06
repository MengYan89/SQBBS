<%@page import="service.LoginService"%>
<%@page import="util.StringUtils"%>
<%@page import="com.my.bean.User" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	//System.out.println(username);
	//System.out.println(password);
	if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
		out.print("-1");// -1账号或密码为空
	}else{
	
		LoginService loginService = new LoginService();
		
		User user = loginService.getUser(username);
		
		if (user == null){
			out.print("-2");  //用户名不存在
		}else{
			
			if(!username.equals(user.getUsername()) || !password.equals(user.getPassword())){
				out.print("-3"); //用户名密码不正确
			}else{
				
				out.print("1");
				session.setAttribute("user", user);
				session.setAttribute("username", user.getUsername());
			}
		
		
		}
	
	}
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'loginController.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
