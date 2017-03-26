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
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		/*去除浏览器padding与margin的默认值*/
		*{
			padding: 0;
			margin: 0;
		}
		/*fl fr优化css*/
		.fl {float: left;}/*向左浮动*/
		.fr {float: right;}/*向右浮动*/
		ul li{list-style: none;}/*去除li前的标记*/
		.banner {
			height: 360px;/*高度*/
			width: 1220px;/*宽度*/
			margin-top: 20px;/*设置上外边框*/
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
  		   display: inline-block;
  		   position: absolute;
 		   background: #7fa5ea;
 		   left: -160px;
 		   top: 0;
 		   opacity: 0.6;
		}

		.banner_right{
 		   width: 200px;
 		   height: 360px;
 		   display: inline-block;
 		   position: absolute;
 		   background: #7fa5ea;
 		   left: 1023px;
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
