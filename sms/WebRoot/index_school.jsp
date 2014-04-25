<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>江西农业大学学生工作管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

 <frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="files/top.html" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="files/university/mainfra.html" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes>
  <body>
    This is my JSP page. <br>
  </body>
  </noframes>
=======
  <frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
  		<frame src="files/university/top.jsp" name="topFrame"  noresize="noresize" id="topFrame" title="topFrame" />
		<frameset cols="*" frameborder="no" border="0" framespacing="0">
		   	 <frame src="files/university/mainfra.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />	   	 
		</frameset>
	</frameset>
  <body>
  </body>
>>>>>>> f31ed4e78f664d4a15cae297d7490fe2b7be40d3
</html>
