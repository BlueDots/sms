<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(<%=basePath%>/images/left.gif);
}
-->
</style>
<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
</head>

<script language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="<%=basePath%>/images/ico05.gif";//
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="<%=basePath%>/images/ico06.gif";}//
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="<%=basePath%>/images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="<%=basePath%>/images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="<%=basePath%>/images/ico04.gif";
	}
}

</script>

</head>
  
<body>

<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
		 	 <tr>
				<td width="207" height="55" background="<%=basePath%>/images/nav01.gif">
					<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
					  <tr>
						<td width="25%" rowspan="2"><img src="<%=basePath%>/images/ico02.gif" width="35" height="35" /></td>
						<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">院级管理员</span></td>
					  </tr>
					  <tr>
						<td height="22" class="left-font01">
							[&nbsp;<a href="<%=basePath%>/login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
					  </tr>
					</table>
				</td>
		 	 </tr>
			</table>
		<!--	
		<!-- 学生信息管理 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="<%=basePath%>/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="admin_xinxi.html" target="mainFrame" class="left-font03" onClick="tupian('18');" >学生信息管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </table>
		

		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="<%=basePath%>/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="./admin_teacherInfo.html" target="mainFrame" class="left-font03">教师信息管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </table>
     -->
		
		
		<!--  角色管理    -->
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="<%=basePath%>/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="<%=basePath%>/RoleManager/role!roleExecute" target="mainFrame" class="left-font03">角色管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </table>
        
		<!--  角色管理    -->
		
		
		<!--  院级管理员分配权限管理   -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
       <tr>
         <td height="29">
						<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td width="8%"><img name="img8" id="img8" src="<%=basePath%>/images/ico04.gif" width="8" height="11" /></td>
								<td width="92%">
									<a href="<%=basePath%>/files/college_admin/admin_userPurview.jsp" target="mainFrame" class="left-font03">分配权限管理</a>
								</td>
							</tr>
						</table>
				</td>
       </tr>		  
    </table>
    
    <!--  院级管理员分配角色管理   -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
       <tr>
         <td height="29">
						<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td width="8%"><img name="img8" id="img8" src="<%=basePath%>/images/ico04.gif" width="8" height="11" /></td>
								<td width="92%">
									<a href="<%=basePath%>/TecRole/allocation!tecRoleDisplay" target="mainFrame" class="left-font03">分配角色管理</a>
								</td>
							</tr>
						</table>
				</td>
       </tr>		  
    </table>
		
		<!--  院级管理员权限管理    -->
		

		<!--  院级管理员专业方向及班级管理    -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="./images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="admin_school.html" target="mainFrame" class="left-font03" onClick="tupian('21');">专业方向及班级管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </table>
		
		<!--  院级管理员专业方向及班级管理   -->
	  </td>
  </tr>
</table>
</body>
</html>
