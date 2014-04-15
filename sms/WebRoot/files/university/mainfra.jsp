<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@  taglib prefix="s" uri="/struts-tags" %>
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
	<link rel="stylesheet" href="<%=basePath%>/css/zTreeStyle/demo.css" type="text/css">
  	<link rel="stylesheet" href="<%=basePath%>/css/zTreeStyle/zTreeStyle.css" type="text/css">
  	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.4.4.min.js"></script>
 	<script type="text/javascript" src="<%=basePath%>/js/jquery.ztree.core-3.5.js"></script>

	<script type="text/javascript">
    //<!-- 
    var setting = {
      data: {
        simpleData: {
          enable: true
        }
      }
    };

	var zNodes =[
      { id:1, pId:0, name:"功能模块", open:true},
      { id:11, pId:1, name:"教师基本信息",url:"files/university/sch_teacherBasicInfo.jsp", target:"mainFrame"},
 	 ];

	 $(document).ready(function(){
      	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });
/*
    $(document).ready(function(){
    
	$.getJSON("display!itemDisplay?uid=1234",function(data){
	
    	var zNodes =[{id:1,pid:0,name:"功能模块",open:true},{id:2,pid:1,name:"教师基本信息模块",url:"sch_teacherBasicInfo.jsp",open:true}];
    
	    for(var o in data){  
	        
	        zNodes.push({ id:data[o].id, pId:data[o].pid, name:data[o].purviewName,url:"files/university"+data[o].purviewUrl,target:"mainFrame"});
	        
     	 }  
    
      $.fn.zTree.init($("#treeDemo"), setting, zNodes);
      
      });
      
    }); 
*/
    //-->
  </script>

  </head>
  
 <body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
      <div class="content_wrap">
          <div class="zTreeDemoBackground left">
              <ul id="treeDemo" class="ztree"></ul>
          </div>
      </div>
    </td>
    <td><img src="<%=basePath%>/images/welcome.gif"></td>
  </tr>
</table>

</body>
</html>
