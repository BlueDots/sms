<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'mainfra.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>½­Î÷Å©Òµ´óÑ§Ñ§Éú¹¤×÷¹ÜÀíÏµÍ³</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="<%=basePath%>css/css.css" rel="stylesheet" type="text/css" />
 <script language=Javascript> 
  function time(){
    //»ñµÃÏÔÊ¾Ê±¼äµÄdiv
    t_div = document.getElementById('showtime');
   var now=new Date()
    //Ìæ»»divÄÚÈÝ 
   t_div.innerHTML = "当前时间:"+now.getFullYear()
    +"年"+(now.getMonth()+1)+"月"+now.getDate()
    +"日"+now.getHours()+"时"+now.getMinutes()
    +"分"+now.getSeconds()+"秒";
    //µÈ´ýÒ»ÃëÖÓºóµ÷ÓÃtime·½·¨£¬ÓÉÓÚsettimeoutÔÚtime·½·¨ÄÚ£¬ËùÒÔ¿ÉÒÔÎÞÏÞµ÷ÓÃ
   setTimeout(time,1000);
  }
</script>
</head>

<body onload="time()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="59" background="<%=basePath%>images/top.gif"><table width="99%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="2%"></img><img src="<%=basePath%>images/logo.jpg" width="557" height="59" /></td>
        <td width="64%" align="right"> </td>
        <td width="34%" background="<%=basePath%>images/nav01.gif" height="59">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
          <td width="25%"><img src="<%=basePath%>images/ico02.gif" width="40" height="35" /></td>
          <td width="75%" height="22" class="left-font01" rowspan="2">你好<span class="left-font02">&nbsp院级工作人员&nbsp &nbsp &nbsp<a href="<%=basePath%>files/college/mainfra.jsp" target="mainFrame">返回首页</a></span>
          <br><br> <div id="showtime"></div></td>
          </tr>
          <tr>
          <td height="22" class="left-font01">
            [&nbsp;<a href="<%=basePath%>login.html" target="_top" class="left-font01">退出</a>&nbsp;]
            </td>
            <td></td>
          </tr>
        </table>
      </td>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
