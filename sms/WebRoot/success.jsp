<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>操作成功</title>
    
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
      <h1><span class="icon">!</span>OK<span class="sub">操作成功</span></h1>
    </header>
    <div id="content">
      <h2>操作成功，正在３秒跳转</h2>
      <p>等不及了，现在就<a href="">跳</a>!</p>
      <div class="utilities">
        
        
        <div class="clear"></div>
      </div>
    </div>
   
  </div>
  
  </body>
</html>
