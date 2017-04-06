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

