<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'purviewError.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link rel="stylesheet" type="text/css" href="<%=basePath%>images/main.css">
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script>
function changetoen(){
	document.getElementById("main").style.display='block';
	$(".zh").hide();
}
function changetozh(){
	$(".zh").show();
	document.getElementById("main").style.display='none';
}
</script>
  
  <body>
    	<div id="main">
    <header id="header">
      <h1><span class="icon">!</span>ERROR<span class="sub">权限不足</span></h1>
    </header>
    <div id="content">
      <h2>你所访问的页面因为权限不足而被拒绝</h2>
      <p>访问的权限和您登陆的角色有关，请以相应的角色登陆!</p>
      <div class="utilities">
        <form>
          <div class="input-container">
           
          </div>
        </form>
        <a class="button right" href="#" onClick="history.go(-1);return true;">Go Back...</a>
        <div class="clear"></div>
      </div>
    </div>
   
  </div>
  <!-- zh -->
    <div id="main" class="zh" style="display:none">
    <header id="header">
      <h1><span class="icon">!</span>ERROR<span class="sub">权限不足</span></h1>
    </header>
    <div id="content">
      <h2><br>您所请求的页面因为权限不足被拒绝访问</h2>
      <p><br>
      　　访问权限和您登陆的角色有关，请以相应的角色登陆！</p>
      <div class="utilities">
        <form>
          <div class="input-container">
            <input type="text" class="left" id="search" placeholder="搜索..." />
            <button id="search"></button>
          </div>
        </form>
        <a class="button right" href="#" onClick="history.go(-1);return true;">返回...</a>
        <div class="clear"></div>
      </div>
  </div>
  </div>
  </body>
</html>
