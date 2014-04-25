<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=basePath%>/js/admin/jquery-1.7.2.min.js"></script>

<script language="javascript">  
        (function($){
    $(document).ready(function(){
        $(".redirect").doRedirect(3);
        
    });
 
    /*
     * @example
     * HTML: <div class="redirect" link="http://zjmainstay.cn">3</div>秒后跳转
     * JS:   $(".redirect").doRedirect(3);
     * 时间顺序为：html > 函数参数 > 默认值3秒
     */
    $.fn.extend({
        doRedirect: function(timeout){
            //避免通用引入时，不存在指定对象也跳转
            if(!$(this).size()) return false;
 
            var time = $(this).text();
            if(time != '' && !isNaN(time)) {
                timeout = time;
            }
            if(typeof timeout == "undefined") timeout = 3;
 
            $This   = $(this);
            $.redirectTimer = setInterval(function() {
                timeout--;
                if(timeout == 0) {
                    clearInterval($.redirectTimer);
                    location.href = $This.attr("href");
                } else {            
                    $This.text(timeout);
                }
            }, 1000);
        }
    });
})(jQuery); 


function returns(){

	window.open('index_admin.jsp','_top');

} 
</script>

</head>
  
  <body>  	  
         操作成功<br/>  
    <a class="redirect" onclick="javascript:returns();">3</a>秒后跳转  
  </body>
</html>
