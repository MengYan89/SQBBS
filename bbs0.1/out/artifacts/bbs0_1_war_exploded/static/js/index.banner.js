		var leftBtn = $('.btn_left').eq(0);
    	var rightBtn = $('.btn_right').eq(0);
    	var ul = $('.banner .content ul').eq(0);
    	
    	var index = 0;
    	var timer = null;
    	
    	var imgwidth = $('.banner .content ul li').width(); //获取轮播图片的宽度
		var len =  $('.banner .content ul li').length - 2//获取总共的图片数量
		//利用jQ的中animate的滚动函数，通过改变左外边距使其滚动起来，滚动时长为1000normal,animate执行结束后，将执行判断是否滚动至第一张与最后一张
		function movePicture(){
  	 		 $('.banner .content ul').animate({'margin-left':-imgwidth * (index+1)},1000,function(){
  	 			 //为了达到无缝滚动的目的所编写的判断函数，在执行animate后执行
      			  if(index == len){
      				  //如果index==len的话，将轮播图调节至最初的状态，并设定index=0
         			   $(this).css('margin-left',-imgwidth);
         			   index = 0;
    		      }
    		      if(index == -1){
    		    	  //如果index==-1的话，将轮播图调制最后一张图片处（此处的最后一张图不包括为了达到无缝效果添加的那两张）,并设定index=len-1
          			   $(this).css('margin-left',-imgwidth * len);
           			   index = len - 1;
      			  }
  			  });
		}
		
    	rightBtn.on('click',function(){
    		  clearTimeout(timer);
    		  //在点击后0.5s执行滚动函数,且0.5秒内无论点击多少次只执行一次
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