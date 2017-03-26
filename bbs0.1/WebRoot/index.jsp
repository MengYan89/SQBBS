<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    int port = request.getServerPort();
    String basePath  = null;
    if(port==80){
        basePath = request.getScheme()+"://"+request.getServerName()+path;
    }else{
        basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    }
    request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>首页</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			/*去除浏览器padding与margin的默认值*/
			padding:0 ; /*外边距*/
			margin:0 ; /*内边距*/
		}
		/*标题栏样式*/
		.header {
			height: 60px;  /*高度*/
			background: #2E2E2E; /*背景颜色*/
		}
		/*标题栏中logo的样式*/
		.header .logo{
			color: #fff ; /*字体颜色*/
			line-height: 72px ;/*行高*/
			font-size: 30px; /*字体大小*/
			margin-left: 20px;/*左外边距*/
			display: inline-block;/*定义为行内块元素*/
			font-weight: 500 ;/*设置字体粗细*/
			float: left ; /*向左浮动*/
		}
		/*标题栏中导航的样式*/
		.header ul li {
			list-style: none ; /*去掉li前的小圆点标识*/
			float: left ;/*向左浮动*/
			color: #fff ; /*字体颜色*/
			display: inline-block;/*定义为行内块元素*/
			line-height: 72px ;/*行高*/
			width: 112px ; /*段落宽度*/
			height: 60px ; /*段落高度*/
			text-align: center ; /*将文本排列到中间*/
			cursor: pointer ; /*设置光标为pointer*/ 
		}
		/*导航中第一个元素*/
		.header ul li.first{
			margin-left: 30px;/*左外边距*/
		}
		/*修改默认a标签*/
		a {
		
			color: #fff;/*字体颜色*/
			text-decoration: none ;/*去除a标签默认的文本修饰*/
			
		}
		/*为导航按钮添加hover事件*/
		/*hover事件:修改鼠标所在元素的样式*/
		.header ul li:hover{
			background: #1C1C1C ;/*背景颜色*/
		}
		/*设置登陆注册样式*/
		.header .login {
			float: right ;/*向右浮动*/
			color: #fff;/*字体颜色*/
			line-height: 72px ;/*行高*/
			margin-right: 20px;/*右外边距*/
		}
		
		/*轮播图样式*/
		/*fl fr优化css*/
		.fl {float: left;}/*向左浮动*/
		.fr {float: right;}/*向右浮动*/
		ul li{list-style: none;}/*去除li前的标记*/
		.banner {
			height: 360px;/*高度*/
			width: 1024px;/*宽度*/
			margin-top: 2px;/*设置上外边框*/
			position: relative;/*相对定位*/
			overflow: hidden;/*隐藏溢出内容*/
			
		}
		.banner .content{
			width: 1060px;/*宽度*/
			height: 360px;/*高度*/
			margin: 20px auto;/*上下外边距为20px，左右自动适应*/
			position: relative;
			
		}
		
		.banner ul li img {
			width:1024px;/*宽度*/
			height:360px;/*高度*/
		}
		
		.banner .content ul{
			width: 10000px;/*宽度*/
			margin-left: -1024px;
		}
		.banner_left, .banner_right{
		   width: 160px;
		   height: 360px;
  		   display: inline-block;/*定义为行内块元素*/
  		   position: absolute;/*绝对定位*/
 		   background: #7fa5ea;
 		   left: -60px;
 		   top: 0;
 		   opacity: 0.6;
		}

		.banner_right{
 		   width: 160px;
 		   height: 360px;
 		   display: inline-block;/*定义为行内块元素*/
 		   position: absolute;/*绝对定位*/
 		   background: #7fa5ea;
 		   left: 924px;
  		   top: 0;
 		   opacity: 0.6;
		}
		
		
		.btn_left ,.btn_right{
			display: inline-block;
			width: 30px;
			height: 150px;
			background: url(${basePath}/static/img/dir.png) no-repeat;
			position: absolute;
			left: 120px;
			top: 112px;
			opacity: 0;
			transition: all ease 0.6s;
			cursor: pointer;
		}

		.btn_right{
			background-position: -29px 0;
			position: absolute;
			left: 16px;
			top: 112px;
		}
        
        .banner .content:hover .btn_left{
   		    opacity: 1;
        }

		.banner .content:hover .btn_right{
            opacity: 1;
		}
	</style>
  </head>
  
  <body>
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
   	  			<span><a href="javascript:void(0)">登陆</a></span>
   	  			<span>|</span>
   	  			<span><a href="javascript:void(0)">注册</a></span>
   	  		</div>
   	  </div>
   	  
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
    
    
    <script type="text/javascript">
    	var leftBtn = $('.btn_left').eq(0);
    	var rightBtn = $('.btn_right').eq(0);
    	var ul = $('.banner .content ul').eq(0);
    	
    	var index = 0;
    	var timer = null;
    	
    	var imgwidth = $('.banner .content ul li').width(); //获取轮播图片的宽度
		var len =  $('.banner .content ul li').length - 2//获取总共的图片数量
		
		function movePicture(){
  	 		 $('.banner .content ul').animate({'margin-left':-imgwidth * (index+1)},1000,function(){
      			  if(index == len){
         			   $(this).css('margin-left',-imgwidth);
         			   index = 0;
    		      }
    		      if(index == -1){
          			   $(this).css('margin-left',-imgwidth * len);
           			   index = len - 1;
      			  }
  			  });
		}
    	rightBtn.on('click',function(){
    		  clearTimeout(timer);
    		  timer = setTimeout(function(){
    		  index ++;
 		      movePicture();
    		  },500);
  			  
		});

		leftBtn.on('click',function(){
    		  clearTimeout(timer);
    		  timer = setTimeout(function(){
    		  index --;
 		      movePicture();
    		  },500);
		});
    </script>
  </body>
</html>
