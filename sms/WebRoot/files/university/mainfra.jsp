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
  	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.10.2.js"></script>
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

    $(document).ready(function(){
    //$.ajaxSettings.async = false;

	$.getJSON("sysPurviewConfig/sessionPurview!setSessionPurview",function(data){
	
    	var zNodes =[{id:1,pid:0,name:"功能模块",open:true}];
    
	    for(var o in data){  
	        
	        zNodes.push({ id:data[o].id, pId:data[o].pid, name:data[o].purviewName,url:"files/university"+data[o].purviewUrl,target:"mainFrame"});
	        
     	}  
    
    zNodes.push(
      { id:2, pId:0, name:"软件学院"},
      { id:21, pId:2, name:"物联网", open:true},
      { id:22, pId:2, name:"软件英语"},
      { id:23, pId:2, name:"软件开发"},
      { id:3, pId:0, name:"外语学院", isParent:true},
      { id:4, pId:0, name:"农学院", isParent:true},
      { id:5, pId:0, name:"园林与艺术学院", isParent:true},
      { id:6, pId:0, name:"动物科学技术学院", isParent:true},
      { id:7, pId:0, name:"工学院", isParent:true},
      { id:8, pId:0, name:"理学院", isParent:true},
      { id:9, pId:0, name:"国土资源与环境学院", isParent:true},
      { id:10, pId:0, name:"计算机与信息工程学院", isParent:true},
      { id:11, pId:0, name:"经济管理学院", isParent:true},
      { id:12, pId:0, name:"食品科学与工程学院", isParent:true},
      { id:13, pId:0, name:"职业师范（技术）学院", isParent:true},
      { id:14, pId:0, name:"生物科学与工程学院", isParent:true},
      { id:15, pId:0, name:"马克思主义学院", isParent:true},
      { id:16, pId:0, name:"继续教育学院", isParent:true}
      );
    
      $.fn.zTree.init($("#treeDemo"), setting, zNodes);
      
      });

    }); 

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
